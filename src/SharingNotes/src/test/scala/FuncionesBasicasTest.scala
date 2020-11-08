import SharingNotes._
import org.scalatest.FunSuite

class FuncionesBasicasTest extends FunSuite {

  val sharing = new SharingNotes()

  val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
  val admin = new Administrador()

  // Prueba de que se ha insertado los dos usuarios anteriores al sistema

  sharing.aniadirUsuario(usuario)
  sharing.aniadirUsuario(admin)

  test("Insertado nuevos usuarios correctamente") {
    assertResult(2){
      sharing.usuarios.size
    }
  }

  // Prueba de que se ha añadido una asignatura correctamente

  sharing.aniadirAsignatura("CC", "1º", "MUII", "Granada", admin)

  test("Insertada nueva asignatura correctamente"){
    assertResult(1){
      sharing.asignaturas.size
    }
  }

  // Prueba de que no se ha añadido una asignatura

  sharing.aniadirAsignatura("TID", "1º", "MUII", "Granada", usuario)
  test("No insertada en el sistema"){
    assertResult(1){
      sharing.asignaturas.size
    }
  }

  // Prueba de que se ha añadido un nuevo apunte

  sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)
  test("Insertado nuevo apunte correctamente"){
    assert(sharing.apuntes.keys.exists(_ == "APUN1"))
  }

  // Prueba de que se ha añadido el apunte correcto

  sharing.aniadirApunte("CC.doc", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)
  test("No insertado apunte con un formato erróneo"){
    assert(sharing.apuntes.keys.exists(_ != "APUN2"))
  }
}
