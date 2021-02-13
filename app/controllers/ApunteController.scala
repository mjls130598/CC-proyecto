package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

import models.SharingNotes._

@Singleton
class ApunteController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

  def apuntes(universidad: Option[String], carrera: Option[String],
    asignatura: Option[String], apunte: Option[String],
    curso: Option[String]) = Action { implicit request: Request[AnyContent] =>
    
    if(carrera == None && universidad == None && asignatura == None
      && apunte == None && curso == None){

      val apuntes = SharingNotes.getApuntes
      Ok(Json.toJson(apuntes.values.toList))
    }

    else
      Ok(Json.toJson("Aún nada"))
  }

  def apuntesAsignatura (id: String) = Action { implicit request: Request[AnyContent] =>
  
    val apuntes = SharingNotes.buscarApuntes(SharingNotes.getAsignaturas(id))

    if(apuntes.nonEmpty)
      Ok(Json.toJson(apuntes))
    
    else
      NotFound(Json.toJson("Asignatura no encontrada"))
  }

  def apunte (id: String) = Action { implicit request: Request[AnyContent] =>
  
    val apunte = SharingNotes.getApuntes(id)

    if(apunte != null)
      Ok(Json.toJson(apunte))

    else
      NotFound

  }

  def addApunte = Action { implicit request: Request[AnyContent] =>
    val json = request.body.asJson.get

    val url = (json \ "url").as[String]
    val nombre = (json \ "nombre").as[String]
    val asignatura = SharingNotes.getAsignaturas((json \ "asignatura").as[String])
    
    request.session.get("usuario").map { correo =>

      val usuario = SharingNotes.getUsuarios(correo)
    
      usuario.aniadirApunte(url, nombre, asignatura)

      Created(Json.toJson("Apunte guardado correctamente"))

    }
    .getOrElse {
      Unauthorized(Json.toJson("No puedes guardar un apunte"))
    }
  }

  def deleteApunte(id : String) = Action { implicit request: Request[AnyContent] =>

    request.session.get("usuario").map { correo =>
    
      if(correo != "admin@admin.com")
        Unauthorized(Json.toJson("No puedes borrar un apunte"))

      else{
        
        val apunte = SharingNotes.getApuntes(id)

        if(apunte != null){

          SharingNotes.borrarApunte(id)

          Ok(Json.toJson("Apunte borrado correctamente"))
        }

        else 
          NotFound(Json.toJson("Apunte no encontrado"))

      }
    }
    .getOrElse {
      Unauthorized(Json.toJson("No puedes borrar un apunte"))
    }    
  }
}
