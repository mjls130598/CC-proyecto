# Actividades relacionadas con Milestone 4

## Avance del proyecto

* Antes de seguir con las actividades relacionadas con el milestone 4, se arreglaron algunos aspectos de los dos últimos milestones anteriores. Los issues correspondientes a estos arreglos se encuentran en el milestone ["Arreglos del milestone 2 y 3"](https://github.com/mjls130598/SharingNotes/milestone/12?closed=1) que se realizaron:

 * Se corrigió la estructura del proyecto, poniendo el directorio que contiene el código del proyecto en la raíz del proyecto y su estructura interior dejándola de la siguiente manera:
 ```
 src/
  |-- main/
    |-- scala/
      |-- SharingNotes/
  |-- test/
    |-- scala/
 ```

 * Se mejoró la seguridad con respecto al usuario cambiando la clase controladora por una clase controladora "estática" para que las clases Administrador y Usuario pudieran llamarla y ver los cambios realizados sobre esa clase. En Scala no existe la palabra *static*, por lo tanto, la manera de realizar una clase "estática" es creando una clase que contenga los datos y, después, crear un *object* con el mismo nombre que la clase anterior que se encarga de modificar los datos de esa clase.

 * Antes de guardar un apunte, se comprobó que el archivo dado es un PDF. Para comprobarlo hizo falta instalar como dependencia *Tika* puesto que tiene un método que puede detectar el formato de un fichero. Para que cualquiera pueda pasar los tests correspondientes a esta parte, se creó el directorio *documentos_prueba" con un conjunto de ficheros de distintos tipos.

 * Una vez comprobado que ese archivo es un PDF, se guardan dentro del sistema. Para guardarlo se añadió como dependencia del proyecto varias dependencias de *Hadoop* que realiza una copia exacta del fichero dado.

 * Se cambió la manera de crear nuevos identificadores. Se realizó de la misma manera que una página encontrada dentro de GitHub de [sarveshseri](https://gist.github.com/sarveshseri/f188a1a52ff966c63ea4).

 * Por último, se cambió la imagen base de Docker a *Alpine* puesto que, en comparación con otras probadas como *Ubuntu* y *Debian-Slim*, es la que menos tamaño ocupa para este proyecto.
