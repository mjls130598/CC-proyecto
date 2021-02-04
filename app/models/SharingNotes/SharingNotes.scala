package models.SharingNotes

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
import uk.gov.hmrc.emailaddress._

import org.slf4j.LoggerFactory

class SharingNotes(){

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

  // Variable para poder escribir los mensajes de log

  private val logger = LoggerFactory.getLogger(getClass.getSimpleName)

  // Variables para controlar los identificadores

  private val keyAsignatura = "ASIG"
  private val keyApunte = "APUN"
  private val keyComentario = "COM"

  def valoresIniciales: Unit = {
    val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
    val admin = new Administrador()

    aniadirUsuario(usuario)
    aniadirUsuario(admin)

    val PGPI_ID = admin.aniadirAsignatura("PGPI", "1º", "MUII", "Granada")

    val PGPI_T1 = usuario.aniadirApunte("./documentos_prueba/Tema1_Definiciones.pdf",
      "Tema 1: Definiciones", getAsignaturas(PGPI_ID))

    val PGPIT1_C2 = usuario.aniadirComentario("Esto es un comentario cualquiera", getApuntes(PGPI_T1))
    val PGPIT1_C3 = usuario.aniadirComentario("Esto es otro comentario cualquiera", getApuntes(PGPI_T1))

    usuario.aniadirApunte("./documentos_prueba/Tema1_Definiciones.pdf",
      "Tema 1: Definiciones", getAsignaturas(PGPI_ID))
    usuario.aniadirApunte("./documentos_prueba/Tema2_Preparacióndeproyectos.pdf",
      "Tema 2: Preparación de proyectos", getAsignaturas(PGPI_ID))
  }

  // Método para generar identificadores únicos

  private def generateUiid(key: String): String = {
    val longTime = Calendar.getInstance().get(Calendar.MILLISECOND)
    val hexTime = longTime.toHexString
    val s = key + "_" + hexTime + "_" + RANStream.getRandomString(20)

    return s
  }

  // Método para añadir nuevos usuarios al programa

  def aniadirUsuario(usuario : Usuario): Boolean = {

    // Si el correo no existe y se ha escrito correctamente

    if (!sharing.usuarios.keys.exists(_ == usuario.correo) && EmailAddress.isValid(usuario.correo)){

      sharing.usuarios(usuario.correo) = usuario
      logger.info("Usuario creado y añadido al sistema")

      return true
    }

    logger.error("Dirección de correo incorrecta o ya utilizada")
    throw new Exception("Dirección de correo incorrecta o ya utilizada")
  }

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

    logger.info("Asignatura creada e insertada en el sistema")

    return id
  }

  // Método para borrar una asignatura del sistema

  def borrarAsignatura(id : String): Boolean = {

    // Primero se borra los apuntes de esa asignatura

    val notes = buscarApuntes(sharing.asignaturas(id))
    notes.map(n => borrarApunte(n.identificador))

    // A continuación, se elimina su directorio de la memoria del sistema

    new File("./documentos/" + id).delete()

    // Por último, se borra la asignatura
    sharing.asignaturas -= id

    logger.info("Borrada la asignatura {}", id)

    return true
  }

  // Método para ver todas las asignaturas guardadas

  def getAsignaturas : HashMap[String, Asignatura] = sharing.asignaturas

  // Método para añadir nuevos apuntes

  def aniadirApunte(url: String, nom: String, asig: Asignatura, us: Usuario): String = {

    if (sharing.asignaturas.values.exists(_ == asig)){

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
        } while (sharing.apuntes.keys.exists(_ == id) || id == "")

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

        logger.info("Apunte guardado correctamente")

        return id
      }

      logger.error("El archivo {} no es un PDF", url)
      
      throw new Exception("El archivo dado no es un PDF")

    }

    logger.error("No existe la asignatura {} en el sistema", asig.identificador)

    throw new Exception("No existe esa asignatura en el sistema")
  }

  // Método para borrar un apunte

  def borrarApunte(id: String) : Boolean = {

    // Antes de borrar el apunte, se borran los comentarios que se hayan
    // realizado sobre él

    val coments = buscarComentarios(sharing.apuntes(id))
    coments.map(c => borrarComentario(c.identificador))

    // A continuación, se elimina su archivo de la memoria del sistema

    new File(sharing.apuntes(id).ubicacion).delete()

    // Por último se borra el apunte

    sharing.apuntes -= id

    logger.info("Borrado apunte {}", id)

    return true
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

    if(sharing.apuntes.values.exists(_ == apunte)){
      var id = ""

      do {
        id = generateUiid(keyComentario)
      } while (sharing.comentarios.keys.exists(_ == id) || id == "")

      val comentario = new Comentario(id, coment, usuario, apunte)
      sharing.comentarios(id) = comentario

      logger.info("Comentario guardado correctamente en el sistema")

      return id
    }

    logger.error("Apunte {} no existe dentro del sistema", apunte.identificador)

    throw new Exception("El apunte sobre el que se quiere comentar no existe")
  }

  // Método para borrar un comentario

  def borrarComentario(id: String): Boolean = {

    sharing.comentarios -= id

    logger.info("Borrado correctamente el comentario {}", id)

    return true
  }

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
