package SharingNotes

class Comentario(id: String, coment: String, user: Usuario, apunt : Apunte){

  val identificador: String = id
  val comentario: String = coment
  val usuario: Usuario = user
  val apunte: Apunte = apunt
}

