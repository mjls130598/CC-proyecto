import org.scalatest.FunSuite
import models.Buscador._
import models.SharingNotes._
import java.io.File

class BuscadorTest extends FunSuite {

  SharingNotes.resetearBD

  val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
  val admin = new Administrador()

  // Comprueba que se ha insertado los dos usuarios anteriores al sistema

  SharingNotes.aniadirUsuario(usuario)
  SharingNotes.aniadirUsuario(admin)

  val PGPI_ID = admin.aniadirAsignatura("PGPI", "1º", "MUII", "Granada")
  usuario.aniadirApunte("./documentos_prueba/Tema1_Definiciones.pdf",
    "Tema 1: Definiciones", SharingNotes.getAsignaturas(PGPI_ID))
  usuario.aniadirApunte("./documentos_prueba/Tema2_Preparacióndeproyectos.pdf",
    "Tema 2: Preparación de proyectos", SharingNotes.getAsignaturas(PGPI_ID))

  val TID_ID = admin.aniadirAsignatura("TID", "1º", "MUII", "Granada")
  usuario.aniadirApunte("./documentos_prueba/Intro_TID.pdf",
    "Tema 1 Introducción", SharingNotes.getAsignaturas(TID_ID))
  usuario.aniadirApunte("./documentos_prueba/PreparacionDatos.pdf",
    "Tema 2 Preparación de datos", SharingNotes.getAsignaturas(TID_ID))

  test("Obtener el texto del PDF Intro_TID.pdf"){
    assert(ExtraeTexto.textoPDF("./documentos_prueba/Intro_TID.pdf").length > 0)
  }

  test("Ver si se realiza la indexación de documentos"){

    new Indice().indexarDocumentos

    val facetas = new File("./facetas")
    val indice = new File("./indice")

    assert(facetas.exists)
    assert(facetas.list.length > 0)
    assert(indice.exists)
    assert(indice.list.length > 0)
    info("Los directorios donde se almacenan el índice y las facetas existen y contiene archivos dentro de ellos")
  }

  test("Ver si devuelve apuntes después de realizar el filtrado"){

    val apuntes = new Buscador().buscar(None, Some("Granada"), None, None, None)
    assertResult(4){
      apuntes.size
    }
  }

  test("Ver si devuelve apuntes después de realizar una consulta"){

    val apuntes = new Buscador().buscar(Some("datos"), None, None, None, None)
    assert(apuntes.size > 0)
  }
}
