import SharingNotes._
import org.scalatest.FunSuite

class FuncionesBasicasTest extends FunSuite {

  val sharing = new SharingNotes()

  val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
  val admin = new Administrador()

  // Comprueba que se ha insertado los dos usuarios anteriores al sistema

  sharing.aniadirUsuario(usuario)
  sharing.aniadirUsuario(admin)

  test("Insertado nuevos usuarios correctamente") {
    assertResult(2){
      sharing.usuarios.size
    }
  }

  // Comprueba que se ha añadido una asignatura correctamente

  sharing.aniadirAsignatura("CC", "1º", "MUII", "Granada", admin)

  test("Insertada nueva asignatura correctamente"){
    assertResult(1){
      sharing.asignaturas.size
    }
  }

  // Comprueba que no se ha añadido una asignatura

  sharing.aniadirAsignatura("TID", "1º", "MUII", "Granada", usuario)

  test("No insertada en el sistema"){
    assertResult(1){
      sharing.asignaturas.size
    }
  }

  // Comprueba que se ha añadido un nuevo apunte

  sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)

  test("Insertado nuevo apunte correctamente"){
    assert(sharing.apuntes.keys.exists(_ == "APUN1"))
  }

  // Comprueba que se ha añadido el apunte correcto

  sharing.aniadirApunte("CC.doc", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)

  test("No insertado apunte con un formato erróneo"){
    assert(sharing.apuntes.keys.exists(_ != "APUN2"))
  }

  // Comprueba que se ha añadido un comentario correctamente

  sharing.aniadirComentario("Esto es un comentario cualquiera",
    sharing.apuntes("APUN1"), usuario)
    println(sharing.comentarios.keys.toString)

  test("Insertado nuevo comentario correctamente"){
    assert(sharing.comentarios.keys.exists(_ == "COM1"))
    assert(sharing.comentarios.values.exists(_.apunte == sharing.apuntes("APUN1")))
  }

  // Comprueba que se ha borrado el comentario anteriormente insertado correctametne

  sharing.aniadirComentario("Esto es otro comentario cualquiera",
    sharing.apuntes("APUN1"), usuario)
    println(sharing.comentarios.keys.toString)
  sharing.borrarComentario("COM2", usuario)

  test("No se ha borrado al no ser un administrador"){
    assert(sharing.comentarios.keys.exists(_ == "COM2"))
  }

  sharing.aniadirComentario("Esto es el tercer comentario",
    sharing.apuntes("APUN1"), usuario)
    println(sharing.comentarios.keys.toString)

  sharing.borrarComentario("COM3", admin)

  test("Borrado el comentario correctamente"){
    assert(!sharing.comentarios.keys.exists(_ == "COM3"))
  }
}
