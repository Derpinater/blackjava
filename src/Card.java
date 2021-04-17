/**
 * This is used to perform the opperations of handling a deck. i.e ->  prefacing the card values-- as mentioned in `CardName.java`.
 */

import java.util.Random;
import java.util.ArrayList;

public class Card {
  // feilds
  private Random rand;

  // plan B?
  /*
   private String[] suits = {"Hearts", "Diamonds", "Spades", "Clubs"};
   private String[] cards = {"2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King", "Ace"};
  */
  ArrayList<String> deckDisplay = new ArrayList<String>();
  ArrayList<String> deckValues = new ArrayList<String>();
  ArrayList<String> deckSuits = new ArrayList<String>();
  
  private int value;
  // constructors

  // methods
  public void prefaceCardValues() {
    System.out.printf("--------Prefacing the Card Values!--------%n");

    ArrayList<String> cardNames = new ArrayList<String>();
    for (CardNames el : CardNames.values()) {
      cardNames.add(el.toString());
    }

    for (int i = 1; i <= 13; i++) {
      value = i;
      if(value > 10 && value < 14)  {
        value = 10;
      }
      if(value != 1)  {
        System.out.printf(" %-2d ... %-5s |", value, cardNames.get(i - 1));
      } else {
        System.out.printf("%-2d or %-2d ... %-5s (Yes, we are using aces)\n", value, 11, cardNames.get(i - 1));
      }
      if (value % 3 == 0) {
        System.out.println();
      }
      System.out.println("------------------------------------------------------");
    }
  }

  public void generateDeck(boolean shuffle)  {
    if(shuffle) { // if it's true
      for(int i = 0; i < 52; i++) {
        int index = rand.nextInt(14);
        deck
        
      }
    } else  { // if it's false
      for(int i = 0; i < deck.length; i++) {

      }
    }
  }

  // public ArrayList<String> drawRandomCard() {
  //   rand = new Random();
  //   ArrayList<String> returns = new ArrayList<String>();
  //   // adding the card to the list of returns.
  //   String selection = cards[rand.nextInt() * cards.length];
  //   returns.add(selection);
  
  //   // adding the suit to the list of returns.
  //   selection = suits[rand.nextInt() * suits.length];
  //   returns.add(selection);

  //   return null;
  // }
}
