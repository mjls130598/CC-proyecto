import SharingNotes._
import org.scalatest.FunSuite

class FuncionesBasicasTest extends FunSuite {

  val sharing = new SharingNotes()

  val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
  val admin = new Administrador()

  // Comprueba que se ha insertado los dos usuarios anteriores al sistema

  sharing.aniadirUsuario(usuario)
  sharing.aniadirUsuario(admin)

  test("Nuevos usuarios") {
    assertResult(2){
      sharing.usuarios.size
    }
    info("El nuevo usuario se ha insertado correctamente")
  }

  // Comprueba que se ha añadido una asignatura correctamente

  sharing.aniadirAsignatura("CC", "1º", "MUII", "Granada", admin)

  test("Nueva asignatura"){
    assertResult(1){
      sharing.asignaturas.size
    }
    info("La nueva asignatura se ha insertado correctamente")
  }

  // Comprueba que no se ha añadido una asignatura

  sharing.aniadirAsignatura("TID", "1º", "MUII", "Granada", usuario)

  test("Usuario común inserta una asignatura"){
    assertResult(1){
      sharing.asignaturas.size
    }
    info("No puede, sólo lo realiza un administrador")
  }

  // Comprueba que se ha añadido un nuevo apunte

  sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)

  test("Nuevo apunte"){
    assert(sharing.apuntes.keys.exists(_ == "APUN1"))
    info("El nuevo apunte se ha insertado correctamente")
  }

  // Comprueba que se ha añadido el apunte correcto

  sharing.aniadirApunte("CC.doc", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)

  test("Insertar apunte con un formato distinto a PDF"){
    assert(sharing.apuntes.keys.exists(_ == "APUN2"))
    info("No se ha insertado, sólo se añaden PDFs")
  }

  // Comprueba que se ha añadido un comentario correctamente

  sharing.aniadirComentario("Esto es un comentario cualquiera",
    sharing.apuntes("APUN1"), usuario)

  test("Nuevo comentario"){
    assert(sharing.comentarios.keys.exists(_ == "COM1"))
    assert(sharing.comentarios.values.exists(_.apunte == sharing.apuntes("APUN1")))
    info("El nuevo comentario se ha insertado correctamente")
  }

  // Comprueba que un usuario normal no puede borrar un comentario

  sharing.aniadirComentario("Esto es otro comentario cualquiera",
    sharing.apuntes("APUN1"), usuario)

  sharing.borrarComentario("COM2", usuario)

  test("Usuario común borra un comentario"){
    assert(sharing.comentarios.keys.exists(_ == "COM2"))
    info("Sólo el administrador borra un comentario")
  }

  // Comprueba que se ha borrado el comentario anteriormente insertado correctamente

  sharing.aniadirComentario("Esto es el tercer comentario",
    sharing.apuntes("APUN1"), usuario)

  sharing.borrarComentario("COM3", admin)

  test("Borrar un comentario"){
    assert(!sharing.comentarios.keys.exists(_ == "COM3"))
    info("El comentario se ha borrado correctamente")

  }

  // Comprueba que se encuentra los comentarios de un apunte

  test("Búsqueda de los comentarios de un apunte"){
    assertResult(2){
      sharing.buscarComentarios(sharing.apuntes("APUN1")).size
    }
  }

  // Comprueba que un usuario normal no puede eliminar un apunte

  sharing.aniadirApunte("Tema 2.pdf", "Tema 2 Test", sharing.asignaturas("ASIG1"), usuario)

  sharing.borrarApunte("APUN2", usuario)

  test("Usuario común borra un apunte"){
    assert(sharing.apuntes.keys.exists(_ == "APUN2"))
    info("No se ha borrado, sólo lo puede hacer el administrador")
  }

  // Comprueba que se eliminan los apuntes correctamente

  sharing.aniadirApunte("Tema 3.pdf", "Tema 3 Docker", sharing.asignaturas("ASIG1"), usuario)

  sharing.borrarApunte("APUN3", admin)

  test("Borrar un apunte"){
    assert(!sharing.apuntes.keys.exists(_ == "APUN3"))
    info("El apunte se ha borrado correctamente")
  }

  // Comprueba que se eliminan todos los comentarios sobre un apunte

  sharing.aniadirApunte("Tema 1.pdf", "Tema 1 Arquitectura", sharing.asignaturas("ASIG1"), usuario)

  sharing.aniadirComentario("Este es el cuarto comentario realizado", sharing.apuntes("APUN4"), usuario)

  sharing.borrarApunte("APUN4", admin)

  test("Borrar apunte y sus correspondientes comentarios"){
    assert(!sharing.apuntes.keys.exists(_ == "APUN4"))
    assert(!sharing.comentarios.values.exists(_.apunte.identificador == "APUN4"))
    info("No está en el sistema el apunte ni los comentarios realizados sobre él")
  }

  // Comprueba que se encuentran los apuntes de una asignatura

  test("Búsqueda de los apuntes de una asignatura"){
    assertResult(2){
      sharing.buscarApuntes(sharing.asignaturas("ASIG1")).size
    }
  }

  // Comprueba que un usuario normal no puede eliminar una asignatura

  sharing.borrarAsignatura("ASIG1", usuario)

  test("Usuario común borra una asignatura"){
    assert(sharing.asignaturas.keys.exists(_ == "ASIG1"))
    info("No puede eliminar una asignatura, sólo lo puede realizar el administrador")
  }

  // Comprueba que se ha eliminado una asignatura correctamente

  sharing.aniadirAsignatura("TID", "1º", "MUII", "Granada", admin)

  sharing.borrarAsignatura("ASIG2", admin)

  test("Asignatura borrada correctamente"){
    assert(!sharing.asignaturas.keys.exists(_ == "ASIG2"))
    info("La asignatura no se encuentra almacenada en el sistema")
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
    info("No se encuentra la asignatura, ni los apuntes sobre una asignatura ni " +
      "los comentarios realizados sobre cada un de los apuntes anteriores en el sistema")
  }
}
