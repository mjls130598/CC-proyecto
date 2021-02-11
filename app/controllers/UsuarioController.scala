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

    def signup() = Action { implicit request: Request[AnyContent] =>

        val json = request.body.asJson.get

        val correo = (json \ "correo").as[String]
        val nombre = (json \ "nombre").as[String]
        val carrera = (json \ "carrera").as[String]
        val universidad = (json  \ "universidad").as[String]

        SharingNotes.aniadirUsuario(new Usuario(nombre, correo, carrera, universidad))

        Created("Usuario registrado").withSession("usuario" -> correo)
    }
}