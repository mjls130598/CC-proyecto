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

    if(usuario.getClass.getSimpleName == "Administrador"){

      idAsig += 1

      val id = "ASIG" + idAsig
      val asignatura = new Asignatura(id, nombre, curso, carrera, universidad)
      asignaturas(id) = asignatura
    }
  }

  // Método para borrar una asignatura del sistema

  def borrarAsignatura(id : String, usuario: Usuario): Unit = {

    if(usuario.getClass.getSimpleName == "Administrador"){

      // Primero se borra los apuntes de esa asignatura

      val notes = buscarApuntes(asignaturas(id))
      notes.map(n => borrarApunte(n.identificador, usuario))

      // Por último, se borra la asignatura
      asignaturas -= id
    }

  }

  // Método para añadir nuevos apuntes

  def aniadirApunte(url: String, nom: String, asig: Asignatura, us: Usuario): Unit = {

    // Sólo se admiten archivos PDF

    if(url.toString.split("\\.").last == "pdf"){

      idApun += 1

      val id = "APUN" + idApun
      val ubicacion = "./" + asig.identificador + "/" + url

      val apunte = new Apunte (id, ubicacion, nom, asig, us)
      apuntes(id) = apunte
    }
  }

  // Método para borrar un apunte

  def borrarApunte(id: String, usuario: Usuario) : Unit = {

    // Sólo puede borrar apuntes el administrador del sistema

    if(usuario.getClass.getSimpleName == "Administrador"){

      // Antes de borrar el apunte, se borran los comentarios que se hayan
      // realizado sobre él

      val coments = buscarComentarios(apuntes(id))
      coments.map(c => borrarComentario(c.identificador, usuario))

      // Por último se borra el apunte

      apuntes -= id
    }
  }

  // Método para buscar apuntes de una asignatura

  def buscarApuntes(asignatura : Asignatura): List[Apunte] = {

    // Función que devuelve ese apunte si es de una asignatura dada

    def apunteAsignatura(x: Apunte) = if(x.asignatura == asignatura) List(x) else List()

    val notes = apuntes.values.toList
    return notes.flatMap(x => apunteAsignatura(x))
  }

  // Método para añadir nuevos comentarios

  def aniadirComentario(coment: String, apunte: Apunte, usuario: Usuario): Unit = {

    idCom += 1

    val id = "COM" + idCom
    val comentario = new Comentario(id, coment, usuario, apunte)
    comentarios(id) = comentario
  }

  // Método para borrar un comentario

  def borrarComentario(id: String, usuario: Usuario): Unit ={

    // Sólo el administrador puede borrar comentarios

     if(usuario.getClass.getSimpleName == "Administrador") comentarios -= id
   }

  // Método para buscar comentarios de un apunte

  def buscarComentarios(apunte : Apunte): List[Comentario] = {

    // Función que devuelve ese comentario si es de un apunte dado

    def comentarioApunte(x: Comentario) = if(x.apunte == apunte) List(x) else List()

    val coments = comentarios.values.toList
    return coments.flatMap(x => comentarioApunte(x))
  }
}
