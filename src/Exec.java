import java.util.ArrayList;

public class Exec {
  public static void main(String[] args) throws Exception {
    Game game = new Game();

    System.out.println();
    game.dealCards(game.playerHand);
    game.hit(game.playerHand);
  }
}


