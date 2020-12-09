package SharingNotes

import scala.collection.mutable.HashMap
import java.io.File
import org.apache.tika.detect._
import org.apache.tika.metadata._
import org.apache.tika.mime._
import org.apache.tika.io._
import org.apache.tika.Tika

class SharingNotes{

  var asignaturas = new HashMap[String, Asignatura]()
  var usuarios = new HashMap[String, Usuario]()
  var apuntes = new HashMap[String, Apunte]()
  var comentarios = new HashMap[String, Comentario]()
}

// Clase "estática" SharingNotes

object SharingNotes{

  private val sharing = new SharingNotes()

  // Variables para controlar los identificadores

  var idAsig = 0
  var idApun = 0
  var idCom = 0

  // Método para añadir nuevos usuarios al programa

  def aniadirUsuario(usuario : Usuario): Unit = sharing.usuarios(usuario.correo) = usuario

  // Método para ver todos los usuarios guardados en el sistema

  def getUsuarios: HashMap[String, Usuario] = sharing.usuarios

  // Método para añadir nuevas asignaturas al sistema

  def aniadirAsignatura(nombre : String, curso : String, carrera : String,
     universidad : String): Unit = {

    idAsig += 1

    val id = "ASIG" + idAsig
    val asignatura = new Asignatura(id, nombre, curso, carrera, universidad)
    sharing.asignaturas(id) = asignatura
  }

  // Método para borrar una asignatura del sistema

  def borrarAsignatura(id : String): Unit = {

    // Primero se borra los apuntes de esa asignatura

    val notes = buscarApuntes(sharing.asignaturas(id))
    notes.map(n => borrarApunte(n.identificador))

    // Por último, se borra la asignatura
    sharing.asignaturas -= id

  }

  // Método para ver todas las asignaturas guardadas

  def getAsignaturas : HashMap[String, Asignatura] = sharing.asignaturas

  // Método para añadir nuevos apuntes

  def aniadirApunte(url: String, nom: String, asig: Asignatura, us: Usuario): Unit = {

    val nombre = url.split("/ | \\\\").last

    // Método para saber si es un PDF
    def esPDF(file: File) = {
      val input = TikaInputStream.get(file)
      val pdfContent = "%PDF-1.4\n%\\E2\\E3\\CF\\D3" // i.e. base64 decoded
      val tika = new Tika()
      tika.detect(input) == tika.detect(pdfContent.getBytes)
    }

    // Sólo se admiten archivos PDF

    if(esPDF(new File(url))){

      idApun += 1

      val id = "APUN" + idApun
      val ubicacion = "./" + asig.identificador + "/" + nombre

      val apunte = new Apunte (id, ubicacion, nom, asig, us)
      sharing.apuntes(id) = apunte
    }
  }

  // Método para borrar un apunte

  def borrarApunte(id: String) : Unit = {

    // Antes de borrar el apunte, se borran los comentarios que se hayan
    // realizado sobre él

    val coments = buscarComentarios(sharing.apuntes(id))
    coments.map(c => borrarComentario(c.identificador))

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

  def aniadirComentario(coment: String, apunte: Apunte, usuario: Usuario): Unit = {

    idCom += 1

    val id = "COM" + idCom
    val comentario = new Comentario(id, coment, usuario, apunte)
    sharing.comentarios(id) = comentario
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
