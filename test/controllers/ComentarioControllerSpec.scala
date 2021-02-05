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
class ComentarioControllerSpec extends PlaySpec with GuiceOneAppPerTest with Injecting {

  "ComentarioController" should {

    SharingNotes.resetearBD

    val admin = new Administrador()
    val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
    SharingNotes.aniadirUsuario(admin)
    SharingNotes.aniadirUsuario(usuario)
    val PGPI_ID = admin.aniadirAsignatura("PGPI", "1º", "MUII", "Granada")
    val PGPI_T1 = admin.aniadirApunte("./documentos_prueba/Tema1_Definiciones.pdf",
    "Tema 1: Definiciones", SharingNotes.getAsignaturas(PGPI_ID))
    val PGPI_C1 = usuario.aniadirComentario("El primer comentario", SharingNotes.getApuntes(PGPI_T1))

    val controller = new ComentarioController(stubControllerComponents())

    "Comprueba que devuelve todos los apuntes" in {
      val home = controller.comentariosApunte(PGPI_T1).apply(FakeRequest(GET, "/comentario"))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
    }
    
  }
}