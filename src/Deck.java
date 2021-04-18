/**
 * Deck.java
 * ----------------------------------------------------------------
 * This is the file that handles all actions that you do with a deck.
 * (i.e. generating the deck, shuffling the deck, ect.)
 */

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Deck {
  // feilds
  private Random rand;

  private ArrayList<Integer> _deck = new ArrayList<Integer>();
  private ArrayList<String> _displayDeck;

  private boolean _doShuffle;
  private int selection = 0;
  
  // constructors
  /**
   * Main constructor for Deck.java
   * @param doShuffle specifies whether you would like to shuffle in genDeck()
   */
  public Deck(boolean doShuffle)  {
    this._doShuffle = doShuffle;
  }

  // methods
  /**
   * Makes a deck of 52 with 4 of each card. 
   * @return
   */
  public int[] genDeck() throws Exception {
    for(int i = 0; i < 4; i++) {
      for(int j = 1; j <= 13; j++)  {
        _deck.add(j);
      }
    }

    int[] deck = new int[_deck.size()];
    for(int i = 0; i < _deck.size(); i++) {
      deck[i] = _deck.get(i);
    }

    // shuffle
    if(_doShuffle == true)  {

      Random rand = ThreadLocalRandom.current();
      for(int i = deck.length - 1; i > 0; i--) {
        int index = rand.nextInt(i + 1);
  
        // simple swap
        int a = deck[index];
        deck[index] = deck[i];
        deck[i] = a;
      }
    }
  
    return deck;
  }
  /**
   * Simple Fisher-Yates algorithm to randomize the pre-set @param array
   * @param array
   */
  public void shuffleArray(int[] array) {
    Random rand = ThreadLocalRandom.current();
    for(int i = array.length - 1; i > 0; i--) {
      int index = rand.nextInt(i + 1);

      // simple swap
      int a = array[index];
      array[index] = array[i];
      array[i] = a;
    }
  }

  /**
   * Makes another array of strings based on the @param array and returns another with all the ranks
   * @param array is the array to analyze.
   * @return the other array that is returned full of card ranks.
   */
  public ArrayList<String> convertIntoString(int[] array)  {
    _displayDeck = new ArrayList<String>();
    for(int i = 0; i < array.length; i++) {
      _displayDeck.add(String.valueOf(array[i]));
    }

    for(int i = 0; i < array.length; i++) {
      switch(array[i])  {
        case 1:
          _displayDeck.set(i, CardNames.ACE.toString());
          break;
        case 2:
          _displayDeck.set(i, CardNames.TWO.toString());
          break;
        case 3:
          _displayDeck.set(i, CardNames.THREE.toString());
          break;
        case 4:
          _displayDeck.set(i, CardNames.FOUR.toString());
          break;
        case 5:
          _displayDeck.set(i, CardNames.FIVE.toString());
          break;
        case 6:
          _displayDeck.set(i, CardNames.SIX.toString());
          break;
        case 7:
          _displayDeck.set(i, CardNames.SEVEN.toString());
          break;
        case 8:
          _displayDeck.set(i, CardNames.EIGHT.toString());
          break;
        case 9:
          _displayDeck.set(i, CardNames.NINE.toString());
          break;
        case 10:
          _displayDeck.set(i, CardNames.TEN.toString());
          break;
        case 11:
          _displayDeck.set(i, CardNames.JACK.toString());
          break;
        case 12:
          _displayDeck.set(i, CardNames.QUEEN.toString());
          break;
        case 13:
          _displayDeck.set(i, CardNames.KING.toString());
          break;
      }
    }
    // System.out.println(array.length);
    return this._displayDeck;
  }

  /**
   * This needs to happen BEFORE convertToString so it doesn't mess with the String assignments.
   * CAUTION: OVERWRITES THE ARRAY SPECIFIED
   * @param array is the array in which you want to make all values above 10 go to 10
   */
  public int[] convertCorrectValues(int[] array) {
    for(int i = 0; i < array.length; i++) {
      if(array[i] >= 11)  {
        array[i] = 10;
      }
    }
    return array;
  }
  /**
   * 
   * @param array in which the next element is taken.
   * @return the next element of the array.
   */
  public int drawCard(int[] array) {
    this.selection++;
    return (array[this.selection - 1]);
  }

  /**
   * @return the immediately previous selected card
   */
  public String getDrawnCard() {
    return this._displayDeck.get(selection);
  }
}
