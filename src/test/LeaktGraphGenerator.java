package test;

public class LeaktGraphGenerator extends GraphGenerator{

    @Override
    public Boolean nextEdgeSystem() {
        return edgesBitVector.next();
    }

    @Override
    public Boolean addVertex() {
        Integer oldArea = edgesBitVector.size();
        buildGenerator(vertexCount+1);
        edgesBitVector.setRightFull(vertexCount-1);
        return true;
    }

    
}
