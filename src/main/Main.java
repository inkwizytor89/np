package main;

import naive.DegreeVertexCover;
import naive.EdgesVertexCover;
import naive.NaiveVertexCover;
import structure.graph.Graph;
import test.GraphGenerator;
import test.LeaktGraphGenerator;
import test.NaiveGraphGenerator;

public class Main {

    public static void main(String[] args) {
        GraphGenerator g = new LeaktGraphGenerator();
        do {
            
                System.out.println(" Vertex: "+g.getVertexCount());
            do {
                Graph graph = g.buildGraph();
                Integer mentor = NaiveVertexCover.coverCound(graph.copedGraphEdges());
                Integer degree = DegreeVertexCover.coverCound(graph.copedGraphEdges());
                Integer edge = EdgesVertexCover.coverCound(graph.copedGraphEdges());
                if (mentor > edge) {
                    throw new RuntimeException("solution edge better than the best "+edge+"|"+mentor+" "+g.toString());
                }
                if (mentor > degree) {
                    throw new RuntimeException("solution degree better than the best "+degree+"|"+mentor+" "+g.toString());
                }
                if (mentor < degree) {
                    System.out.println(edge+"|"+degree+" "+DegreeVertexCover.show()+"|"+mentor+" "+NaiveVertexCover.show()+" -> "+g.toString());
                }
            } while (g.nextEdgeSystem());
        } while (g.addVertex());
    }
//    public static void main(String[] args) {
//        String input = null;
//        String output = null;
//        
//        if(args.length > 0) {
//            input = args[0];
//        }
//        
//        if(args.length > 1) {
//            output = args[1];
//        }
//        
//        new Manager(input, output);
//        
//    }
}
