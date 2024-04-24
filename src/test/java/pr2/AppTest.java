package pr2;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
public class AppTest {
    /**
     * Rigorous Test :-)
     */
    
    /**
     * Prueba unitaria para el método shortestPathFindsAPath.
     * Comprueba si el método shortestPathFindsAPath encuentra un camino en un grafo.
     */
    @Test
    public void shortestPathFindsAPath() {
        System.out.println("\nTest shortestPathFindsAPath");
        System.out.println("----------------------------");

        // Construimos el grafo
        Grafo<Integer> g = new Grafo<>();
        g.addEdge(1, 2);
        g.addEdge(1, 5);
        g.addEdge(2, 3);
        g.addEdge(3, 4);
        g.addEdge(5, 4);

        // Construimos el camino esperado
        List<Integer> expectedPath = new ArrayList<>();
        expectedPath.add(1);
        expectedPath.add(5);
        expectedPath.add(4);

        // Comprobamos si el camino devuelto es igual al esperado
        assertEquals(expectedPath, g.caminoMasCorto(1, 4));
    }
}