# SharingNotes

## Descripción del problema

En estos momentos, al ser la gran mayoría de las clases virtuales, es difícil recoger buenos apuntes de las asignaturas ya sea por problemas tecnológicos o al no estar físicamente con tus compañeros para compartir conocimientos.

Por lo tanto, este proyecto se basa en crear una plataforma donde cualquier alumno pueda subir sus apuntes para que los vean el resto, visualizar aquellos que necesite, buscar aquel apunte que necesita acceder, compartirlo por alguna red social o realizar comentarios sobre un apunte en concreto.

## Herramientas y tecnologías escogidas

* La arquitectura de este proyecto está basada en una arquitectura microservicios.
* El siguiente programa está escrito en el lenguaje de programación *Scala*.
* El gestor de tareas y el marco de prueba que se va a utilizar es *sbt (Scala Build Tool)*.
* La biblioteca que se va a usar para realizar los test es la bibliteca *assert* que viene con el lenguaje *Scala*.

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

## Justificación de la biblioteca de aserciones

Se ha elegido para hacer los distintos tests sobre el programa que se está realizando la biblioteca *Assertion* puesto que ofrece distintas aserciones, entre las principales se encuentran:

* Una general con *assert*.
* Una más específica para diferenciar los valores obtenidos con los esperados con *assertResult*.
* Otra más específica para asegurarse que realiza las correspondientes excepciones con *assertThrows*.

La información obtenida sobre esta biblioteca se recogió de la página oficial de [*ScalaTest*](https://www.scalatest.org/user_guide/using_assertions).

## Justificación del gestor de tareas  y del marco de prueba elegidos

Para *Scala* se ofrece una diversidad de gestores de tareas como los siguientes:

* *sbt (Scala Build Tool)*:
  * Ofrece una estructura de directorios sencilla que separa los test del código en sí:
    ```
    build.sbt
    project/
    src/
      |-- main/
        |-- java/
        |-- resources/
        |-- scala/
      |-- test/
        |-- java/
        |-- resources/
        |-- scala/
    target
    ```
  * Fue específicamente creada para *Scala*.
  * Soporte nativo para integrarse con muchos marcos de prueba.
  * Ofrece la compilación, los test y la implementación.
  * Sólo se vuelve a compilar aquellas fuentes que se hayan modificado o las pruebas que no se hayan superado previamente.
  * Construye las descripciones escritas en *Scala* usando *DSL*.
  * La gestión de dependencias la realiza a través de *Apache Ivy*, la cual permite los repositorios en formato Maven.
  * Rápida iteración y depuración al incorporar el intérprete de *Scala*.
  * Soporta proyectos mixtos Java-Scala.

* *Maven*:
  * Su estructura de directorios es similar a la de *sbt*.
  * Con un archivo en XML describe el proyecto de software que se está construyendo, sus dependencias, el orden de construcción, los directorios y los complementos necesarios.
  * Utiliza convenciones para el procedimiento de compilación y solo es necesario anotar las excepciones.
  * Descarga dinámicamente las bibliotecas de Java y los complementos de Maven y los almacena en una caché local.
  * Las dependencias se pueden cargar desde el sistema de archivos local o desde repositorios públicos.
  * Tiene una arquitectura basada en complementos que le permite hacer uso de cualquier aplicación controlable a través de la entrada estándar.
  * Como *sbt*, incorpora la compilación, los tests y la implementación.
  * Intenta evitar la mayor cantidad de configuración posible, proporcionando plantillas de proyecto.
  * Ofrece aislamiento entre las dependencias del proyecto y los complementos.

* *Gradle*:
  * Utiliza un DAG para determinar el orden en el que las tareas pueden ser ejecutadas.
  * Introduce *Groovy* y *Kotlin* basados en *DSL*.
  * Diseñado para la compilación de proyectos grandes.
  * Admite el almacenamiento en caché de componentes de compilación.
  * Ofrece un software que es extensible para nuevas funciones y lenguajes de programación con un subsistema de complementos.
  * Como los dos gestores anteriores, ofrece la compilación, los test y la implementación del proyecto.
  * Como *sbt* y *Maven*, separa los ficheros de distintos idiomas en distintas carpetas, divide el código que implementa el proyecto y el que realiza los tests e incluye un fichero de configuración y varias carpetas con un archivo de construcción por cada subproyecto.

Se elige *sbt* al ser el más utilizado para realizar proyectos en *Scala*, al tener una estructura de escritorio sencilla, al ser fácil su uso y al no estar archivo de configuración en XML. Su configuración se encuentra en el fichero [*build.sbt*](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/build.sbt).

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).
