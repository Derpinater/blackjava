import java.util.ArrayList;

public class Exec {
  public static void main(String[] args) throws Exception {
    Deck myDeck = new Deck(true);
    int[] deck = myDeck.genDeck();

    for(int i = 0; i < deck.length; i++)  {
      System.out.print(deck[i] + " ");
    }
    System.out.println();

    ArrayList<String> display = myDeck.toRealCards(deck);
    System.out.print(display);

    ArrayList<Integer> playerHand = new ArrayList<Integer>();

    myDeck.toBlackjackValues(deck);
    System.out.println("\nDrawn Card " + myDeck.drawCard(deck, playerHand) + " of " + myDeck.getSuit()); 
    System.out.println("Drawn Card " + myDeck.drawCard(deck, playerHand) + " of " + myDeck.getSuit()); 
    System.out.println("Drawn Card " + myDeck.drawCard(deck, playerHand) + " of " + myDeck.getSuit());

    System.out.println(playerHand);
  }
}


