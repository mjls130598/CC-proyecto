package controllers

import org.scalatestplus.play._
import org.scalatestplus.play.guice._
import play.api.test._
import play.api.test.Helpers._

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
  }
}