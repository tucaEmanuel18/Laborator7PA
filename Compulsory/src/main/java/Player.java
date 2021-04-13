import java.util.ArrayList;
import java.util.List;

public class Player {
    private int name;
    private List<Token> tokens;


    public int getName() {
        return name;
    }

    public List<Token> getTokens() {
        return tokens;
    }

    public Player(int name){
        this.name = name;
        tokens = new ArrayList<>();
    }



}
