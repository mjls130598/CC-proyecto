package SharingNotes

class Usuario(nom: String, email: String, password : String, car: String, uni: String){

  val nombre: String = nom
  val correo: String = email
  val contrasenia: String = password
  val carrera: String = car
  val universidad: String = uni

  def getNombre(): String = {
    return nombre
  }

  def getCorreo(): String = {
    return correo
  }

  def getCarrera(): String = {
    return carrera
  }

  def getUniversidad(): String = {
    return universidad
  }

}
