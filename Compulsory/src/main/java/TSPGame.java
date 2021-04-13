import java.nio.file.InvalidPathException;
import java.util.ArrayList;
import java.util.List;

public class TSPGame {
    private Integer actualPlayer;
    private int n;
    private List<Player> players;
    private List<PlayerWork> playerWork;
    private Board board;

    public TSPGame(int n, int numberOfPlayers){
        if(n < 3){
            throw new IllegalArgumentException("n must be an integer grater than 2");
        }

        if(numberOfPlayers < 2){
            throw new IllegalArgumentException("number of players mut be greater than 1");
        }
        this.n = n;
        board = new Board(n);
        actualPlayer = 0;
        players = new ArrayList<Player>();
        playerWork = new ArrayList<>();

        for (int i = 0; i < numberOfPlayers;++i){
            players.add(new Player(i));
        }

        printGameState();
    }

    public synchronized void startGame(){
        for(int i = 0; i < players.size(); i++){
            playerWork.add(new PlayerWork(players.get(i), board));
            new Thread(playerWork.get(i)).start();
        }
    }


    public void printGameState(){
        System.out.println("GAME STATE \n Board left tokens: ");
        board.printTokens();
        System.out.println("Players:");
        for(Player p : players){
            System.out.println("Player: " + p.getName());
        }

        System.out.println("Actual player turn: " + actualPlayer);

    }
}
