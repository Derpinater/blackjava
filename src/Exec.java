import java.util.ArrayList;
import java.util.Scanner;

/**
 * main execution of the game -> main endpoint.
 */

// imports

public class Exec {
  public static void main(String[] strings) {
    // Card cardObj = new Card();
    // Game gameObj = new Game();
    Scanner input = new Scanner(System.in);

    // cardObj.prefaceCardValues();
    CardNames names;
    for(CardNames card: CardNames.values()) {
      System.out.println(card.toString());
    }
    
    
    input.close();
  }
}