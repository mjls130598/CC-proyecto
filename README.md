# SharingNotes

## Descripción del problema

En estos momentos, al ser la gran mayoría de las clases virtuales, es difícil recoger buenos apuntes de las asignaturas ya sea por problemas tecnológicos o al no estar físicamente con tus compañeros para compartir conocimientos.

Por lo tanto, este proyecto se basa en crear una plataforma donde cualquier alumno pueda subir sus apuntes para que los vean el resto, visualizar aquellos que necesite, buscar aquel apunte que necesita acceder, compartirlo por alguna red social o realizar comentarios sobre un apunte en concreto.

## Herramientas y tecnologías escogidas

* La arquitectura de este proyecto está basada en una arquitectura microservicios.
* El siguiente programa está escrito en el lenguaje de programación *Scala*.
* La biblioteca que se va a usar para realizar los test es la bibliteca *assert* que viene con el lenguaje *Scala*.
* El marco de prueba elegido para realizar los test es *FunSuite* de la herramienta de test *ScalaTest*.
* El gestor de tareas seleccionado es *Makefile* para que pueda ejecutar con la herramienta de configuración *sbt (Scala Build Tool)*.

## Poner en marcha el proyecto

1. Descargar este proyecto en el dispositivo:
  `git clone git@github.com:mjls130598/SharingNotes.git`

2. Dirigirse a la carpeta del proyecto:
  `cd SharingNotes/`

3. Instalar los programas necesarios para la ejecución del programa:
  `make install`

4. Compilar el programa:
  `make compile`

5. Ejecutar el programa:
  `make run`

6. Ejecutar los test del proyecto:
  `make test`

Si fuera necesario realizar una limpieza del proyecto:
  `make clean`

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

## Justificación del gestor de tareas elegido

Se ha elegido como gestor de tareas la herramienta *Makefile* puesto que se quiere utilizar la herramienta de construcción *sbt* para la compilación, la ejecución y la comprobación mediante test del programa y, para poder utilizarlo, es necesario instalarlo en el dispositivo y ejecutar los distintos comandos *sbt* en la carpeta donde se encuentra el código del proyecto.

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).
