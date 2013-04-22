package naive;

import java.util.LinkedList;
import java.util.List;
import structure.bitvector.BitVector;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public class NaiveVertexCover {
    
    public static LinkedList<Vertex> cache;

    public static Boolean isCovered(Graph graph, List<Vertex> cover) {
        for (Edge edge : graph.getEdges()) {
            if (!cover.contains(edge.getVertexStart()) && !cover.contains(edge.getVertexEnd())) {
                return false;
            }
        }
        return true;
    }
    
    public static Integer coverCound(Graph graph) {
        Integer vertexCount = graph.getVerticesCount();
        Integer coverResult = vertexCount;
        BitVector bitVector = new BitVector(vertexCount);
        LinkedList<Vertex> cover = new LinkedList<>();
        do {
            LinkedList<Vertex> tempCover = new LinkedList<>();
            for (int i=0;i<vertexCount;i++) {
                if (bitVector.getPositionValue(i)) {
                    tempCover.add(graph.getVertices()[i]);
                }
            }
            if (isCovered(graph, tempCover) && tempCover.size() < coverResult) {
                cover = tempCover;
                coverResult = tempCover.size();
            }
        }while (bitVector.next());
        cache = cover;
        return coverResult;
    }
    
    public static String show() {
        String result = "[ ";
        for (Vertex v : cache) {
            result+=v.index+" ";
        }
        return result+"]";
    }
}
