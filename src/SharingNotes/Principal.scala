package SharingNotes

import scala.collection.mutable.HashMap

class SharingNotes{

  var asignaturas = new HashMap[String, Asignatura]()
  var usuarios = new HashMap[String, Usuario]()
  var apuntes = new HashMap[String, Apunte]()
  var comentarios = new HashMap[String, Comentario]()

  def aniadirUsuario(usuario : Usuario): Unit = usuarios(usuario.correo) = usuario
}

object Principal{

  def main(args: Array[String]): Unit = {

    val sharing = new SharingNotes()

    val usuario = new Usuario("María Jesús", "mjls130598@gmail.com", "MUII", "Granada")
    sharing.aniadirUsuario(usuario)

    sharing.usuarios.foreach
        {
            case (key, value) => println (key + " -> " + value. nombre)
        }
  }
}
