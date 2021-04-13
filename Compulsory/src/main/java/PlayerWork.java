import static java.lang.Thread.sleep;

public class PlayerWork implements Runnable{
   private Player player;
   private Board board;
   private boolean quit;


    public PlayerWork(Player player, Board board) {
        this.player = player;
        this.board = board;
        this.quit = false;


        System.out.println("S-a creat playerWork: Player " + player.getName());
        System.out.println("Vad boardul: ");
        board.printTokens();

    }
    public void quit(){
        quit = true;
    }

    @Override
    public synchronized void run() {
        System.out.println("[" + player.getName() + "]:" + "Am pornit!" );
        while(!board.isEmpty()){
            Token t = board.getToken();
            if(t != null){
                player.getTokens().add(t);
                System.out.println("[" + player.getName() + "]:" + "Am luat token-ul: " + t);
                try {
                    System.out.println("[" + player.getName() + "]:" + "Astept..!" );
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }

        for(Token t : player.getTokens()){
            System.out.println("[" + player.getName() + "]:" + "Am tokenul:" + t);
        }
    }
}
