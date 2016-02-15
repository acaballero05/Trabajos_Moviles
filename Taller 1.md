## Map:
* Su medio de busqueda es la llave del dato almacenado.
* Su estructura sigue el modelo llave-valor.
* Realiza búsquedas en O(1).
* Las llaves para cceder a los datos son únicas.
## List:
* Su medio de busqueda es el índice del dato almacenado.
* Tiene una estructura secuencial.
* Realiza busquedas en O(n).
## Set:
* No permite datos repetidos.  
* Realiza busquedas de manera aleatoria.
* Realiza busquedas en O(n).

## Ejemplos:
* Cuando se requiere recorrer datos ordenados desde la primera poscición hasta la última sin nececidad de hacer búsquedas específicas, la estructura ideal es una lista, por ejemplo la lista de un grupo de estudiantes.
* Cuando se requiere almacenar datos sin tener valores repetidos y establecer relaciones entre grupos de datos, la estructura ideal es el set, por ejemplo una matricula academica.
* Cuando se requiere hacer constantes búsquedas sobre una gran cantidad de datos, la estructura ideal es map, por ejemplo las búsquedas en grafos o árboles. 