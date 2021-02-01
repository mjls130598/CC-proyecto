# Actividades relacionadas con el Milestone 5

## Biblioteca Log

Para crear un documento en el que se reflejen las acciones realizadas sobre esta aplicación y los posibles errores que haya podido ocurrir sobre ella.

En este caso, para este proyecto se ha decidido utilizar *Simple Logging Facade for Java (SLF4J)* puesto que provee una interfaz para mostrar los loggings en la terminal y se puede envolver con cualquier biblioteca de logs.

*SLF4J* tiene varios niveles de mensaje log: error, info, debug, trace y warning.

Como se ha dicho anteriormente, *SLF4J* es sólo una interfaz. Para obtener la implementación real de logs en el proyecto, se debe instalar una biblioteca que realice esa función. 

Nos podemos encontrar con las siguientes bibliotecas que pueden utilizar la interfaz anterior: 

* [*Logback*](https://logback.qos.ch/): es sencilla de utilizar dentro de un proyecto en *Scala* y es lo suficientemente genérica como para aplicarse en diferentes circunstancias. Es el sucedor de *Log4j* más popular hasta el momento. No es necesario implementar directamente las dependencias con *SLF4J* puesto que están incluidas dentro de la dependencia de esta biblioteca. Los pasos para la configuración y el uso de esta biblioteca log se han obtenido de [Football Radar](https://engineering.footballradar.com/introduction-to-logging-in-scala/) y se puede ver los cambios realizados sobre el proyecto en [esta versión](https://github.com/mjls130598/SharingNotes/commit/9b130b9c4477be18fd8340af6b2535e82dbc8cda).

* [*Log4j2*](https://logging.apache.org/log4j/2.x/): su objetivo es mejorar *Log4J*, incluyendo algunas de las mejoras incluidas en *Logback* y evitando problemas de *Log4j* y *Logback*. También permite la evaluación diferida de declaraciones de registro basadas en expresiones lambda, ofrece registradores asíncronos para sistemas de baja latencia y proporciona un modo libre de basura para evitar cualquier latencia causada por las operaciones del recolector de basura. Todas estas características hacen que sea el más avanzado y el más rápido de los anteriores marcos de registro. Por problemas diversos a la hora de emplear esta biblioteca, no se ha podido subir una versión con ella.

Se ha preferido seguir utilizando *Logback* al ser más sencillo de utilizarlo.