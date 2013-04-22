package structure.grapf.exception;

/**
 * Wyjątek w przypadku niespójnego grafu.
 * @author kamil
 */
public class SeparableGraphException extends RuntimeException {

    public SeparableGraphException() {
        super("Graf jest niespójny");
    }
    
}
