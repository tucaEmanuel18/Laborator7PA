public class Token implements Comparable<Token>{
    private Pair nodes;
    private int value;

    public Token(Pair nodes, int value) {
        if(value < 0 ){
            value = 0;
        }

        this.nodes = nodes;
        this.value = value;
    }

    public Pair getNodes() {
        return nodes;
    }

    public int getValue() {
        return value;
    }

    @Override
    public int compareTo(Token o) {
        return this.nodes.compareTo(o.getNodes());
    }


    @Override
    public String toString() {
        return "Token{" +
                "nodes=" + nodes +
                ", value=" + value +
                '}';
    }
}
