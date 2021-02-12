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

      request.session.get("usuario").map { user =>

        val usuario = SharingNotes.getUsuarios(user)

        usuario.aniadirComentario(comentario, apunte)

        Created("Comentario guardado correctamente")
      }
      .getOrElse {
        Unauthorized("No puedes añadir un comentario")
      } 
    }

    def deleteComentario(id : String, usuario: String) = Action { implicit request: Request[AnyContent] =>

      if(usuario != "admin@admin.com")
        Unauthorized("No puedes borrar un comentario")

      else{
        
        val comentario = SharingNotes.getComentarios(id)

        if(comentario != null){

          SharingNotes.borrarComentario(id)

          Ok("Comentario borrado correctamente")
        }

        else 
          NotFound("Comentario no encontrado")

      }
    }
}
