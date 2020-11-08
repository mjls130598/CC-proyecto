package SharingNotes

class Apunte(id: String, url: String, nom: String, asig: Asignatura, us: Usuario){

  val identificador: String = id 
  val ubicacion: String = url
  val nombre:String = nom
  val asignatura: Asignatura = asig
  val usuario: Usuario = us
}

