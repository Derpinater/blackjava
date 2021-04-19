import java.util.ArrayList;

/**
 * THINGS TODO:
 * suits
 * implament player and dealers hand
 * user input (hits, stands)
 * game rules
 * GUI??
 */

public class Exec {
  public static void main(String[] args) throws Exception {
    Deck myDeck = new Deck(true);
    int[] deck = myDeck.genDeck();

    for(int i = 0; i < deck.length; i++)  {
      System.out.print(deck[i] + " ");
    }
    System.out.println();

    ArrayList<String> display = myDeck.toCardRanks(deck);
    System.out.print(display);

    myDeck.toBlackjackValues(deck);
    System.out.println("Drawn Card " + myDeck.drawCard(deck)); 
    System.out.println("Drawn Card " + myDeck.drawCard(deck)); 
    System.out.println("Drawn Card " + myDeck.drawCard(deck)); 
  }
}


