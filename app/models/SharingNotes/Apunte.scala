package models.SharingNotes

import play.api.libs.json.Json

case class Apunte(id: String, url: String, nom: String, asig: Asignatura, us: Usuario){

  val identificador: String = id 
  val ubicacion: String = url
  val nombre:String = nom
  val asignatura: Asignatura = asig
  val usuario: Usuario = us
}

object Apunte{

  implicit val apunteFormat = Json.format[Apunte]
}

