package main;

import controller.InputReader;
import structure.graph.Graph;
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
        Graph graph = inputReader.getGraph();
        Graph mst = null;
        try {
            mst = graph.getMinimumSpanningTree();
        } catch (RuntimeException e) {
            outputWritter.setWriteError(Boolean.TRUE);
        }

        outputWritter.print(mst);
    }
    
}
