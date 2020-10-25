package SharingNotes

class Asignatura (nom: String, cur: Int, car: String, uni: String){
  val nombre: String = nom
  val curso: Int = cur
  val carrera: String = car
  val universidad: String = uni

  def getNombre(): String = {
    return nombre
  }

  def getCurso(): Int = {
    return curso
  }

  def getCarrera(): String = {
    return carrera
  }

  def getUniversidad(): String = {
    return universidad
  }
}
