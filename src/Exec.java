import java.util.ArrayList;
import java.util.Scanner;

public class Exec {

  private static ArrayList<String> _displayPlayerHand = new ArrayList<>();
  private static ArrayList<String> _displayDealerHand = new ArrayList<>();
  private static Game game;

  public static void main(String[] args) {
    Scanner input = new Scanner(System.in);
    // Deck deck = new Deck();
    
    System.out.print("Would you like to play?\n1 = Yes, 0 = No: ");
    int event = input.nextInt();
    switch(event) {
      case 1:
        game = new Game();
        System.out.println(game._dealerHand);
        System.out.println(game._playerHand);
        event = 0;

        

        

        break;
      case 0:
        System.out.println("Bye!");
    }


    input.close();
  }
}
