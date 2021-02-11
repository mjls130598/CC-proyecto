package controllers

import javax.inject._
import play.api._
import play.api.mvc._
import play.api.libs.json._

import models.SharingNotes._

@Singleton
class UsuarioController @Inject()(val controllerComponents: ControllerComponents) extends BaseController {

    def login() = Action { implicit request: Request[AnyContent] =>

        val json = request.body.asJson.get

        val usuario = (json \ "usuario").as[String]

        if(SharingNotes.getUsuarios(usuario) != null)
            Ok("Iniciado sesión correctamente").withSession("usuario" -> usuario)

        else 
            NotFound("Usuario incorrecto")
    }
}