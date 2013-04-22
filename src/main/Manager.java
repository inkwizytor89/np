package main;

import controller.InputReader;
import naive.DegreeVertexCover;
import naive.EdgesVertexCover;
import naive.NaiveVertexCover;
import structure.graph.Graph;
import test.GraphGenerator;
import test.LeaktGraphGenerator;
import view.OutputWritter;

public class Manager {

    /**
     * Pobranie wejścia do postaci grafu. Utworzenie MST z zadanego grafu oraz
     * wypisanie rozwiązania.
     * @param input
     * @param output 
     */
    Manager(String input, String output) {

        InputReader inputReader;
        OutputWritter outputWritter;
        if(input == null) {
            inputReader = new InputReader();
        } else {
            inputReader = new InputReader(input);
        }
        
        if (output == null) {
            outputWritter = new OutputWritter();
        } else {
            outputWritter = new OutputWritter(output);
        }
        
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
    
}
