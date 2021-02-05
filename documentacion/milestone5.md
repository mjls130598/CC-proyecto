# Actividades relacionadas con el Milestone 5

## Framework microservicio

Para *Scala* se ofrecen múltiples frameworks para construir una web API. Algunos de esos frameworks son los siguientes:

* **Play Framework**: La funcionalidad principal del marco se basa en aprovechar JVM y sus bibliotecas relacionadas para formar aplicaciones RESTful.

    * Beneficios:
        * Está íntimamente relacionado con JVM y, como tal, es familiar y fácil de usar.
        * Amplio soporte para una variedad de conjuntos de herramientas y sistemas IDE.
        * Se basa completamente en conceptos de programación funcional y promueve las prácticas de diseño RESTful que dan prioridad a las API.
        * Permite realizar llamadas remotas en paralelo. Esto significa que funciona bien con WebSockets y otros enfoques centrados en el servidor relacionados.
        * Ofrece una amplia gama de estructuras de soporte de marcos para la compilación de activos, manejo de formatos, integraciones de bases de datos, etc.
        * Es código abierto, lo que beneficia a los adoptados con una mayor seguridad y una base de código revisada constantemente.

    * Inconvenientes:
        * Su estabilidad y utilidad no siempre están garantizadas.
        * Utiliza SBT. Si bien es muy poderoso, algunos han expresado su preocupación por el uso de implícitos, importaciones de comodines y otras excentricidades que dificultan enormemente el desarrollo y la integración de la infraestructura

* **Finch**: Todo el marco se centra en el concepto de componibilidad y, como tal, es un sistema altamente modular y personalizable. Su misión es proporcionar a los desarrolladores primitivas HTTP simples y robustas que estén lo más cerca posible de la API completa de Finagle.

    * Beneficios:
        * Finch utiliza bloques funcionales para formar su marco y, como tal, es extremadamente modular.
        * Ofrece algunas primitivas HTTP bastante robustas, lo que lo hace ideal para un desarrollo y pruebas rápidos. Por esta razón, Finch es ideal para proyectos pequeños y nuevas empresas.
        * Debido a la naturaleza de su estructura, es muy rápido y altamente funcional para una variedad de sistemas.

    * Inconvenientes:
        * Está estructurado más para ser una implementación mínima que permite una mayor implementación e iteración del desarrollo.
        * No se considera una solución de pila completa.

    Intentando implementar este framework en este proyecto, se encontró un error relacionado con *JSON*. Por lo que se ha investigado, puede que sea por alguna de las dependencias anteriores que necesita el sistema para funcionar junto a aquellas que necesita el framework *Finch*. El error es el siguiente `Caused by: com.fasterxml.jackson.databind.JsonMappingException: Scala module 2.9.6 requires Jackson Databind version >= 2.9.0 and < 2.10.0`.

* **Akka HTTP**: es una implementación de Akka altamente modular y extremadamente poderosa para Scala. No es un marco web, sino un conjunto de herramientas más general para proporcionar y consumir servicios basados ​​en HTTP. Si bien la interacción con un navegador, por supuesto, también está dentro del alcance, no es el enfoque principal de Akka HTTP.

    * Beneficios:
        * El mayor beneficio de Akka HTTP es el hecho de que está integrado con la funcionalidad de Akka. Al igual que Akka, admite una gran cantidad de sistemas que pueden ejecutar comandos paralelos y procesamiento de cálculo avanzado.
        * Akka HTTP tiene una gran base de soporte de desarrolladores y colaboradores, todos alineados bajo Lightbend. Además, tiene una excelente documentación y un centro de soporte fácil de entender.

    * Inconvenientes:
        * Akka HTTP es más lento que otras implementaciones en esta lista y, como tal, si bien escala de manera eficiente, ya está comenzando detrás del paquete, por así decirlo.
        * Lightbend es una gran organización, pero quedarse atascado en un solo proveedor puede ser preocupante para muchas organizaciones. El bloqueo del proveedor puede ser costoso y difícil de romper, por lo que debe tenerse en cuenta antes de adoptar la solución.

    Se ha probado la aplicación de ejemplo que ofrece este framework y parece ser más complejo que los otros dos a la hora de unir las diversas funcionalidades creadas para este proyecto con este framework. E incluso se ha encontrado problemas a la hora de ejecutar el ejemplo comentado anteriormente.

Se ha decidido utilizar **Play Framework** porque parece más sencillo de manejar en este proyecto, aunque haya que cambiar la estructura del proyecto para adaptarse a este framework. Además, tiene implementado la configuración de logs con *logback*.

