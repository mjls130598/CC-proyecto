package SharingNotes

class SharingNotes{

  var asignaturas : List[Asignatura] = List()
  var usuarios : List[Usuario] = List()
  var apuntes : List[Apunte] = List()
  var comentarios : List[Comentario] = List()

}

object Principal{

  def main(args: Array[String]): Unit = {

    val sharing = new SharingNotes()

    sharing.asignaturas = (new Asignatura("CC", 1, "Informática", "Granada")) :: sharing.asignaturas    
    println(sharing.asignaturas.mkString("\n"))
  }
}
