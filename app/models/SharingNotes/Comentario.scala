package models.SharingNotes

import play.api.libs.json.Json

case class Comentario(id: String, coment: String, user: Usuario, apunt : Apunte){

  val identificador: String = id
  val comentario: String = coment
  val usuario: Usuario = user
  val apunte: Apunte = apunt
}

object Comentario {
  
  implicit val comentarioFormat = Json.format[Comentario]
}
