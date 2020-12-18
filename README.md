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

3. Construir el contenedor:
  `docker build -t mjls130598/sharingnotes .`

4. Ejecutar los test del programa que se encuentran dentro del contenedor:
  `docker run --rm mjls130598/sharingnotes`

Si se prefiere ejecutar con el gestor de tareas *SBT* en vez de con *Docker*, se realizan los dos primeros pasos anteriores y, a continuación:

3. Ejecutar el proyecto:
  `sbt run`

4. Ejecutar los distintos tests de este repositorio:
  `sbt test`

## Milestone 4

El archivo con las explicaciones realizadas para este milestone se encuentra en este [enlace](https://github.com/mjls130598/SharingNotes/tree/master/documentacion/milestone4.md).

## Documentaciones

La documentación de los distintos milestones de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).
