package SharingNotes

object Principal{

  def main(args: Array[String]): Unit = {

    val sharing = new SharingNotes()

    // Añadir usuario a la memoria del proyecto

    val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
    sharing.aniadirUsuario(usuario)

    sharing.usuarios.foreach{
      case (key, value) => println (key + " -> " + value.nombre)
    }

    // Añadir asignatura a la memoria del proyecto

    val admin = new Administrador()

    sharing.aniadirAsignatura("CC", "1º", "MUII", "Granada", admin)
    sharing.asignaturas.foreach{
      case (key, value) => println (key + " -> " + value.identificador)
    }

    // Añadir apunte a la memoria del proyecto

    sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)
    sharing.apuntes.foreach{
      case (key, value) => println (key + " -> " + value.identificador)
    }

    // Añadir comentario a la memoria del proyecto

    sharing.aniadirComentario("Esto es un comentario cualquiera", sharing.apuntes("APUN1"), usuario)
    sharing.comentarios.foreach{
      case (key, value) => println (key + " -> " + value.comentario)
    }

    // Borrar comentario de la memoria del proyecto

    sharing.borrarComentario(sharing.comentarios.last._1, admin)
    println(sharing.comentarios.size)

    // Buscar comentarios de un apunte

    sharing.aniadirComentario("Esto es un comentario cualquiera", sharing.apuntes("APUN1"), usuario)
    sharing.aniadirComentario("Esto es otro comentario cualquiera", sharing.apuntes("APUN1"), usuario)

    val comentarios = sharing.buscarComentarios(sharing.apuntes("APUN1"))
    comentarios.foreach{
      case (coment) => println (coment.identificador)
    }

    // Borrar apunte de la memoria del proyecto

    sharing.borrarApunte("APUN1", admin)
    sharing.comentarios.foreach{
      case (key, value) => println (key + " -> " + value.comentario)
    }

    // Buscar apuntes de una asignatura

    sharing.aniadirApunte("CC.pdf", "Apunte de CC", sharing.asignaturas("ASIG1"), usuario)
    sharing.aniadirApunte("CC-T3.pdf", "Tema 3: Docker", sharing.asignaturas("ASIG1"), usuario)

    val apuntes = sharing.buscarApuntes(sharing.asignaturas("ASIG1"))
    apuntes.foreach{
      case (apunte) => println(apunte.identificador)
    }

    // Borrar una asignatura de la memoria del proyecto

    sharing.borrarAsignatura("ASIG1", admin)
    sharing.apuntes.foreach{
      case (key, value) => println (key + " -> " + value.identificador)
    }
    sharing.comentarios.foreach{
      case (key, value) => println (key + " -> " + value.comentario)
    }
  }
}
