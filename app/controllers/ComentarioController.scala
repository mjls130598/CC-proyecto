package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

import models.SharingNotes._

@Singleton
class ComentarioController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

    def comentariosApunte(id: String) = Action { implicit request: Request[AnyContent] =>
  
    val comentarios = SharingNotes.buscarComentarios(SharingNotes.getApuntes(id))

    if(comentarios.nonEmpty)
      Ok(Json.toJson(comentarios))
    
    else
      NotFound
  }
}
