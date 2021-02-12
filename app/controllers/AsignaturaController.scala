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

    request.session.get("usuario").map { usuario =>
    
      if(usuario != "admin@admin.com")
        Unauthorized("No puedes borrar una asignatura")

      else{

        val user = new Administrador()
        user.aniadirAsignatura(nombre, curso, carrera, universidad)

        Created("Guardado correctamente")

      }
    }
    .getOrElse {
      Unauthorized("No puedes guardar una asignatura")
    }
  }

  def deleteAsignatura(id : String) = Action { implicit request: Request[AnyContent] =>

    request.session.get("usuario").map { usuario =>
    
      if(usuario != "admin@admin.com")
        Unauthorized("No puedes borrar una asignatura")

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
    .getOrElse {
      Unauthorized("No puedes borrar una asignatura")
    }
    
  }
}
