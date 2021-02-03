package models.SharingNotes

import play.api.libs.json.Json

case class Asignatura (id: String, nom: String, cur: String, car: String, uni: String){

  val identificador: String = id
  val nombre: String = nom
  val curso: String = cur
  val carrera: String = car
  val universidad: String = uni
}

object Asignatura{

  implicit val asignaturaFormat = Json.format[Asignatura]
}
