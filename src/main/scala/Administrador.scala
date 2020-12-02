package SharingNotes

class Administrador extends Usuario("Administrador", "admin@admin.com", "x", "x") {

  //                                                                   //
  // Tareas que únicamente puede realizar el administrador del sistema //
  //                                                                   //

  // Método para añadir una asignatura

  def aniadirAsignatura(nombre : String, curso : String, carrera : String,
     universidad : String): Unit = SharingNotes.aniadirAsignatura(nombre, curso,
       carrera, universidad)

  // Método para borrar una asignatura

  def borrarAsignatura(id : String): Unit = SharingNotes.borrarAsignatura(id)

  // Método para borrar un apunte

  def borrarApunte(id : String): Unit = SharingNotes.borrarApunte(id)

  // Método para borrar un comentario

  def borrarComentario(id : String): Unit = SharingNotes.borrarComentario(id)
}
