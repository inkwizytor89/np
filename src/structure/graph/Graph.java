package structure.graph;

import java.util.Arrays;
import java.util.LinkedList;
import structure.grapf.exception.SeparableGraphException;
import structure.set.Node;

/**
 * Klasa opisujaca graf
 *
 * @author kamil
 */
public class Graph {

    private Vertex[] vertices;
    private Edge[] edges;

    public Graph(Vertex[] vertices, Edge[] edges) {
        this.vertices = vertices;
        this.edges = edges;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public Integer getVerticesCount() {
        return vertices.length;
    }

    public Vertex[] getVertices() {
        return vertices;
    }

    /**
     * Zwraca podgraf grafu głównego będący minimalnym drzewem wg algorytmu
     * Kraskala.
     *
     * @return
     */
    public Graph getMinimumSpanningTree() {
        Node[] nodeVertices = new Node[vertices.length];
        for (int i = 0; i < vertices.length; i++) {
            nodeVertices[i] = new Node();
        }
        Arrays.sort(edges, new EdgeWeightComparator());
        LinkedList<Edge> mst = new LinkedList<>();
        for (Edge edge : edges) {
            Node start = nodeVertices[edge.getVertexStart().index].find();
            Node end = nodeVertices[edge.getVertexEnd().index].find();
            if (!start.equals(end)) {
                mst.add(edge);
                start.union(end);
            }
        }
        if (mst.size() != vertices.length - 1) {
            throw new SeparableGraphException();
        }
        return new Graph(vertices, mst.toArray(new Edge[mst.size()]));
    }

    /**
     * Wowołuje na grafie leksykograficzny porządek.
     */
    public void prepareToShow() {
        Arrays.sort(edges, new EdgeShowComparator());
    }

    public void removeConnectedEdges(Vertex vertex) {
        LinkedList<Edge> newEdges = new LinkedList<>();
        for (Edge edge : edges) {
            if (!edge.contains(vertex)) {
                newEdges.add(edge);
            }
        }
        edges = newEdges.toArray(new Edge[newEdges.size()]);
    }

    public Integer degree(Vertex vertex) {
        Integer count = 0;
        for (Edge edge : edges) {
            if (edge.contains(vertex)) {
                count++;
            }
        }
        return count;
    }

    public Vertex getMinDegreeVertex() {
        Integer[] degrees = new Integer[vertices.length];
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = 0;
        }
        for (Edge edge : edges) {
            Vertex start = edge.getVertexStart();
            Vertex end = edge.getVertexEnd();
            degrees[start.index]++;
            degrees[end.index]++;
        }
        Integer index = 0;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] < degrees[index]) {
                index = i;
            }
        }
        return vertices[index];
    }

    public Vertex getMinDegreeVertexNotInsulated() {
        Integer[] degrees = new Integer[vertices.length];
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = 0;
        }
        for (Edge edge : edges) {
            Vertex start = edge.getVertexStart();
            Vertex end = edge.getVertexEnd();
            degrees[start.index]++;
            degrees[end.index]++;
        }
        Integer index = null;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] > 0) {
                index = i;
                break;
            }
        }
        if (index == null) {
            throw new RuntimeException("Not uninsulates vertex in grapf");
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] < degrees[index] && degrees[i] > 0) {
                index = i;
            }
        }
        return vertices[index];
    }

    /**
     * Zwraca wierzchołek o największym stopniu w grafie
     */
    public Vertex getGreedyVertex() {
        Integer[] degrees = new Integer[vertices.length];
        for (int i = 0; i < degrees.length; i++) {
            degrees[i] = 0;
        }
        for (Edge edge : edges) {
            Vertex start = edge.getVertexStart();
            Vertex end = edge.getVertexEnd();
            degrees[start.index]++;
            degrees[end.index]++;
        }
        Integer index = null;
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] > 0) {
                index = i;
                break;
            }
        }
        if (index == null) {
            throw new RuntimeException("Not uninsulates vertex in grapf");
        }
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] <= degrees[index] && degrees[i] > 0) {
                Integer indexGreedy = degree(getLocalGreedVertex(vertices[index]));
                Integer iGreedy = degree(getLocalGreedVertex(vertices[i]));

                if (degrees[i] == degrees[index] && iGreedy > indexGreedy) {
                    index = i;
                }
                if (degrees[i] < degrees[index]) {
                    index = i;
                }
            }
        }
        return vertices[index];
    }

    /**
     * Zwraca wierzchołek o największym stopniu incydentny dla zadanego
     * wierzchołka
     *
     * @param vertex zadany wierzchołek
     * @return lokalny wierzchołek o największym stopniu
     */
    public Vertex getLocalGreedVertex(Vertex vertex) {
        Vertex localMaxDegreeVertex = vertex;
        Integer localMaxDegreeDegree = 0;
        for (Edge edge : edges) {
            if (edge.contains(vertex)) {
                Vertex tempV = edge.getAnotherVertex(vertex);
                Integer tempD = degree(tempV);
                if (tempD > localMaxDegreeDegree) {
                    localMaxDegreeVertex = tempV;
                    localMaxDegreeDegree = tempD;
                }
            }
        }
        return localMaxDegreeVertex;
    }

    /**
     * Generuje kopie grafu ze względu na tablice krawędzi
     *
     * @return kopia grafu
     */
    public Graph copedGraphEdges() {
        Vertex[] vertices = this.vertices;
        LinkedList<Edge> copyEdges = new LinkedList<>();
        for (Edge edge : edges) {
            copyEdges.add(edge);
        }
        return new Graph(vertices, copyEdges.toArray(new Edge[copyEdges.size()]));
    }

    @Override
    public String toString() {
        String result = "Graph: " + vertices.length + " " + edges.length + "\n";
        for (Edge edge : edges) {
            result += edge.toString();
        }
        return result;
    }
}
