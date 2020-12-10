# SharingNotes

## Descripción del problema

En estos momentos, al ser la gran mayoría de las clases virtuales, es difícil recoger buenos apuntes de las asignaturas ya sea por problemas tecnológicos o al no estar físicamente con tus compañeros para compartir conocimientos.

Por lo tanto, este proyecto se basa en crear una plataforma donde cualquier alumno pueda subir sus apuntes para que los vean el resto, visualizar aquellos que necesite, buscar aquel apunte que necesita acceder, compartirlo por alguna red social o realizar comentarios sobre un apunte en concreto.

## Herramientas y tecnologías escogidas

* La arquitectura de este proyecto está basada en una arquitectura microservicios.
* El siguiente programa está escrito en el lenguaje de programación *Scala*.
* El gestor de tareas y el marco de prueba que se va a utilizar es *sbt (Scala Build Tool)*.
* La biblioteca que se va a usar para realizar los test es la bibliteca *ScalaTest*.
* Para crear un contenedor se ha elegido utilizar *Docker* con su correspondiente [*Dockerfile*](https://github.com/mjls130598/SharingNotes/blob/master/Dockerfile) con *Alpine* como imagen base.

## Poner en marcha el proyecto

1. Descargar este proyecto en el dispositivo:
  `git clone git@github.com:mjls130598/SharingNotes.git`

2. Entrar al directorio del proyecto:
  `cd SharingNotes`

2. Construir el contenedor:
  `docker build -t mjls130598/sharingnotes .`

3. Ejecutar los test del programa que se encuentran dentro del contenedor:
  `docker run --rm mjls130598/sharingnotes`

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).

La documentación sobre las tareas realizadas en el milestone 2 se encuentra dentro del directorio [documentación](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone2.md).

Con respecto a la explicación de las distintas tareas ejecutadas en el milestone 3 se encuentra en este [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone3.md) dentro del directorio de documentación.
