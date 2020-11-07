package SharingNotes

import scala.collection.mutable.HashMap

class SharingNotes{

  var asignaturas = new HashMap[String, Asignatura]()
  var usuarios = new HashMap[String, Usuario]()
  var apuntes = new HashMap[String, Apunte]()
  var comentarios = new HashMap[String, Comentario]()

  // Método para añadir nuevos usuarios al programa

  def aniadirUsuario(usuario : Usuario): Unit = usuarios(usuario.correo) = usuario

  // Método para añadir nuevas asignaturas al sistema

  def aniadirAsignatura(nombre : String, curso : String, carrera : String,
     universidad : String, usuario : Usuario): Unit = {

    // Sólo aquel usuario que sea el administrador del sistema puede insertar
    // una nueva asignatura

    if(usuario.nombre == "Administrador"){
      val id = "ASIG" + (asignaturas.size + 1)
      val asignatura = new Asignatura(id, nombre, curso, carrera, universidad)
      asignaturas(id) = asignatura
    }
  }
}

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

    sharing.aniadirAsignatura("CC", "1º", "MUII", "Granada", usuario)
    sharing.asignaturas.foreach{
      case (key, value) => println (key + " -> " + value.identificador)
    }

  }
}
