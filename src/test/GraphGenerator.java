package test;

import java.util.LinkedList;
import structure.bitvector.BitVector;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public abstract class GraphGenerator {

    /**
     * Wektor odpowiedizalny za tworzenie krawędzie w grafie. Interpretacja
     * krawędzi na kolejnych pozycjach 01 02 03 ... 12 13 ...
     */
    protected BitVector edgesBitVector = new BitVector();
    /**
     * Liczba wierzchołków na ilu ma być wygenerowany graf
     */
    protected Integer vertexCount = 1;

    protected void buildGenerator(Integer size) {
        this.edgesBitVector = new BitVector(size * (size - 1) / 2);
        vertexCount = size;
    }

    public GraphGenerator() {
        buildGenerator(1);
    }

    public GraphGenerator(Integer size) {
        buildGenerator(size);
    }

    public Integer getVertexCount() {
        return vertexCount;
    }

    public Graph buildGraph() {
        Vertex[] vertices = new Vertex[vertexCount];
        for (int i = 0; i < vertexCount; i++) {
            vertices[i] = new Vertex(i);
        }

        LinkedList<Edge> edgesList = new LinkedList<>();
        Integer bitVectorCount = 0;
        for (int i = 0; i < vertexCount - 1; i++) {
            for (int j = i + 1; j < vertexCount; j++) {
                if (edgesBitVector.getPositionValue(bitVectorCount++)) {
                    edgesList.add(new Edge(vertices[i], vertices[j]));
                }
            }
        }
        Edge[] edges = edgesList.toArray(new Edge[edgesList.size()]);
        return new Graph(vertices, edges);
    }

    public abstract Boolean nextEdgeSystem();

    public abstract Boolean addVertex();

    @Override
    public String toString() {
        return "(" + vertexCount + ") " + edgesBitVector.toString() + "[" + edgesBitVector.getBitSum() + "]";
    }
}
