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

    def addComentario = Action { implicit request: Request[AnyContent] =>

        val json = request.body.asJson.get

        val comentario = (json \ "comentario").as[String]
        val apunte = SharingNotes.getApuntes((json \ "apunte").as[String])
        val usuario = SharingNotes.getUsuarios((json \ "usuario").as[String])

        usuario.aniadirComentario(comentario, apunte)

        Created("Comentario guardado correctamente")
    }
}
