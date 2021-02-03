package models.SharingNotes

import play.api.libs.json.Json

case class Usuario(nom: String, email: String, car: String, uni: String){

  val nombre: String = nom
  val correo: String = email
  val carrera: String = car
  val universidad: String = uni

  //                                                          //
  // Tareas que puede realizar cualquier usuario del sistema: //
  //                                                          //

  // Método para añadir un apunte

  def aniadirApunte(url: String, nom: String, asig: Asignatura): String =
     SharingNotes.aniadirApunte(url, nom, asig, this)

  // Método para buscar los apuntes de una asignatura

  def buscarApuntes(asignatura : Asignatura): List[Apunte] =
    SharingNotes.buscarApuntes(asignatura)

  // Método para añadir comentario

  def aniadirComentario(coment: String, apunte: Apunte): String =
    SharingNotes.aniadirComentario(coment, apunte, this)

  // Método para buscar los comentarios de un apunte

  def buscarComentarios(apunte : Apunte): List[Comentario] =
    SharingNotes.buscarComentarios(apunte)

}

object Usuario {

  implicit val usuarioFormat = Json.format[Usuario]
}
