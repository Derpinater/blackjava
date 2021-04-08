/**
 * This is used to perform the opperations of handling a deck. i.e ->  prefacing the card values-- as mentioned in `CardName.java`.
 */

import java.util.Random;
import java.util.ArrayList;

public class Card {
  // feilds
  private Random rand;
  // constructors

  // methods
  public void prefaceCardValues() {
    System.out.printf("--------Prefacing the Card Values!--------%n%n");

    ArrayList<String> cardNames = new ArrayList<String>();
    for (CardName el : CardName.values()) {
      cardNames.add(el.toString());
    }

    for (int i = 1; i < 15; i++) {
      System.out.printf("%-2d ... %-5s ", i, cardNames.get(i - 1));
      if (i % 2 == 0) {
        System.out.println();
      }
    }
  }

  public int drawRandomCard() {
    rand = new Random();
    return rand.nextInt(14) + 1;
  }
  
}
