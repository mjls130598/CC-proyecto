package SharingNotes

object Principal{

  def main(args: Array[String]): Unit = {

    val sharing = new SharingNotes()

    // Añadir usuario a la memoria del proyecto

    val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
    val admin = new Administrador()

    sharing.aniadirUsuario(usuario)
    sharing.aniadirUsuario(admin)

    println("\n/*****************************************************/\n")

    println("Usuarios del sistema:")

    sharing.usuarios.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.nombre)
    }

    println("\n/*****************************************************/\n")

    // Añadir asignatura a la memoria del proyecto

    sharing.aniadirAsignatura("CC", "1º", "MUII", "Granada", admin)

    println("Asignaturas del sistema:")

    sharing.asignaturas.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.nombre)
    }

    println("\n/*****************************************************/\n")

    // Añadir apunte a la memoria del proyecto

    println("Apuntes de la asignatura de CC:")

    sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)
    sharing.apuntes.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.nombre)
    }

    println("\n/*****************************************************/\n")

    // Añadir comentario a la memoria del proyecto

    println("Comentarios guardados:")

    sharing.aniadirComentario("Esto es un comentario cualquiera", sharing.apuntes("APUN1"), usuario)
    sharing.comentarios.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.comentario)
    }

    println("\n/*****************************************************/\n")

    // Borrar comentario de la memoria del proyecto

    println("Número de comentarios sobre Apunte CC después de borrar el último:")

    sharing.borrarComentario(sharing.comentarios.last._1, admin)
    println("\t" + sharing.comentarios.size)

    println("\n/*****************************************************/\n")

    // Buscar comentarios de un apunte

    sharing.aniadirComentario("Esto es un comentario cualquiera", sharing.apuntes("APUN1"), usuario)
    sharing.aniadirComentario("Esto es otro comentario cualquiera", sharing.apuntes("APUN1"), usuario)

    println("Comentarios de Apunte CC:")

    val comentarios = sharing.buscarComentarios(sharing.apuntes("APUN1"))
    comentarios.foreach{
      case (coment) => println ("\t" + coment.identificador + " -> " + coment.comentario)
    }

    println("\n/*****************************************************/\n")

    // Borrar apunte de la memoria del proyecto

    println("Comentarios resultantes después de borrar Apunte CC:")

    sharing.borrarApunte("APUN1", admin)
    sharing.comentarios.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.comentario)
    }

    println("\n/*****************************************************/\n")

    // Buscar apuntes de una asignatura

    println("Apuntes de la asignatura CC:")

    sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)
    sharing.aniadirApunte("CC-T3.pdf", "Tema 3: Docker", sharing.asignaturas("ASIG1"), usuario)

    val apuntes = sharing.buscarApuntes(sharing.asignaturas("ASIG1"))
    apuntes.foreach{
      case (apunte) => println("\t" + apunte.identificador + " -> " + apunte.nombre)
    }

    println("\n/*****************************************************/\n")

    // Borrar una asignatura de la memoria del proyecto

    sharing.borrarAsignatura("ASIG1", admin)

    println("Apuntes después de borrar la asignatura CC:")

    sharing.apuntes.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.identificador)
    }

    println("\n/*****************************************************/\n")

    println("Comentarios después de borrar los apuntes de la asignatura CC:")
    sharing.comentarios.foreach{
      case (key, value) => println ("\t" + key + " -> " + value.comentario)
    }

    println("\n/*****************************************************/\n")
  }
}
