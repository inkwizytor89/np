package naive;

import static com.sun.media.sound.SF2Modulator.SOURCE_POLARITY_BIPOLAR;
import java.util.LinkedList;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public class DumpDegreeVertexCover {
    
    public static LinkedList<Vertex> cache;
    
    public static Integer coverCound(Graph graph) {
        
        LinkedList<Vertex> cover = new LinkedList<>();
        while (graph.getEdges().length > 0) {
//            System.out.println("Sa krawedzie ");
//            System.out.println("Sa krawedzie "+graph.toString());
            Vertex minDegreeVertex = graph.getMinDegreeVertexNotInsulated();
            Vertex localGreedVertex = graph.getLocalGreedVertex(minDegreeVertex);
            cover.add(localGreedVertex);
//            System.out.println("min "+minDegreeVertex.toString());
//            System.out.println("conn "+localGreedVertex.toString());
            graph.removeConnectedEdges(localGreedVertex);
        }
//        if (graph.getVerticesCount() == 6 &&  cover.size() == 4) {
//        for(Vertex v : cover)
//        System.out.print(v.toString()+" "); System.out.println("");}
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
