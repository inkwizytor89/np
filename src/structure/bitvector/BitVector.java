package structure.bitvector;

import static java.lang.Math.floor;
import static java.lang.Math.log;
import static java.lang.Math.pow;

public class BitVector {

    private Boolean[] vector;
    private Long value;
    private Long maxValue;

    public BitVector() {
        buildVector(1);
    }

    public BitVector(Integer size) {
        buildVector(size);
    }

    private BitVector(Long value) {
        Double tempValue = floor(log(value) / log(2));
        buildVector(tempValue.intValue());
    }
    
    public Integer getBitSum() {
        Integer sum = 0;
        for (Boolean b : vector) {
            if(b) {
                sum++;
            }
        }
        return sum;
    }

    private void buildVector(Integer size) {
        vector = new Boolean[size];
        for (int i = 0; i < size; i++) {
            vector[i] = false;
        }
        value = new Long(0);
        Double tempValue = pow(2, size) - 1;
        maxValue = new Long(tempValue.longValue());
    }

    public Long getValue() {
        return value;
    }

    public Integer size() {
        return this.vector.length;
    }

    public Boolean getPositionValue(Integer position) {
//        System.out.println("position "+position);
//        System.out.println("size "+ vector[position]);
        return vector[position];
    }

    public Boolean isLast() {
        //return value >= maxValue;
        for(Boolean b : vector) {
            if (!b) {
                return false;
            }
        }
        return true;
    }

    public Boolean next() {
        //System.out.println("body "+toString()+" "+isLast());
        if (isLast()) {
            return false;
        } //else {System.out.println("wektoor "+value+" max "+maxValue);}
        Integer position = vector.length - 1;

        while (vector[position]) {
            vector[position] = false;
            position--;
                    //System.out.println("position "+position+" on "+toString());
        }
        vector[position] = true;
        value++;
        return true;
    }
    
    public void setLeftFull(Integer area) {
        value = new Long(1);
        for (int i=0;i<area;i++) {
            vector[i] = true;
            value*=2;
        }
        
    }
    
    public void setRightFull(Integer area) {
        for (int i=0;i<area;i++) {
            vector[vector.length-i-1] = true;
        }
        
    }

    @Override
    public String toString() {
        String result = "";
        for (Boolean bool : vector) {
            if (bool) {
                result += "1";
            } else {
                result += "0";
            }
        }
        return result+":"+value;
    }

}
