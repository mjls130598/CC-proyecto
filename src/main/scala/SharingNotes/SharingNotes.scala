package SharingNotes

import scala.collection.mutable.HashMap
import java.io.File
import org.apache.tika.detect._
import org.apache.tika.metadata._
import org.apache.tika.mime._
import org.apache.tika.io._
import org.apache.tika.Tika
import java.util.Calendar
import scala.annotation.tailrec
import scala.util.Random
import org.apache.hadoop.conf.Configuration
import org.apache.hadoop.fs.FileSystem
import org.apache.hadoop.fs.Path

class SharingNotes{

  var asignaturas = new HashMap[String, Asignatura]()
  var usuarios = new HashMap[String, Usuario]()
  var apuntes = new HashMap[String, Apunte]()
  var comentarios = new HashMap[String, Comentario]()
}

// Objeto que genera una cadena aleatoria
object RANStream {
  val randomAlphaNumIterator = Random.alphanumeric.iterator

  @tailrec
  def getRandomString(length: Int, acc: String = ""): String = {
    require(length >= 0, message = "length needs to be non-negative")
    if (length == 0) acc
    else getRandomString(length - 1, randomAlphaNumIterator.next().toString)
  }
}

// Clase "estática" SharingNotes

object SharingNotes{

  private val sharing = new SharingNotes()

  // Variables para controlar los identificadores

  val keyAsignatura = "ASIG"
  var keyApunte = "APUN"
  var keyComentario = "COM"

  // Método para generar identificadores únicos

  private def generateUiid(key: String): String = {
    val longTime = Calendar.getInstance().get(Calendar.MILLISECOND)
    val hexTime = longTime.toHexString
    val s = key + "_" + hexTime + "_" + RANStream.getRandomString(20)

    return s
  }

  // Método para añadir nuevos usuarios al programa

  def aniadirUsuario(usuario : Usuario): Unit = sharing.usuarios(usuario.correo) = usuario

  // Método para ver todos los usuarios guardados en el sistema

  def getUsuarios: HashMap[String, Usuario] = sharing.usuarios

  // Método para añadir nuevas asignaturas al sistema

  def aniadirAsignatura(nombre : String, curso : String, carrera : String,
     universidad : String): String = {

    var id = ""

    do {
      id = generateUiid(keyAsignatura)
    } while (sharing.asignaturas.keys.exists(_ == id) || id == "")

    val asignatura = new Asignatura(id, nombre, curso, carrera, universidad)
    sharing.asignaturas(id) = asignatura

    return id
  }

  // Método para borrar una asignatura del sistema

  def borrarAsignatura(id : String): Unit = {

    // Primero se borra los apuntes de esa asignatura

    val notes = buscarApuntes(sharing.asignaturas(id))
    notes.map(n => borrarApunte(n.identificador))

    // A continuación, se elimina su directorio de la memoria del sistema

    new File("./documentos/" + id).delete()

    // Por último, se borra la asignatura
    sharing.asignaturas -= id

  }

  // Método para ver todas las asignaturas guardadas

  def getAsignaturas : HashMap[String, Asignatura] = sharing.asignaturas

  // Método para añadir nuevos apuntes

  def aniadirApunte(url: String, nom: String, asig: Asignatura, us: Usuario): String = {

    val nombre = url.split("[/ | \\\\]+").last

    // Función para saber si es un PDF

    def esPDF(file: File) = {
      val input = TikaInputStream.get(file)
      val pdfContent = "%PDF-1.4\n%\\E2\\E3\\CF\\D3"
      val tika = new Tika()
      tika.detect(input) == tika.detect(pdfContent.getBytes)
    }

    // Sólo se admiten archivos PDF

    if(esPDF(new File(url))){

      var id = ""

      do {
        id = generateUiid(keyApunte)
      } while (sharing.asignaturas.keys.exists(_ == id) || id == "")

      val ubicacion = "./documentos/" + asig.identificador + "/" + nombre

      // Guardar el fichero dado en la memoria del sistema

      val hadoopConf = new Configuration()
      val hdfs = FileSystem.get(hadoopConf)

      // Para que no se guarden los ficheros que utiliza Hadoop para realizar una copia exacta
      hdfs.setWriteChecksum(false)
      hdfs.setVerifyChecksum(false)

      val srcPath = new Path(url)
      val destPath = new Path(ubicacion)
      hdfs.copyFromLocalFile(srcPath, destPath)

      val apunte = new Apunte (id, ubicacion, nom, asig, us)
      sharing.apuntes(id) = apunte

      return id
    }

    return ""
  }

  // Método para borrar un apunte

  def borrarApunte(id: String) : Unit = {

    // Antes de borrar el apunte, se borran los comentarios que se hayan
    // realizado sobre él

    val coments = buscarComentarios(sharing.apuntes(id))
    coments.map(c => borrarComentario(c.identificador))

    // A continuación, se elimina su archivo de la memoria del sistema

    new File(sharing.apuntes(id).ubicacion).delete()

    // Por último se borra el apunte

    sharing.apuntes -= id
  }

  // Método para buscar apuntes de una asignatura

  def buscarApuntes(asignatura : Asignatura): List[Apunte] = {

    // Función que devuelve ese apunte si es de una asignatura dada

    def apunteAsignatura(x: Apunte) = if(x.asignatura == asignatura) List(x) else List()

    val notes = sharing.apuntes.values.toList
    return notes.flatMap(x => apunteAsignatura(x))
  }

  // Método para ver todos los apuntes del sistema

  def getApuntes : HashMap[String, Apunte] = sharing.apuntes

  // Método para añadir nuevos comentarios

  def aniadirComentario(coment: String, apunte: Apunte, usuario: Usuario): String = {

    var id = ""

    do {
      id = generateUiid(keyComentario)
    } while (sharing.asignaturas.keys.exists(_ == id) || id == "")

    val comentario = new Comentario(id, coment, usuario, apunte)
    sharing.comentarios(id) = comentario

    return id
  }

  // Método para borrar un comentario

  def borrarComentario(id: String): Unit = sharing.comentarios -= id

  // Método para buscar comentarios de un apunte

  def buscarComentarios(apunte : Apunte): List[Comentario] = {

    // Función que devuelve ese comentario si es de un apunte dado

    def comentarioApunte(x: Comentario) = if(x.apunte == apunte) List(x) else List()

    val coments = sharing.comentarios.values.toList
    return coments.flatMap(x => comentarioApunte(x))
  }

  // Método para obtener todos los comentarios guardados en el sistema

  def getComentarios: HashMap[String, Comentario] = sharing.comentarios
}
