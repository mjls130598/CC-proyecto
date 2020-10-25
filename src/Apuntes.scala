package SharingNotes

class Apunte(nom: String, asig: Asignatura, us: Usuario){

  val nombre:String = nom
  val asignatura: Asignatura = asig
  val usuario: Usuario = us

  def getNombre(): String = {
    return nombre
  }

  def getAsignatura(): Asignatura = {
    return asignatura
  }

  def getUsuario(): Usuario = {
    return usuario
  }
}

