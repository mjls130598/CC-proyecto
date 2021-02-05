package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

import models.SharingNotes._

@Singleton
class AsignaturaController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def addAsignatura = Action { implicit request: Request[AnyContent] =>

    val json = request.body.asJson.get

    val nombre = (json \ "nombre").as[String]
    val curso = (json \ "curso").as[String]
    val universidad = (json \ "universidad").as[String]
    val carrera = (json \ "carrera").as[String]
    val usuario = (json \ "usuario").as[String]

    if (usuario != "admin@admin.com")
        Unauthorized("No tienes permiso")

    else {

        val user = new Administrador()
        user.aniadirAsignatura(nombre, curso, carrera, universidad)

        Created("Guardado correctamente")
    }
  }

  def deleteAsignatura(id : String, usuario: String) = Action { implicit request: Request[AnyContent] =>

    if(usuario != "admin@admin.com")
      Unauthorized("No puedes borrar un apunte")

    else{
      
      val asignatura = SharingNotes.getAsignaturas(id)

      if(asignatura != null){

        SharingNotes.borrarAsignatura(id)

        Ok("Asignatura borrada correctamente")
      }

      else 
        NotFound("Asignatura no encontrada")

    }
  }
}