Cuando se subió la nueva estructura del proyecto a GitHub, ocurrieron problemas con este framework en *Travis* con que no sabía lo que era *PlayScala*. Por lo que a partir de este momento se decidió subir la carpeta *project* puesto que contiene información de configuración de los distintos plugins que debe manejar *sbt*.

Después de realizar esto, hubo problemas con las versiones de las dependencias y de los plugins dependiendo de la versión de *Scala* utilizada. Por lo que se modificó plugins.sbt y build.sbt con las versiones en las que ambas versiones funcionara correctamente.

## API

Las siguientes rutas que se han creado son las siguientes:

* **Apunte**:

    * *GET /apunte*: se devolverán todos los apuntes guardados en el sistema o aquellos que cumplan con los filtros o consultas dadas. Corresponde a las historias de usuario [HU11](https://github.com/mjls130598/SharingNotes/issues/30) y [HU4](https://github.com/mjls130598/SharingNotes/issues/14).
    
    * *GET /asignatura/:idAsignatura*: se devolverán todos los apuntes guardados en el sistema de una asignatura dada. Esta ruta corresponde a la historia de usuario [HU10](https://github.com/mjls130598/SharingNotes/issues/24).

    * *GET /apunte/:id*: se devuelve los datos relacionados del apunte con el identificador dado.

    * *POST /apunte*: donde se insertará un nuevo apunte al sistema. Corresponde a la historia de usuario [HU2](https://github.com/mjls130598/SharingNotes/issues/12). Para poder enviar ficheros a través de este URL se ha tenido que cambiar la versión de *SBT* puesto que con la última daba el siguiente error: `class xsbti.BasicVirtualFileRef cannot be cast to class java.io.File`.

## Biblioteca Log

Para crear un documento en el que se reflejen las acciones realizadas sobre esta aplicación y los posibles errores que haya podido ocurrir sobre ella.

En este caso, para este proyecto se ha decidido utilizar *Simple Logging Facade for Java (SLF4J)* puesto que provee una interfaz para mostrar los loggings en la terminal y se puede envolver con cualquier biblioteca de logs.

*SLF4J* tiene varios niveles de mensaje log: error, info, debug, trace y warning.

Como se ha dicho anteriormente, *SLF4J* es sólo una interfaz. Para obtener la implementación real de logs en el proyecto, se debe instalar una biblioteca que realice esa función. 

Nos podemos encontrar con las siguientes bibliotecas que pueden utilizar la interfaz anterior: 

* [*Logback*](https://logback.qos.ch/): es sencilla de utilizar dentro de un proyecto en *Scala* y es lo suficientemente genérica como para aplicarse en diferentes circunstancias. Es el sucedor de *Log4j* más popular hasta el momento. No es necesario implementar directamente las dependencias con *SLF4J* puesto que están incluidas dentro de la dependencia de esta biblioteca. Los pasos para la configuración y el uso de esta biblioteca log se han obtenido de [Football Radar](https://engineering.footballradar.com/introduction-to-logging-in-scala/) y se puede ver los cambios realizados sobre el proyecto en [esta versión](https://github.com/mjls130598/SharingNotes/commit/9b130b9c4477be18fd8340af6b2535e82dbc8cda).

* [*Log4j2*](https://logging.apache.org/log4j/2.x/): su objetivo es mejorar *Log4J*, incluyendo algunas de las mejoras incluidas en *Logback* y evitando problemas de *Log4j* y *Logback*. También permite la evaluación diferida de declaraciones de registro basadas en expresiones lambda, ofrece registradores asíncronos para sistemas de baja latencia y proporciona un modo libre de basura para evitar cualquier latencia causada por las operaciones del recolector de basura. Todas estas características hacen que sea el más avanzado y el más rápido de los anteriores marcos de registro. Por problemas diversos a la hora de emplear esta biblioteca, no se ha podido subir una versión con ella.

Se ha preferido seguir utilizando *Logback* al ser más sencillo de utilizarlo.

## Configuración distribuida

Como se ha podido ver en la teoría de *Configuración de microservicios*, hay varias opciones para realizar la configuración distribuida:

* *etcd*
* *Zookeper*
* *Consul*

Se puede ver en este archivo donde se han realizado los [ejercicios relacionados con este tema](https://github.com/mjls130598/CC-ejercicios/blob/master/ej_tema7.md) en los que se han utilizado la primera y última configuración con el lenguaje de programación que se está construyendo el proyecto.

Por la simplicidad a la hora de utilizarla en cualquier proyecto *Scala*, se ha decidido utilizar *etcd* usando la biblioteca [*etcd4s*](https://github.com/mingchuno/etcd4s).