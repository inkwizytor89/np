package controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Scanner;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public class InputReader {
    private Scanner input;
    
    /**
     * Czytanie ze standardowego wejścia
     */
    public InputReader() {
        input = new Scanner(System.in);
    }
    
    /**
     * Czytanie z pliku
     * @param filePath 
     */
    public InputReader(String filePath) {
        File file = new File(filePath);
        try {
            input = new Scanner(file);
        } catch (FileNotFoundException ex) {
            throw new RuntimeException("Brak do odczytu pliku "+filePath);
        }
    }
    
    /**
     * Generowanie grafu z zadanego inputu.
     * @return 
     */
    public Graph getGraph() {
        
        Integer v = input.nextInt();
        Integer e = input.nextInt();

        LinkedList<Edge> edges = new LinkedList<>();
        
        Vertex[] vertices = new Vertex[v];
        for(int i=0;i<v;i++) {
            vertices[i] = new Vertex(i);
        }
        
        for (int i=0;i<e;i++) {
            Integer v1 = input.nextInt() -1;
            Integer v2 = input.nextInt() -1;
            Integer l = input.nextInt();
            Integer p = input.nextInt();
            
            Edge edge;
            if (v2<v1) {
                edge = new Edge(vertices[v2], vertices[v1],l*p);
            } else {
                edge = new Edge(vertices[v1], vertices[v2],l*p);
            }
            edges.add(edge);
        }
        return new Graph(vertices, edges.toArray(new Edge[edges.size()]));
    }
    
}
