package SharingNotes

import scala.collection.mutable.HashMap

class SharingNotes{

  var asignaturas = new HashMap[String, Asignatura]()
  var usuarios = new HashMap[String, Usuario]()
  var apuntes = new HashMap[String, Apunte]()
  var comentarios = new HashMap[String, Comentario]()

  // Variables para controlar los identificadores

  var idAsig = 0
  var idApun = 0
  var idCom = 0

  // Método para añadir nuevos usuarios al programa

  def aniadirUsuario(usuario : Usuario): Unit = usuarios(usuario.correo) = usuario

  // Método para añadir nuevas asignaturas al sistema

  def aniadirAsignatura(nombre : String, curso : String, carrera : String,
     universidad : String, usuario : Usuario): Unit = {

    // Sólo aquel usuario que sea el administrador del sistema puede insertar
    // una nueva asignatura

    if(usuario.nombre == "Administrador"){

      idAsig += 1

      val id = "ASIG" + idAsig
      val asignatura = new Asignatura(id, nombre, curso, carrera, universidad)
      asignaturas(id) = asignatura
    }
  }

  // Método para añadir nuevos apuntes

  def aniadirApunte(url: String, nom: String, asig: Asignatura, us: Usuario): Unit = {

    idApun += 1

    val id = "APUN" + idApun
    val ubicacion = "./" + asig.identificador + "/" + url

    // Sólo se admiten archivos PDF

    if(url.toString.split("\\.").last == "pdf"){
      val apunte = new Apunte (id, ubicacion, nom, asig, us)
      apuntes(id) = apunte
    }
  }

  // Método para borrar un apunte

  def borrarApunte(id: String, usuario: Usuario) : Unit = {

    // Sólo puede borrar apuntes el administrador del sistema

    if(usuario.nombre == "Administrador"){

      // Antes de borrar el apunte, se borran los comentarios que se hayan
      // realizado sobre él

      val coments = buscarComentarios(apuntes(id))
      coments.map(c => borrarComentario(c.identificador, usuario))

      // Por último se borra el apunte

      apuntes -= id
    }
  }

  // Método para añadir nuevos comentarios

  def aniadirComentario(coment: String, apunte: Apunte, usuario: Usuario): Unit = {

    idCom += 1

    val id = "COM" + (comentarios.size + 1)
    val comentario = new Comentario(id, coment, usuario, apunte)
    comentarios(id) = comentario
  }

  // Método para borrar un comentario

  def borrarComentario(id: String, usuario: Usuario): Unit ={

    // Sólo el administrador puede borrar comentarios

     if(usuario.nombre == "Administrador") comentarios -= id
   }

  // Método para buscar comentarios de un apunte

  def buscarComentarios(apunte : Apunte): List[Comentario] = {

    // Función que devuelve ese comentario si es de un apunte dado

    def comentarioApunte(x: Comentario) = if(x.apunte == apunte) List(x) else List()

    val coments = comentarios.values.toList
    return coments.flatMap(x => comentarioApunte(x))
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

    val admin = new Usuario("Administrador", "admin@admin.com", "x", "x")

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
  }
}
