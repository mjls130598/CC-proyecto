import org.scalatest.FunSuite
import Buscador._
import java.io.File

class BuscadorTest extends FunSuite {

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
}
