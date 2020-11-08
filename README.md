# SharingNotes

## Descripción del problema

En estos momentos, al ser la gran mayoría de las clases virtuales, es difícil recoger buenos apuntes de las asignaturas ya sea por problemas tecnológicos o al no estar físicamente con tus compañeros para compartir conocimientos.

Por lo tanto, este proyecto se basa en crear una plataforma donde cualquier alumno pueda subir sus apuntes para que los vean el resto, visualizar aquellos que necesite, buscar aquel apunte que necesita acceder, compartirlo por alguna red social o realizar comentarios sobre un apunte en concreto.

## Herramientas y tecnologías escogidas

* La arquitectura de este proyecto está basada en una arquitectura microservicios.
* El siguiente programa está escrito en el lenguaje de programación *Scala*.
* La biblioteca que se va a usar para realizar los test es *ScalaTest*.

## Estructura del proyecto

Las clases que la forman son:

* [Apunte](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Apunte.scala)
* [Asignatura](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Asignatura.scala)
* [Comentario](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Comentario.scala)
* [Usuario](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Usuario.scala)
* [Administrador](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Administrador.scala)
* [SharingNotes](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/SharingNotes.scala)

## Justificación de la biblioteca de aserciones

Se ha elegido para hacer los distintos tests sobre el programa que se está realizando la biblioteca *ScalaTest* puesto que ofrece distintas aserciones:

* Una general con *assert*.
* Una más específica para diferenciar los valores obtenidos con los esperados con *assertResult*.
* Otra más específica para asegurarse que realiza las correspondientes excepciones con *assertThrows*.

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).
