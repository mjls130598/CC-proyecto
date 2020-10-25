package SharingNotes

class Comentario(coment: String, user: Usuario, apunt : Apunte){

  val comentario: String = coment
  val usuario: String = user
  val apunte: String = apunt

  def getComentario(): String = {
    return comentario
  }

  def getUsuario(): Usuario = {
    return usuario
  }

  def getApunte(): Apunte = {
    return apunte
  }
}
