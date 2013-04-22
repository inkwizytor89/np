package structure.set;

/**
 * Klasa zawierająca wszystkie metody potrzebne do korzystania ze zbiorów rozłącznych.
 * @author kamil
 */
public class Node {

    Node parent;
    Integer rank;

    public Node() {
        parent = this;
        rank = 0;
    }

    public Node find() {
        if(this.equals(parent)) {
            return this;
        }
        return parent.find();
    }

    public void union(Node node) {
        link(find(),node.find());
    }

    private void link(Node x, Node y) {
        if (x.rank > y.rank) {
            y.parent = x;
        } else {
            x.parent = y;
            if (x.rank == y.rank) {
                y.rank++;
            }
        }
    }
}
