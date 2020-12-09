import SharingNotes._
import org.scalatest.FunSuite

class SharingNotesTest extends FunSuite {

  val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
  val admin = new Administrador()

  // Comprueba que se ha insertado los dos usuarios anteriores al sistema

  SharingNotes.aniadirUsuario(usuario)
  SharingNotes.aniadirUsuario(admin)

  test("Nuevos usuarios") {
    assertResult(2){
      SharingNotes.getUsuarios.size
    }
    info("El nuevo usuario se ha insertado correctamente")
  }

  // Comprueba que se ha añadido una asignatura correctamente

  admin.aniadirAsignatura("PGPI", "1º", "MUII", "Granada")

  test("Nueva asignatura"){
    assertResult(1){
      SharingNotes.getAsignaturas.size
    }
    info("La nueva asignatura se ha insertado correctamente")
  }

  // Comprueba que se ha añadido un nuevo apunte

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/PGPI/Teoría/Tema1_Definiciones.pdf",
    "Tema 1: Definiciones", SharingNotes.getAsignaturas("ASIG1"))

  test("Nuevo apunte"){
    assert(SharingNotes.getApuntes.keys.exists(_ == "APUN1"))
    info("El nuevo apunte se ha insertado correctamente")
  }

  // Comprueba que se ha añadido el apunte correcto

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/TID/Prácticas/Práctica 1/Práctica 1.knar",
    "Práctica 1", SharingNotes.getAsignaturas("ASIG1"))

  test("Insertar apunte con un formato distinto a PDF"){
    assert(!SharingNotes.getApuntes.keys.exists(_ == "APUN2"))
    info("No se ha insertado, sólo se añaden PDFs")
  }

  // Comprueba que se ha añadido un comentario correctamente

  usuario.aniadirComentario("Esto es un comentario cualquiera", SharingNotes.getApuntes("APUN1"))

  test("Nuevo comentario"){
    assert(SharingNotes.getComentarios.keys.exists(_ == "COM1"))
    assert(SharingNotes.getComentarios.values.exists(_.apunte == SharingNotes.getApuntes("APUN1")))
    info("El nuevo comentario se ha insertado correctamente")
  }

  // Comprueba que se ha borrado el comentario anteriormente insertado correctamente

  usuario.aniadirComentario("Esto es el tercer comentario", SharingNotes.getApuntes("APUN1"))

  admin.borrarComentario("COM2")

  test("Borrar un comentario"){
    assert(!SharingNotes.getComentarios.keys.exists(_ == "COM2"))
    info("El comentario se ha borrado correctamente")
  }

  // Comprueba que se encuentra los comentarios de un apunte

  test("Búsqueda de los comentarios de un apunte"){
    assertResult(1){
      usuario.buscarComentarios(SharingNotes.getApuntes("APUN1")).size
    }
  }

  // Comprueba que se eliminan los apuntes correctamente

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/PGPI/Teoría/Tema2_Preparacióndeproyectos.pdf",
    "Tema 2: Preparación de proyectos", SharingNotes.getAsignaturas("ASIG1"))

  admin.borrarApunte("APUN2")

  test("Borrar un apunte"){
    assert(!SharingNotes.getApuntes.keys.exists(_ == "APUN2"))
    info("El apunte se ha borrado correctamente")
  }

  // Comprueba que se eliminan todos los comentarios sobre un apunte

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/PGPI/Teoría/Tema2_Preparacióndeproyectos.pdf",
    "Tema 2: Preparación de proyectos", SharingNotes.getAsignaturas("ASIG1"))

  usuario.aniadirComentario("Este es el cuarto comentario realizado", SharingNotes.getApuntes("APUN3"))

  admin.borrarApunte("APUN3")

  test("Borrar apunte y sus correspondientes comentarios"){
    assert(!SharingNotes.getApuntes.keys.exists(_ == "APUN3"))
    assert(!SharingNotes.getComentarios.values.exists(_.apunte.identificador == "APUN3"))
    info("No está en el sistema el apunte ni los comentarios realizados sobre él")
  }

  // Comprueba que se encuentran los apuntes de una asignatura

  test("Búsqueda de los apuntes de una asignatura"){
    assertResult(1){
      usuario.buscarApuntes(SharingNotes.getAsignaturas("ASIG1")).size
    }
  }

  // Comprueba que se ha eliminado una asignatura correctamente

  admin.aniadirAsignatura("TID", "1º", "MUII", "Granada")

  admin.borrarAsignatura("ASIG2")

  test("Asignatura borrada correctamente"){
    assert(!SharingNotes.getAsignaturas.keys.exists(_ == "ASIG2"))
    info("La asignatura no se encuentra almacenada en el sistema")
  }

  // Comprueba que se ha eliminado los apuntes de una asignatura cuando
  // se elimina ésta

  admin.aniadirAsignatura("TID", "1º", "MUII", "Granada")

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/TID/Teoría/Intro_TID.pdf",
    "Tema 1 Introducción", SharingNotes.getAsignaturas("ASIG3"))
  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/TID/Teoría/PreparacionDatos.pdf",
    "Tema 2 Preparación de datos", SharingNotes.getAsignaturas("ASIG3"))

  admin.borrarAsignatura("ASIG3")

  test("Asignatura, apuntes y comentarios borrados correctamente"){
    assert(!SharingNotes.getAsignaturas.keys.exists(_ == "ASIG3"))
    assert(!SharingNotes.getApuntes.values.exists(_.asignatura.identificador == "ASIG3"))
    assert(!SharingNotes.getComentarios.values.exists(_.apunte.asignatura.identificador == "ASIG3"))
    info("No se encuentra la asignatura, ni los apuntes sobre una asignatura ni " +
      "los comentarios realizados sobre cada un de los apuntes anteriores en el sistema")
  }
}
