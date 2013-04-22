package naive;

import java.util.LinkedList;
import structure.graph.Graph;
import structure.graph.Vertex;
import sun.misc.Cache;

public class DegreeVertexCover {
    
    public static LinkedList<Vertex> cache;
    
    public static Integer coverCound(Graph graph) {
        
        LinkedList<Vertex> cover = new LinkedList<>();
        while (graph.getEdges().length > 0) {
            Vertex minDegreeVertex = graph.getGreedyVertex();
            Vertex localGreedVertex = graph.getLocalGreedVertex(minDegreeVertex);
            cover.add(localGreedVertex);
            graph.removeConnectedEdges(localGreedVertex);
        }
        cache = cover;
        return cover.size();
    }
    
    public static String show() {
        String result = "[ ";
        for (Vertex v : cache) {
            result+=v.index+" ";
        }
        return result+"]";
    }
    
}
