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
    "Tema 1: Definiciones", SharingNotes.getAsignaturas.last._2)

  test("Nuevo apunte"){
    assertResult(1){
      SharingNotes.getApuntes.size
    }
    info("El nuevo apunte se ha insertado correctamente")
  }

  // Comprueba que se ha añadido el apunte correcto

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/TID/Prácticas/Práctica 1/Práctica 1.knar",
    "Práctica 1", SharingNotes.getAsignaturas.last._2)

  test("Insertar apunte con un formato distinto a PDF"){
    assertResult(1){
      SharingNotes.getApuntes.size
    }
    info("No se ha insertado, sólo se añaden PDFs")
  }

  // Comprueba que se ha añadido un comentario correctamente

  usuario.aniadirComentario("Esto es un comentario cualquiera", SharingNotes.getApuntes.last._2)

  test("Nuevo comentario"){
    assertResult(1){
      SharingNotes.getComentarios.size
    }
    assert(SharingNotes.getComentarios.values.exists(_.apunte == SharingNotes.getApuntes.last._2))
    info("El nuevo comentario se ha insertado correctamente")
  }

  // Comprueba que se ha borrado el comentario anteriormente insertado correctamente

  usuario.aniadirComentario("Esto es el tercer comentario", SharingNotes.getApuntes.last._2)

  val ultimoComentarioID = SharingNotes.getComentarios.last._1

  admin.borrarComentario(ultimoComentarioID)

  test("Borrar un comentario"){
    assert(!SharingNotes.getComentarios.keys.exists(_ == ultimoComentarioID))
    info("El comentario se ha borrado correctamente")
  }

  // Comprueba que se encuentra los comentarios de un apunte

  test("Búsqueda de los comentarios de un apunte"){
    assertResult(1){
      usuario.buscarComentarios(SharingNotes.getApuntes.last._2).size
    }
  }

  // Comprueba que se eliminan los apuntes correctamente

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/PGPI/Teoría/Tema2_Preparacióndeproyectos.pdf",
    "Tema 2: Preparación de proyectos", SharingNotes.getAsignaturas.last._2)

  val ultimoApunteID = SharingNotes.getApuntes.last._1

  admin.borrarApunte(ultimoApunteID)

  test("Borrar un apunte"){
    assert(!SharingNotes.getApuntes.keys.exists(_ == ultimoApunteID))
    info("El apunte se ha borrado correctamente")
  }

  // Comprueba que se eliminan todos los comentarios sobre un apunte

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/PGPI/Teoría/Tema2_Preparacióndeproyectos.pdf",
    "Tema 2: Preparación de proyectos", SharingNotes.getAsignaturas.last._2)

  val ultimoApunteID2 = SharingNotes.getApuntes.last._1

  usuario.aniadirComentario("Este es el cuarto comentario realizado", SharingNotes.getApuntes(ultimoApunteID2))

  admin.borrarApunte(ultimoApunteID2)

  test("Borrar apunte y sus correspondientes comentarios"){
    assert(!SharingNotes.getApuntes.keys.exists(_ == ultimoApunteID2))
    assert(!SharingNotes.getComentarios.values.exists(_.apunte.identificador == ultimoApunteID2))
    info("No está en el sistema el apunte ni los comentarios realizados sobre él")
  }

  // Comprueba que se encuentran los apuntes de una asignatura

  test("Búsqueda de los apuntes de una asignatura"){
    assertResult(1){
      usuario.buscarApuntes(SharingNotes.getAsignaturas.last._2).size
    }
  }

  // Comprueba que se ha eliminado una asignatura correctamente

  admin.aniadirAsignatura("TID", "1º", "MUII", "Granada")

  val ultimaAsignaturaID = SharingNotes.getAsignaturas.last._1

  admin.borrarAsignatura(ultimaAsignaturaID)

  test("Asignatura borrada correctamente"){
    assert(!SharingNotes.getAsignaturas.keys.exists(_ == ultimaAsignaturaID))
    info("La asignatura no se encuentra almacenada en el sistema")
  }

  // Comprueba que se ha eliminado los apuntes de una asignatura cuando
  // se elimina ésta

  admin.aniadirAsignatura("TID", "1º", "MUII", "Granada")

  val ultimaAsignaturaID2 = SharingNotes.getAsignaturas.last._1

  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/TID/Teoría/Intro_TID.pdf",
    "Tema 1 Introducción", SharingNotes.getAsignaturas(ultimaAsignaturaID2))
  usuario.aniadirApunte("/media/mjesus/MJESUS/MÁSTER/TID/Teoría/PreparacionDatos.pdf",
    "Tema 2 Preparación de datos", SharingNotes.getAsignaturas(ultimaAsignaturaID2))

  admin.borrarAsignatura(ultimaAsignaturaID2)

  test("Asignatura, apuntes y comentarios borrados correctamente"){
    assert(!SharingNotes.getAsignaturas.keys.exists(_ == ultimaAsignaturaID2))
    assert(!SharingNotes.getApuntes.values.exists(_.asignatura.identificador == ultimaAsignaturaID2))
    assert(!SharingNotes.getComentarios.values.exists(_.apunte.asignatura.identificador == ultimaAsignaturaID2))
    info("No se encuentra la asignatura, ni los apuntes sobre una asignatura ni " +
      "los comentarios realizados sobre cada un de los apuntes anteriores en el sistema")
  }
}
