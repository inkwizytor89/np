package view;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;
import structure.graph.Edge;
import structure.graph.Graph;

public class OutputWritter {

    private PrintStream out;
    private Boolean writeError = false;

    /**
     * Zapis do standardowego wyjścia.
     */
    public OutputWritter() {
        out = System.out;
    }

    /**
     * Zapis do pliku.
     * @param filePath 
     */
    public OutputWritter(String filePath) {
        try {
            out = new PrintStream(new FileOutputStream(filePath));
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Błąd przy zapisie do pliku "+filePath);
        }
    }

    /**
     * Jeśli w grafie nie można wyznaczyć MST np. graf jest nie spójny.
     * @param writeError 
     */
    public void setWriteError(Boolean writeError) {
        this.writeError = writeError;
    }

    /**
     * Wypisanie wyjścia w formacie specyfikującym przez zadanie. W przypadku błędu w danych -1.
     * @param graph 
     */
    public void print(Graph graph) {
        if (writeError) {
            out.println("-1");
            return;
        }
        //graph.prepareToShow();
        Integer price = 0;
        for (Edge edge : graph.getEdges()) {
            price += edge.getWeight();
        }
        out.println(price);
        for (Edge edge : graph.getEdges()) {
            Integer start = edge.getVertexStart().toInteger() +1;
            Integer end = edge.getVertexEnd().toInteger() +1;
            out.println(start+" "+end);
        }
        out.close();
    }
}
