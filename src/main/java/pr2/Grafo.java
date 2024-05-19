package pr2;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

/**
 * Esta clase representa un grafo genérico.
 * Permite agregar vértices, agregar aristas, obtener los vértices adyacentes,
 * verificar si contiene un vértice y encontrar el camino más corto entre dos vértices.
 *
 * @param <V> el tipo de los vértices del grafo
 */

public class Grafo<V> {

    private Map<V, Set<V>> listaAdyacencia = new HashMap<>();

    /**
     * Agrega un vértice al grafo.
     *
     * @param v el vértice a agregar
     * @return true si se agrega correctamente, false si el vértice ya existe en el grafo
     */
    public boolean agregarVertice(V v) {
        if (listaAdyacencia.containsKey(v)) {
            return false;
        }
        listaAdyacencia.put(v, new HashSet<>());
        return true;
    }

    /**
     * Agrega una arista entre dos vértices del grafo.
     * Si los vértices no existen en el grafo, se agregan automáticamente.
     *
     * @param v1 el primer vértice de la arista
     * @param v2 el segundo vértice de la arista
     * @return true si se agrega correctamente la arista
     */
    public boolean addEdge(V v1, V v2) {
        if (!listaAdyacencia.containsKey(v1)) {
            agregarVertice(v1);
        }
        if (!listaAdyacencia.containsKey(v2)) {
            agregarVertice(v2);
        }
        listaAdyacencia.get(v1).add(v2);
        listaAdyacencia.get(v2).add(v1);
        return true;
    }

    /**
     * Obtiene los vértices adyacentes a un vértice dado.
     *
     * @param v el vértice del cual se obtienen los adyacentes
     * @return un conjunto de vértices adyacentes a v
     */
    public Set<V> obtenerAdyacentes(V v) {
        return listaAdyacencia.getOrDefault(v, new HashSet<>());
    }

    /**
     * Verifica si el grafo contiene un vértice dado.
     *
     * @param v el vértice a verificar
     * @return true si el grafo contiene el vértice, false en caso contrario
     */
    public boolean contieneVertice(V v) {
        return listaAdyacencia.containsKey(v);
    }

    /**
     * Devuelve una representación en forma de cadena del grafo.
     *
     * @return una cadena que representa el grafo
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (V v : listaAdyacencia.keySet()) {
            sb.append(v).append(": ");
            for (V adyacente : listaAdyacencia.get(v)) {
                sb.append(adyacente).append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    /**
     * Encuentra el camino más corto entre dos vértices del grafo.
     *
     * @param inicio el vértice de inicio del camino
     * @param fin el vértice de fin del camino
     * @return una lista de vértices que representa el camino más corto desde inicio hasta fin
     */
    public List<V> caminoMasCorto(V inicio, V fin) {
        Map<V, V> padres = new HashMap<>();
        Set<V> visitados = new HashSet<>();
        Queue<V> cola = new LinkedList<>();

        visitados.add(inicio);
        cola.add(inicio);

        while (!cola.isEmpty()) {
            V actual = cola.remove();

            if (actual.equals(fin)) {
                break;
            }

            for (V adyacente : listaAdyacencia.get(actual)) {
                if (!visitados.contains(adyacente)) {
                    cola.add(adyacente);
                    visitados.add(adyacente);
                    padres.put(adyacente, actual);
                }
            }
        }

        if (!padres.containsKey(fin)) {
            return new ArrayList<>(); 
        }

        List<V> camino = new ArrayList<>();
        V actual = fin;
        while (actual != null) {
            camino.add(0, actual);
            actual = padres.get(actual);
        }

        return camino;
    }
}