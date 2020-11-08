# SharingNotes

## Descripción del problema

En estos momentos, al ser la gran mayoría de las clases virtuales, es difícil recoger buenos apuntes de las asignaturas ya sea por problemas tecnológicos o al no estar físicamente con tus compañeros para compartir conocimientos.

Por lo tanto, este proyecto se basa en crear una plataforma donde cualquier alumno pueda subir sus apuntes para que los vean el resto, visualizar aquellos que necesite, buscar aquel apunte que necesita acceder, compartirlo por alguna red social o realizar comentarios sobre un apunte en concreto.

## Herramientas y tecnologías escogidas

* La arquitectura de este proyecto está basada en una arquitectura microservicios.
* El siguiente programa está escrito en el lenguaje de programación *Scala*.
* La biblioteca que se va a usar para realizar los test es la bibliteca *assert* que viene con el lenguaje *Scala*.
* El marco de prueba elegido para realizar los test es *FunSuite* de la herramienta de test *ScalaTest*.

## Estructura del proyecto

Las clases que la forman son:

* [**Apunte**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Apunte.scala): almacena la información necesaria para el manejo de un apunte.
* [**Asignatura**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Asignatura.scala): almacena los datos necesarios para manejar una asignatura dentro del sistema.
* [**Comentario**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Comentario.scala): guarda aquella información necesaria para crear un comentario.
* [**Usuario**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Usuario.scala): conserva la infrmación de un usuario del sistema.
* [**Administrador**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Administrador.scala): guarda la infrmación del usuario *Administrador*
* [**SharingNotes**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/SharingNotes.scala): almacena toda la información necesaria para el manejo del sistema.

## Justificación de la biblioteca de aserciones

Se ha elegido para hacer los distintos tests sobre el programa que se está realizando la biblioteca *Assertion* puesto que ofrece distintas aserciones, entre las principales se encuentran:

* Una general con *assert*.
* Una más específica para diferenciar los valores obtenidos con los esperados con *assertResult*.
* Otra más específica para asegurarse que realiza las correspondientes excepciones con *assertThrows*.

La información obtenida sobre esta biblioteca se recogió de la página oficial de [*ScalaTest*](https://www.scalatest.org/user_guide/using_assertions).

## Justificación del marco de pruebas elegido

Como marco de pruebas se ha elegido *FunSuite* de la biblioteca *ScalaTest* puesto que es sencillo de crear los diferentes test al programa y utiliza la biblioteca de aserciones *Assertion*.

Además, ofrece diferentes tipos de test, además de etiquetas o funcionalidades dentro de los test para ofrecer distintos mensajes al usuario.

Se ha elegido este marco de pruebas al recoger la información oficial de [*FunSuites*](http://doc.scalatest.org/1.8/org/scalatest/FunSuite.html).

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).
