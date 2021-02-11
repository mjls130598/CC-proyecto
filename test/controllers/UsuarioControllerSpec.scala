package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._
import play.api.libs.json._

import models.SharingNotes._

/**
 * Add your spec here.
 * You can mock out a whole application including requests, plugins etc.
 *
 * For more information, see https://www.playframework.com/documentation/latest/ScalaTestingWithScalaTest
 */
class UsuarioControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "UsuarioController" should {

        SharingNotes.resetearBD
        val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
        SharingNotes.aniadirUsuario(usuario)

        val controller = new UsuarioController(stubControllerComponents())

        "Comprueba que inicia sesión un usuario que existe" in {
            val home = controller.login().apply(FakeRequest(POST, "/login").withJsonBody(
                Json.parse(s"""{"usuario": "${usuario.correo}"}""")))

            status(home) mustBe OK
        }

        "Comprueba que no inicia sesión un usuario que no existe" in {
            val home = controller.login().apply(FakeRequest(POST, "/login").withJsonBody(
                Json.parse(s"""{"usuario": "esteesuncorreo@email.com"}""")))

            status(home) mustBe NOT_FOUND
        }
    }
}