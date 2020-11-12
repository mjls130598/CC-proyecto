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

## Justificación del gestor de tareas y del marco de prueba elegidos

Para *Scala* se ofrece una diversidad de gestores de tareas como los siguientes:

* **sbt (Scala Build Tool)**:
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

* **Maven**:
  * Su estructura de directorios es similar a la de *sbt*.
  * Con un archivo en XML describe el proyecto de software que se está construyendo, sus dependencias, el orden de construcción, los directorios y los complementos necesarios.
  * Utiliza convenciones para el procedimiento de compilación y solo es necesario anotar las excepciones.
  * Descarga dinámicamente las bibliotecas de Java y los complementos de Maven y los almacena en una caché local.
  * Las dependencias se pueden cargar desde el sistema de archivos local o desde repositorios públicos.
  * Tiene una arquitectura basada en complementos que le permite hacer uso de cualquier aplicación controlable a través de la entrada estándar.
  * Como *sbt*, incorpora la compilación, los tests y la implementación.
  * Intenta evitar la mayor cantidad de configuración posible, proporcionando plantillas de proyecto.
  * Ofrece aislamiento entre las dependencias del proyecto y los complementos.

* **Gradle**:
  * Utiliza un DAG para determinar el orden en el que las tareas pueden ser ejecutadas.
  * Introduce *Groovy* y *Kotlin* basados en *DSL*.
  * Diseñado para la compilación de proyectos grandes.
  * Admite el almacenamiento en caché de componentes de compilación.
  * Ofrece un software que es extensible para nuevas funciones y lenguajes de programación con un subsistema de complementos.
  * Como los dos gestores anteriores, ofrece la compilación, los test y la implementación del proyecto.
  * Como *sbt* y *Maven*, separa los ficheros de distintos idiomas en distintas carpetas, divide el código que implementa el proyecto y el que realiza los tests e incluye un fichero de configuración y varias carpetas con un archivo de construcción por cada subproyecto.

Se elige *sbt* al ser el más utilizado para realizar proyectos en *Scala*, al tener una estructura de escritorio sencilla, al ser fácil su uso y al no estar archivo de configuración en XML. Su configuración se encuentra en el fichero [*build.sbt*](https://github.com/mjls130598/SharingNotes/blob/master/src/SharingNotes/build.sbt).

## Justificación de la biblioteca de aserciones

En Scala hay varias bibliotecas que se encargan de realizar las aserciones. En este caso se centrarán en las siguientes:

* **ScalaTest**:
  * Soporta diferentes estilos de test.
  * Es la herramienta de test más flexible actualmente.
  * Se puede utilizar tanto para *Scala* como para *Java*.
  * Puede escalar en proyectos de todos los tamaños.
  * Es muy rápido aprender a realizar tests.
  * Se pueden realizar tanto tests *TDD* como *BDD*.
  * Se pueden hacer múltiples comparaciones en una prueba.
  * Los *DSLs* para *Scala* son más potentes que los de *Java*.
  * Ofrece, además de aserciones, potentes *matchers*.

* **JUnit**:
  * Es un marco de código abierto que se ocupa de la escritura y de la ejecución de los tests de un proyecto.
  * Está pensado para utilizarlo en *Java*.
  * Es rápido y sencillo escribir el código.
  * Muestra el progreso de la prueba en una barra.
  * Se puede realizar tanto *BDD* como *TDD*.

* **ScalaCheck**:
  * Se puede utilizar tanto en *Java* como en *Scala*.
  * Está integrado sobre otros marcos de prueba como *ScalaTest*.
  * No utiliza aserciones, sino propiedades.
  * Dentro de una propiedad, se pueden añadir varios argumentos que comprueben el correcto funcionamiento de una parte del código del proyecto.
  * Ofrece un generador de datos para utilizarlos en los tests.
  * Para comprobar que una función se realiza correctamente, ejecuta más de una vez el test que comprueba su funcionalidad.
  * Sólo se puede realizar para *TDD*.

Se elige la biblioteca *ScalaTest* puesto que es la más popular con diferencia para el lenguaje *Scala*, tiene una gran variedad de estilos de tests, es muy flexible a la hora de crear pruebas, es también muy rápido de aprender a realizar tests de distintas complejidades y se pueden realizar múltiples comparaciones en un test.

## Documentaciones

La documentación de este proyecto se encuentra en varios archivos dentro del [directorio documentación](https://github.com/mjls130598/SharingNotes/tree/master/documentacion).

La información que estaba escrita en este mismo fichero para el milestone 0 se encuentra en el siguiente [archivo](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone0.md).

La explicación de las actividades realizadas para el milestone 1 está en [milestone1.md](https://github.com/mjls130598/SharingNotes/blob/master/documentacion/milestone1.md).
