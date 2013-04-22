package structure.graph;

/**
 * Klasa przedstawiająca krawędz nie skierowaną.
 * @author kamil
 */
public class Edge {

    Vertex vertexStart;
    Vertex vertexEnd;

    
    Integer weight;
    
    public Edge(Vertex vertexStart, Vertex vertexEnd) {
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
    }

    public Edge(Vertex vertexStart, Vertex vertexEnd, Integer weight) {
        this.vertexStart = vertexStart;
        this.vertexEnd = vertexEnd;
        this.weight = weight;
    }

    public Vertex getVertexStart() {
        return vertexStart;
    }

    public Vertex getVertexEnd() {
        return vertexEnd;
    }

    public Integer getWeight() {
        return weight;
    }
    
    public Boolean contains(Vertex vertex) {
        return vertex.equals(vertexStart) || vertex.equals(vertexEnd);
    }

    @Override
    public String toString() {
        if (weight == null) {
            return "Edge: "+vertexStart.toString()+" "+vertexEnd.toString()+"\n";
        }
        return vertexStart.toString()+" "+vertexEnd.toString()+" "+weight+"\n";
    }

    Vertex getAnotherVertex(Vertex vertex) {
        if (vertex.equals(vertexStart)) {
            return vertexEnd;
        }
        return vertexStart;
    }
}
