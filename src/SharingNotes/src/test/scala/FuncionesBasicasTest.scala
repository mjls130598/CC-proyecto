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
    assert(sharing.apuntes.keys.exists(_ == "APUN2"))
  }

  // Comprueba que se ha añadido un comentario correctamente

  sharing.aniadirComentario("Esto es un comentario cualquiera",
    sharing.apuntes("APUN1"), usuario)

  test("Insertado nuevo comentario correctamente"){
    assert(sharing.comentarios.keys.exists(_ == "COM1"))
    assert(sharing.comentarios.values.exists(_.apunte == sharing.apuntes("APUN1")))
  }

  // Comprueba que un usuario normal no puede borrar un comentario

  sharing.aniadirComentario("Esto es otro comentario cualquiera",
    sharing.apuntes("APUN1"), usuario)

  sharing.borrarComentario("COM2", usuario)

  test("No se ha borrado por no ser un administrador"){
    assert(sharing.comentarios.keys.exists(_ == "COM2"))
  }

  // Comprueba que se ha borrado el comentario anteriormente insertado correctamente

  sharing.aniadirComentario("Esto es el tercer comentario",
    sharing.apuntes("APUN1"), usuario)

  sharing.borrarComentario("COM3", admin)

  test("Borrado el comentario correctamente"){
    assert(!sharing.comentarios.keys.exists(_ == "COM3"))
  }

  // Comprueba que se encuentra los comentarios de un apunte

  test("Se encuentran todos los comentarios de un apunte"){
    assertResult(2){
      sharing.buscarComentarios(sharing.apuntes("APUN1")).size
    }
  }

  // Comprueba que un usuario normal no puede eliminar un apunte

  sharing.aniadirApunte("Tema 2.pdf", "Tema 2 Test", sharing.asignaturas("ASIG1"), usuario)

  sharing.borrarApunte("APUN2", usuario)

  test("No se ha borrado el apunte por no ser el administrador"){
    assert(sharing.apuntes.keys.exists(_ == "APUN2"))
  }

  // Comprueba que se eliminan los apuntes correctamente

  sharing.aniadirApunte("Tema 3.pdf", "Tema 3 Docker", sharing.asignaturas("ASIG1"), usuario)

  sharing.borrarApunte("APUN3", admin)

  test("Borrado el apunte correctamente"){
    assert(!sharing.apuntes.keys.exists(_ == "APUN3"))
  }

  // Comprueba que se eliminan todos los comentarios sobre un apunte

  sharing.aniadirApunte("Tema 1.pdf", "Tema 1 Arquitectura", sharing.asignaturas("ASIG1"), usuario)

  sharing.aniadirComentario("Este es el cuarto comentario realizado", sharing.apuntes("APUN4"), usuario)

  sharing.borrarApunte("APUN4", admin)

  test("Borrado apunte y sus comentarios"){
    assert(!sharing.apuntes.keys.exists(_ == "APUN4"))
    assert(!sharing.comentarios.values.exists(_.apunte.identificador == "APUN4"))
  }

  // Comprueba que se encuentran los apuntes de una asignatura

  test("Se encuentran todos los apuntes de una asignatura"){
    assertResult(2){
      sharing.buscarApuntes(sharing.asignaturas("ASIG1")).size
    }
  }

  // Comprueba que un usuario normal no puede eliminar una asignatura

  sharing.borrarAsignatura("ASIG1", usuario)

  test("No se ha borrado una asignatura por no ser el administrador"){
    assert(sharing.asignaturas.keys.exists(_ == "ASIG1"))
  }

  // Comprueba que se ha eliminado una asignatura correctamente

  sharing.aniadirAsignatura("TID", "1º", "MUII", "Granada", admin)

  sharing.borrarAsignatura("ASIG2", admin)

  test("Asignatura borrada correctamente"){
    assert(!sharing.asignaturas.keys.exists(_ == "ASIG2"))
  }

  // Comprueba que se ha eliminado los apuntes de una asignatura cuando
  // se elimina ésta

  sharing.aniadirAsignatura("TID", "1º", "MUII", "Granada", admin)

  sharing.aniadirApunte("Tema 1.pdf", "Tema 1 Introducción", sharing.asignaturas("ASIG3"), usuario)
  sharing.aniadirApunte("Tema 2.pdf", "Tema 2 Preparación de datos", sharing.asignaturas("ASIG3"), usuario)

  sharing.borrarAsignatura("ASIG3", admin)

  test("Asignatura, apuntes y comentarios borrados correctamente"){
    assert(!sharing.asignaturas.keys.exists(_ == "ASIG3"))
    assert(!sharing.apuntes.values.exists(_.asignatura.identificador == "ASIG3"))
    assert(!sharing.comentarios.values.exists(_.apunte.asignatura.identificador == "ASIG3"))
  }
}
