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
    val PGPI_C1 = usuario.aniadirComentario("El primer comentarios", SharingNotes.getApuntes(PGPI_T1))

    val controller = new ComentarioController(stubControllerComponents())

    "Comprueba que devuelve todos los comentarios" in {
      val home = controller.comentariosApunte(PGPI_T1).apply(FakeRequest(GET, "/comentarios"))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que guarda un comentario sobre un apunte dado" in {
        
      val home = controller.addComentario().apply(FakeRequest(POST, "/comentarios").withSession("usuario" -> usuario.correo)
      .withJsonBody(
        Json.parse(s"""{"apunte":"$PGPI_T1","comentario":"El segundo comentarios sobre este apunte"}""")
      ))

      status(home) mustBe CREATED
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que no se guarda un comentario sobre un apunte dado de un usuario no registrado" in {
        
      val home = controller.addComentario().apply(FakeRequest(POST, "/comentarios").withJsonBody(
        Json.parse(s"""{"apunte":"$PGPI_T1","comentario":"El segundo comentarios sobre este apunte"}""")
      ))

      status(home) mustBe UNAUTHORIZED
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que un usuario común no borra un comentario" in {
      val home = controller.deleteComentario(PGPI_C1).apply(FakeRequest(DELETE, "/comentarios").
      withSession("usuario" -> usuario.correo))

      status(home) mustBe UNAUTHORIZED
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que un usuario no registrado no borra un comentario" in {
      val home = controller.deleteComentario(PGPI_C1).apply(FakeRequest(DELETE, "/comentarios"))

      status(home) mustBe UNAUTHORIZED
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que un comentario que no existe no se borrar" in {
      val home = controller.deleteComentario("COM1234").apply(FakeRequest(DELETE, "/comentarios").
      withSession("usuario" -> admin.correo))

      status(home) mustBe NOT_FOUND
      contentType(home) mustBe Some("application/json")
    }

    "Comprueba que se ha eliminado un comentario" in {
      val home = controller.deleteComentario(PGPI_C1).apply(FakeRequest(DELETE, "/comentarios").
      withSession("usuario" -> admin.correo))

      status(home) mustBe OK
      contentType(home) mustBe Some("application/json")
    }
  }
}