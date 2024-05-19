# Camino más corto entre dos Vertices 

Este proyecto implementa una clase Grafo genérica en Java. La clase Grafo permite agregar vértices, agregar aristas, obtener los vértices adyacentes, verificar si contiene un vértice y encontrar el camino más corto entre dos vértices.

## Métodos

La clase Grafo proporciona los siguientes métodos:

- `agregarVertice(V v)`: Agrega un vértice al grafo.
- `addEdge(V v1, V v2)`: Agrega una arista entre dos vértices del grafo. Si los vértices no existen en el grafo, se agregan automáticamente.
- `obtenerAdyacentes(V v)`: Obtiene los vértices adyacentes a un vértice dado.
- `contieneVertice(V v)`: Verifica si el grafo contiene un vértice dado.
- `caminoMasCorto(V inicio, V fin)`: Encuentra el camino más corto entre dos vértices del grafo.

## Ejemplo de uso

Pruebas

Este proyecto incluye pruebas unitarias para la clase Grafo. Para ejecutar las pruebas, usa el comando `mvn test`.

Generación de documentación

Para generar la documentación del proyecto en formato HTML, usa el comando `mvn javadoc:javadoc`.

Empaquetado

Para empaquetar el proyecto en un archivo JAR, usa el comando `mvn package`. El archivo JAR se generará en el directorio `target`.

## Licencia

Este proyecto está licenciado bajo los términos de la licencia Apache 2.0. LICENSE[LICENSE].

## Propietario

Este proyecto es propiedad de Flavia Mendez.

## Fecha

Este documento fue creado el [17-05-2024].

