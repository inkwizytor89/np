package structure.graph;

import java.util.Comparator;

/**
 * Ustawia porządek leksykograficzny krawędzi.
 * @author kamil
 */
public class EdgeShowComparator implements Comparator<Edge> {

    @Override
    public int compare(Edge firstEdge, Edge secondEdge) {
        if(firstEdge.vertexStart.toInteger() == secondEdge.vertexStart.toInteger()){
            return firstEdge.vertexEnd.toInteger() - secondEdge.vertexEnd.toInteger();
        }
        return firstEdge.vertexStart.toInteger() - secondEdge.vertexStart.toInteger();
    }
}
