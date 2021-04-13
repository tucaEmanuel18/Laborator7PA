public class Pair implements Comparable<Pair>{
    private int first;
    private int second;

    public Pair(int first, int second, int n){
        if(first < 0 || first >= n){
            throw new NullPointerException("first must be in [0, n)");
        }

        if(second < 0 || second >= n){
            throw new NullPointerException("second must be in [0, n)");
        }
        this.first = first;
        this.second = second;
    }

    public int getFirst() {
        return first;
    }

    public int getSecond() {
        return second;
    }

    @Override
    public int compareTo(Pair o) {
        if(o == null){
            throw new NullPointerException();
        }

        if(this.first < ((Pair) o).getFirst()) {
            return -1;
        }

        if(this.first == ((Pair) o).getFirst()){
            if(this.second < ((Pair) o).getSecond()){
                return -1;
            }

            if(this.second == ((Pair) o).getSecond()){
                return 0;
            }

            return 1;
        }

        return 1;
    }


    @Override
    public String toString() {
        return "first= " + first + " | second = " + second;
    }
}
