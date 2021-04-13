import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class Board {
    private List<Token> tokens;

    public Board(int n){
        tokens = new ArrayList<>();
        for(int i = 0; i <= (n + 1)/ 2; i++){
            for(int j = i + 1; j < n; j++){
                tokens.add(new Token(new Pair(i, j, n), getRandomNumber()));
                tokens.add(new Token(new Pair(j, i, n), getRandomNumber()));
            }
        }
        tokens.sort(Token::compareTo);
    }


    public void printTokens(){
        for(Token t:tokens){
            System.out.println(t);
        }
    }

    private int getRandomNumber(){
        return (int)Math.round(Math.random() * 10);
    }

    public synchronized Token getToken(int index){
        if(index < 0 || index > tokens.size()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Token t =  tokens.get(index);
        tokens.remove(t);
        return t;
    }

    public synchronized Token getToken(){
        System.out.println("Board: Mai am: " + tokens.size() + "token-uri");
        int index = getRandomIndex(tokens.size());
        if(index == -1){
            return null;
        }
        return getToken(index);
    }


    private int getRandomIndex(int size){
        if(size < 1) {
            return -1;
        }
        int randomNumber = (int)Math.round(Math.random() * 100);
        int result = randomNumber % size;

        return result;
    }

    public boolean isEmpty(){
        if(tokens.size() < 1){
            return true;
        }
        return false;
    }
}
