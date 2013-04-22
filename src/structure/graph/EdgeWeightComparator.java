package structure.graph;

import java.util.Comparator;

/**
 * Ustawia porządek względem wag.
 * @author kamil
 */
public class EdgeWeightComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge firstEdge, Edge secondEdge) {
        return firstEdge.weight - secondEdge.weight > 0 ? 1: -1;
    }
}
