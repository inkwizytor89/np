package test;

import static java.lang.Math.floor;
import static java.lang.Math.sqrt;
import java.util.LinkedList;
import structure.bitvector.BitVector;
import structure.graph.Edge;
import structure.graph.Graph;
import structure.graph.Vertex;

public class GraphGenerator {

    private BitVector edgesBitVector;
    private Integer vertexCount;

    public GraphGenerator() {
        buildGenerator(1);
    }

    public GraphGenerator(Integer size) {
        buildGenerator(size);
    }

    
//    public GraphGenerator(BitVector bitVector) {
//        this.edgesBitVector = bitVector;
//        Double temp = floor((1 + sqrt(1 + 4 * edgesBitVector.size())) / 2);
//        vertexCount = temp.intValue();
//    }
    
    private void buildGenerator(Integer size) {
        this.edgesBitVector = new BitVector(size * (size-1)/2);
        vertexCount = size;
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
        for (int i=0; i<vertexCount-1; i++) {
            for(int j=i+1;j<vertexCount;j++) {
                if (edgesBitVector.getPositionValue(bitVectorCount++))
                edgesList.add(new Edge(vertices[i], vertices[j]));
            }
        }
//        for (int i = 0; i < edgesBitVector.size(); i++) {
//            if (edgesBitVector.getPositionValue(i)) {
//                edgesList.add(createBinaryEdge(i, vertices));
//            }
//        }
        Edge[] edges = edgesList.toArray(new Edge[edgesList.size()]);
        return new Graph(vertices, edges);
    }

    public Boolean nextEdgeSystem() {
        return edgesBitVector.next();

    }

    public Boolean addVertex() {
        //this.edgesBitVector = new BitVector(edgesBitVector.size() + 1);
        //System.out.println(vertexCount+1);
        buildGenerator(vertexCount+1);
        return true;
    }

    @Override
    public String toString() {
        return "("+vertexCount+") "+edgesBitVector.toString();
    }
}
