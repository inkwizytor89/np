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
        return value >= maxValue;
    }

    public Boolean next() {
        if (isLast()) {
            return false;
        } //else {System.out.println("wektoor "+value+" max "+maxValue);}
        Integer position = vector.length - 1;
//        System.out.println("position "+position);
//        System.out.println("size "+vector.length);
        while (vector[position]) {
            vector[position] = false;
            position--;
        }
        vector[position] = true;
        value++;
        return true;
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
        return result;
    }

}
