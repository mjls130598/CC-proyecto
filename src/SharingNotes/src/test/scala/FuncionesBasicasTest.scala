import SharingNotes._
import org.scalatest.FunSuite

class FuncionesBasicasTest extends FunSuite {

  val sharing = new SharingNotes()
  sharing.aniadirUsuario(new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada"))

  // Prueba de que se ha insertado un nuevo usuario al sistema
  test("Insertado nuevo usuario") {
    assertResult(1){
      sharing.usuarios.size
    }
  }

  
}
