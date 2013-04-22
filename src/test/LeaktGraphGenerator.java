package test;

public class LeaktGraphGenerator extends GraphGenerator{

    @Override
    public Boolean nextEdgeSystem() {
        //System.out.println(edgesBitVector.toString());
        return edgesBitVector.next();
    }

    @Override
    public Boolean addVertex() {
        Integer oldArea = edgesBitVector.size();
        buildGenerator(vertexCount+1);
        edgesBitVector.setRightFull(vertexCount-1);
        //System.out.println("poprzedni wektor "+oldArea);
        
        //System.out.println(edgesBitVector.toString());
        return true;
    }

    
}
