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
class ApunteControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "ApunteController GET" should {

    val controller = new ApunteController(stubControllerComponents())

    "Comprueba que devuelve todos los apuntes" in {
      val home = controller.apuntes(None, None, None, None, None).apply(FakeRequest(GET, "/apunte"))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que devuelve los apuntes de una universidad" in {
      val home = controller.apuntes(Some("Granada"), None, None, None, None).apply(FakeRequest(GET, "/apunte"))

      status(home) mustBe OK
      contentType(home) mustBe Some("text/plain")

    }

    "Comprueba que devuelve todos los apuntes de una asignatura" in {
      val home = controller.apuntesAsignatura(SharingNotes.getAsignaturas.last._1).apply(FakeRequest(GET, "/asignatura"))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que devuelve un error al consultar los apuntes de una asignatura" in {

      val home = controller.apuntesAsignatura("ASIG1234").apply(FakeRequest(GET, "/asignatura"))

      status(home) mustBe NOT_FOUND
    }

    "Comprueba que devuelve un apunte dado" in {
        
      val home = controller.apunte(SharingNotes.getApuntes.last._1).apply(FakeRequest(GET, "/apunte"))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que devuelve un error al consultar un apunte que no existe" in {

      val home = controller.apunte("APUN1234").apply(FakeRequest(GET, "/apunte"))

      status(home) mustBe NOT_FOUND
    }

    "Comprueba que guarda un apunte dado" in {
        
      val home = controller.addApunte().apply(FakeRequest(POST, "/apunte").withJsonBody(
        Json.parse(s"""{"asignatura":"${SharingNotes.getAsignaturas.last._1}", "usuario": "mjls130598@gmail.com",
          "url":"./documentos_prueba/Intro_TID.pdf", "nombre":"Intro"}""")
      ))

      status(home) mustBe OK
    }
  }
}