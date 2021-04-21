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
    input.nextLine();
    switch(event) {
      case 1:
        game = new Game();
        System.out.println(game._dealerHand);
        System.out.println(game._playerHand + " = " + game.calc(game._playerHand));
        if (game.calc(game._playerHand) == 21) {
          System.out.println("You got blackjack!");
        } else {
          do {
            System.out.print("1 = Hit, 0 = Stand: ");
            event = input.nextInt();
            input.nextLine();
            switch (event) {
              case 0:
                System.out.println(game._dealerHand);
                System.out.println(game._playerHand + " = " + game.calc(game._playerHand));
                //Call for dealer code here
                System.out.println("dealer's turn");
                break;
              case 1:
                int didWin = game.hit(game._playerHand);
                System.out.println(game._playerHand + " = " + game.calc(game._playerHand));
                if(didWin == 0) {
                  System.out.println("YOU LOOSE!");
                  event = 0;
                } else if (didWin == 2) {
                  System.out.println("You got 21!");
                  event = 0;
                }
                break;
              default:
                System.out.println("Invalid input");
            }
          } while (event != 0);
        }


        

        

        break;
      case 0:
        System.out.println("Bye!");
    }


    input.close();
  }
}
