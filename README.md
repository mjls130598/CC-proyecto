# SharingNotes

## Descripción del problema

En estos momentos, al ser la gran mayoría de las clases virtuales, es difícil recoger buenos apuntes de las asignaturas ya sea por problemas tecnológicos o al no estar físicamente con tus compañeros para compartir conocimientos.

Por lo tanto, este proyecto se basa en crear una plataforma donde cualquier alumno pueda subir sus apuntes para que los vean el resto, visualizar aquellos que necesite, buscar aquel apunte que necesita acceder, compartirlo por alguna red social o realizar comentarios sobre un apunte en concreto.

## Herramientas y tecnologías escogidas

* La arquitectura de este proyecto está basada en una arquitectura microservicios.
* El siguiente programa está escrito en el lenguaje de programación *Scala*.
* El gestor de tareas y el marco de prueba que se va a utilizar es *sbt (Scala Build Tool)*.
* La biblioteca que se va a usar para realizar los test es la bibliteca *ScalaTest*.

## Poner en marcha el proyecto

1. Descargar este proyecto en el dispositivo:
  `git clone git@github.com:mjls130598/SharingNotes.git`

2. Dirigirse a la carpeta del proyecto:
  `cd SharingNotes/src/SharingNotes`

4. Compilar el programa:
  `sbt compile`

5. Ejecutar el programa:
  `sbt run`

6. Ejecutar los test del proyecto:
  `sbt test`

Si fuera necesario realizar una limpieza del proyecto:
  `sbt clean`

## Estructura del proyecto

Las clases que la forman son:

* [**Apunte**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Apunte.scala): almacena la información necesaria para el manejo de un apunte.
* [**Asignatura**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Asignatura.scala): almacena los datos necesarios para manejar una asignatura dentro del sistema.
* [**Comentario**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Comentario.scala): guarda aquella información necesaria para crear un comentario.
* [**Usuario**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Usuario.scala): conserva la información de un usuario del sistema.
* [**Administrador**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/Administrador.scala): guarda la información del usuario *Administrador*
* [**SharingNotes**](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/src/main/scala/SharingNotes.scala): almacena toda la información necesaria para el manejo del sistema.
* **Búsqueda**: se encarga de las consultas y de los filtrados que desean hacer los usuarios. Se realizará su implementación en los siguientes milestones.

## Funciones realizadas

Las funciones que se han realizados, además de sus correspondientes tests, son las siguientes:

* [**Añadir usuario**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L20): se encarga de insertar un nuevo usuario en la memoria del sistema.
  * En los test correspondientes a este método se encuentran en [este enlace](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L11).
  * Este método corresponde a la historia de usuario [HU1](https://github.com/mjls130598/SharingNotes/issues/10).

* [**Añadir asignatura**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L24): se encarga de que el administrador del sistema añada una asignatura al programa.
  * Los test que comprueban el correcto funcionamiento del método se encuentra [aquí](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L23).
  * Este método está indicado en la historia de usuario [HU8](https://github.com/mjls130598/SharingNotes/issues/18).

* [**Borrar asignatura**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L42): el administrador del sistema borra una de las asignaturas que están guardadas en el sistema.
  * En esta [línea de código](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L151) se encuentran los test de esta función.
  * En la historia de usuario [HU9](https://github.com/mjls130598/SharingNotes/issues/19) se explica la función que debe realizar este método.

* [**Añadir apunte**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L59): insertar en la memoria de la aplicación un apunte dado.
  * Su test correspondiente se encuentra en [este link](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L45).
  * Su funcionalidad ha sido sacada de la historia de usuario [HU2](https://github.com/mjls130598/SharingNotes/issues/12).

* [**Borrar apunte**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L77): el administrador del sistema indica el apunte que desea eliminar definitivamente del programa.
  * Los test pertenecientes a esta función se pueden encontrar [aquí](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L107).
  * Este método corresponde a la historia de usuario [HU6](https://github.com/mjls130598/SharingNotes/issues/16).

* [**Buscar los apuntes de una asignatura**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L97): dada una asignatura, devuelve todos los apuntes que pertenezcan a esa asignatura.
  * El test de este método se puede ver a través del [siguiente enlace](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L143).
  * Este método cumple parte de la historia de usuario [HU10](https://github.com/mjls130598/SharingNotes/issues/24).

* [**Añadir comentario**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L109): se encarga de añadir un comentario sobre un apunte en concreto al programa.
  * Su test correspondiente está en el [siguiente enlace](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L63).
  * Su funcionalidad se encuentra explicada en la historia de usuario [HU3](https://github.com/mjls130598/SharingNotes/issues/13).

* [**Borrar comentario**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L120): el administrador del sistema se encarga de borrar aquellos comentarios que no desea que sigan visibles en el sistema.
  * Sus test correspondientes se encuentran [aquí](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L74).
  * Este método se ha sacado de la historia de usuario [HU7](https://github.com/mjls130598/SharingNotes/issues/17).

* [**Buscar comentarios de un apunte**](https://github.com/mjls130598/SharingNotes/blob/d1cc1af8772e0b11eca7411ec43af78ada6ae07f/src/SharingNotes/src/main/scala/SharingNotes.scala#L129): mostrar aquellos comentarios sobre un apunte previamente dado.
  * El test de esta función se puede observar [aquí](https://github.com/mjls130598/SharingNotes/blob/17aebbd100823f08c25118b91090e8700ccf0386/src/SharingNotes/src/test/scala/SharingNotesTest.scala#L99).
  * Este método corresponde a la historia de usuario [HU12](https://github.com/mjls130598/SharingNotes/issues/31).

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).
