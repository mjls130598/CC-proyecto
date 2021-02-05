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
class AsignaturaControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "AsignaturaController" should {

    SharingNotes.resetearBD

    val admin = new Administrador()
    val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
    SharingNotes.aniadirUsuario(admin)
    SharingNotes.aniadirUsuario(usuario)

    val controller = new AsignaturaController(stubControllerComponents())

    "Comprueba que guarda una asignatura dada" in {
        
        val home = controller.addAsignatura().apply(FakeRequest(POST, "/asignatura").withJsonBody(
        Json.parse(s"""{"nombre":"CC", "usuario": "${admin.correo}",
            "universidad":"Universidad de Granada", "carrera":"MUII", "curso": "1º"}""")
        ))

        status(home) mustBe CREATED
    }

    "Comprueba que un usuario común no añadir una asignatura" in {

        val home = controller.addAsignatura().apply(FakeRequest(POST, "/asignatura").withJsonBody(
        Json.parse(s"""{"nombre":"CC", "usuario": "${usuario.correo}",
            "universidad":"Universidad de Granada", "carrera":"MUII", "curso": "1º"}""")
        ))

        status(home) mustBe UNAUTHORIZED
    }
  }
}