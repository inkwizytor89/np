package structure.graph;

/**
 * Klasa opisująca wierzchołek.
 * @author kamil
 */
public class Vertex {

    /**
     * Identyfikator wierzchołka.
     */
    public Integer index;

    public Vertex(Integer index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return index.toString();
    }

    public Integer toInteger() {
        return index;
    }
}
