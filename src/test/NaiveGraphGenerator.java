package test;

public class NaiveGraphGenerator extends GraphGenerator {


    
//    public NaiveGraphGenerator(BitVector bitVector) {
//        this.edgesBitVector = bitVector;
//        Double temp = floor((1 + sqrt(1 + 4 * edgesBitVector.size())) / 2);
//        vertexCount = temp.intValue();
//    }

    @Override
    public Boolean nextEdgeSystem() {
        return edgesBitVector.next();

    }

    @Override
    public Boolean addVertex() {
        //this.edgesBitVector = new BitVector(edgesBitVector.size() + 1);
        //System.out.println(vertexCount+1);
        buildGenerator(vertexCount+1);
        return true;
    }
}
