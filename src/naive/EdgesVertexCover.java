package naive;

import java.util.LinkedList;
import structure.graph.Graph;
import structure.graph.Vertex;

public class EdgesVertexCover {
    public static Integer coverCound(Graph graph) {
        LinkedList<Vertex> cover = new LinkedList<>();
        while (graph.getEdges().length > 0) {
            Vertex start = graph.getEdges()[0].getVertexStart();
            Vertex end = graph.getEdges()[0].getVertexEnd();
            cover.add(start);
            cover.add(end);
            graph.removeConnectedEdges(start);
            graph.removeConnectedEdges(end);
        }
        return cover.size();
    }
}
