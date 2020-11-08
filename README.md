# SharingNotes

## Arquitectura del proyecto

La arquitectura de este proyecto va a estar basada en una arquitectura de microservicios ya que se quiere encargar cada función principal en un servicio diferente para así manejarlos independientemente. Por ejemplo, mantener la base de datos y la interfaz en dos servicios distintos que se comuniquen entre ellos a través de una API.

## Lenguaje de programación

El lenguaje de programación elegido para desarrollar *SharingNotes* es *Scala* ya que combina programación funcional con la programación orientada a objetos y puesto que es sencillo al ser parecido al lenguaje *Java*.

## Historias de usuario

Las historias de usuario que describen este proyecto se muestran a continuación:

- [Como estudiante, necesito registrarme en el sistema para tener unos servicios más personalizados.](https://github.com/mjls130598/SharingNotes/issues/10)
- [Como estudiante, necesito tener la posibilidad de subir los apuntes al sistema.](https://github.com/mjls130598/SharingNotes/issues/12)
- [Como estudiante, necesito poder dejar algún comentario sobre un apunte.](https://github.com/mjls130598/SharingNotes/issues/13)
- [Como estudiante, necesito poder buscar un apunte por su nombre.](https://github.com/mjls130598/SharingNotes/issues/14)
- [Como estudiante, necesito compartir un apunte a mis compañeros.](https://github.com/mjls130598/SharingNotes/issues/15)
- [Como administrador, necesito tener la posibilidad de borrar aquellos apuntes no deseados dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/16)
- [Como administrador, necesito tener la posibilidad de borrar aquellos comentarios no válidos dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/17)
- [Como administrador, necesito poder crear una nueva asignatura dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/18)
- [Como administrador, necesito poder borrar una asignatura dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/19)
- [Como estudiante, necesito encontrar los apuntes de una asignatura](https://github.com/mjls130598/SharingNotes/issues/24)
- [Como estudiante, quiero filtrar la búsqueda de apuntes por universidad, carrera, curso y asignatura](https://github.com/mjls130598/SharingNotes/issues/30)
- [Como usuario, quiero ver los comentarios que dejan sobre un apunte](https://github.com/mjls130598/SharingNotes/issues/31)

## Clases

Las [clases](https://github.com/mjls130598/CC-proyecto/tree/master/src/SharingNotes) que se van a utilizar en este proyecto son las siguientes:

* [Apuntes](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/Apuntes.scala) (la entidad principal del proyecto):
	* Identificador único
	* Ubicación
	* Nombre del fichero
	* Asignatura
	* Usuario

* [Asignatura](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/Asignatura.scala):
	* Identificador único
	* Nombre de la asignatura
	* Curso en el que se imparte
	* Carrera en la que se imparte
	* Universidad donde se realiza

* [Usuario](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/Usuario.scala):
	* Nombre del usuario
	* Correo del usuario
	* Contraseña
	* Carrera que realiza
	* Universidad donde estudia

* [Comentario](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/Comentario.scala):
	* Identificador único
	* Comentario
	* Usuario quien lo realizó
	* Apunte sobre el que lo comenta

* [SharingNotes](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/Principal.scala):
	* Lista de asignaturas
	* Lista de apuntes
	* Lista de comentarios
	* Lista de usuarios

## Milestones del proyecto

El proyecto se va a dividir en los siguientes milestones:

* [Apuntes](https://github.com/mjls130598/SharingNotes/milestone/5): que se encargará de las tareas relacionadas con los apuntes. Las historias de usuario relacionadas con este milestone son las siguientes:

	* [Como estudiante, necesito tener la posibilidad de subir apuntes al sistema.](https://github.com/mjls130598/SharingNotes/issues/12)
	* [Como estudiante, necesito compartir un apunte a mis compañeros.](https://github.com/mjls130598/SharingNotes/issues/15)
	* [Como administrador, necesito tener la posibilidad de borrar aquellos apuntes no deseados dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/16)

* [Usuarios](https://github.com/mjls130598/SharingNotes/milestone/4): se encargará de las tareas relacionadas con los usuarios. La historia de usuario relacionada con este milestone es:

	* [Como estudiante, necesito registrarme en el sistema para tener unos servicios más personalizados.](https://github.com/mjls130598/SharingNotes/issues/10)

* [Comentarios](https://github.com/mjls130598/SharingNotes/milestone/6): se encargará de aquellas tareas sobre los comentarios de un apunte. Las historias de usuario relacionadas con este milestone son:

	* [Como estudiante, necesito poder dejar algún comentario sobre un apunte.](https://github.com/mjls130598/SharingNotes/issues/13)
	* [Como administrador, necesito tener la posibilidad de borrar aquellos comentarios no válidos del sistema.](https://github.com/mjls130598/SharingNotes/issues/17)
	* [Como usuario, quiero ver los comentarios que dejan sobre un apunte](https://github.com/mjls130598/SharingNotes/issues/31)

* [Asignaturas](https://github.com/mjls130598/SharingNotes/milestone/7): se encargará de aquellas tareas relacionadas con las asignaturas. Las historias de usuario correspondientes a este milestone son:

	* [Como administrador, necesito poder crear una nueva asignatura dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/18)
	* [Como administrador, necesito poder borrar una asignatura dentro del sistema.](https://github.com/mjls130598/SharingNotes/issues/19)
	* [Como estudiante, necesito encontrar los apuntes de una asignatura](https://github.com/mjls130598/SharingNotes/issues/24)

* [Búsqueda](https://github.com/mjls130598/SharingNotes/milestone/8): se encargará de aquellas tareas de consultas y de filtrados de apuntes. Las historias de usuario correspondientes a este milestone son:

	* [Como estudiante, necesito poder buscar un apunte.](https://github.com/mjls130598/SharingNotes/issues/14)
	* [Como estudiante, quiero filtrar la búsqueda de apuntes por universidad, carrera, curso y asignatura](https://github.com/mjls130598/SharingNotes/issues/30)

## Planificación

La planificación que se va a seguir, por ahora, para el desarrollo de este proyecto es la siguiente:

* Primero se centrará en la creación de nuevos usuarios y en su inserción en el proyecto.

* Una vez realizado todo lo relacionado con los usuarios, se hará la inserción de nuevas asignaturas.

* A continuación, se realizará la inserción de nuevos apuntes.

* Después, se hará la inserción de un comentario sobre uno de los apuntes, su búsqueda según el apunte dado y la eliminación de los comentarios no deseados.

* Cuando se haya conseguido eliminar comentarios, se creará la manera de borrar los apuntes no deseados y sus comentarios.

* Después de realizar las tareas relacionadas con la eliminación de apuntes, se centrará en la eliminación de asignaturas y de sus correspondientes apuntes.

* Por último, realizar aquello relacionado con las búsquedas y con los filtrados de apuntes.

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/CC-proyecto/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/CC-proyecto/tree/master/documentacion/milestone0.md).
