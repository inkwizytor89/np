package structure.bitvector;

import static java.lang.Math.pow;

/**
 * Wektor binarny
 *
 * @author inkwizytor89
 */
public class BitVector {

    /**
     * Zawiera interpretacje wektora binarnego
     */
    private Boolean[] vector;

    /**
     * Inizjuje wszystkie pola
     *
     * @param size długość wektora
     */
    private void buildVector(Integer size) {
        vector = new Boolean[size];
        for (int i = 0; i < size; i++) {
            vector[i] = false;
        }
        Double tempValue = pow(2, size) - 1;
    }

    /**
     * Tworzy wektor z 1 binarną pozycją
     */
    public BitVector() {
        buildVector(1);
    }

    /**
     * Tworzy wektor binarny
     *
     * @param size liczba bitów wektrora
     */
    public BitVector(Integer size) {
        buildVector(size);
    }

    /**
     * Czas liniowy
     *
     * @return liczbe jedynek w wektorze
     */
    public Integer getBitSum() {
        Integer sum = 0;
        for (Boolean b : vector) {
            if (b) {
                sum++;
            }
        }
        return sum;
    }

    /**
     * Rozmiar wektora
     *
     * @return liczba bitów wektora
     */
    public Integer size() {
        return this.vector.length;
    }

    /**
     * Zwraca fragment wektora
     *
     * @param position pozycja wektora
     * @return wartość na zadanej pozycji
     */
    public Boolean getPositionValue(Integer position) {
        return vector[position];
    }

    /**
     * Sprawdza czy wektor skłąda się z samych 1
     *
     * @return true jeśli zawiera same wartości "true"
     */
    public Boolean isLast() {
        for (Boolean bool : vector) {
            if (!bool) {
                return false;
            }
        }
        return true;
    }

    /**
     * Przejście na kolejny podzbiór
     *
     * @return true jeśli może przejść na kolejny podzbiór
     */
    public Boolean next() {
        Integer position = vector.length - 1;
        try {
            while (vector[position]) {
                vector[position] = false;
                position--;
            }
        } catch (ArrayIndexOutOfBoundsException ex) {
            return false;
        }
        vector[position] = true;
        return true;
    }

    /**
     * Uzupełnia wektor "1" na zadanej liczbie pozycji od lewej strony (bitu
     * najbardziej znaczącego)
     *
     * @param area zadana liczna pozycji
     */
    public void setLeftFull(Integer area) {
        for (int i = 0; i < area; i++) {
            vector[i] = true;
        }
    }

    /**
     * Uzupełnia wektor "1" na zadanej liczbie pozycji od prawej strony (bitu
     * najmniej znaczącego)
     *
     * @param area zadana liczna pozycji
     */
    public void setRightFull(Integer area) {
        for (int i = 0; i < area; i++) {
            vector[vector.length - i - 1] = true;
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
        return result + ":";
    }
}
