package test;

public class NaiveGraphGenerator extends GraphGenerator {

    @Override
    public Boolean nextEdgeSystem() {
        return edgesBitVector.next();

    }

    @Override
    public Boolean addVertex() {
        buildGenerator(vertexCount+1);
        return true;
    }
}
