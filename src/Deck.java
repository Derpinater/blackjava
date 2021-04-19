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

  // deck arrays.
  private ArrayList<Integer> _deck = new ArrayList<Integer>();
  private ArrayList<String> _displayDeck;
  private ArrayList<Integer> _suitDeck = new ArrayList<Integer>();
  private ArrayList<String> _displaySuitDeck;

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
  public ArrayList<Integer> genDeck() throws Exception {
    // gen the _deck
    for(int i = 0; i < 4; i++) {
      for(int j = 1; j <= 13; j++)  {
        _deck.add(j);
      }
    }

    // converting the _deck into a int[]
    // int[] deck = new int[_deck.size()];
    // for(int i = 0; i < _deck.size(); i++) {
    //   deck[i] = _deck.get(i);
    // }

    // suit deck assignments
    for(int i = 0; i < 13; i++) {
      for(int j = 0; j < 4; j++)  {
        _suitDeck.add(j);
      }
    }

    // shuffling only if specified in the constructor
    if(_doShuffle == true)  {

      Random rand = ThreadLocalRandom.current();
      for(int i = this._deck.size() - 1; i > 0; i--) {
        int index = rand.nextInt(i + 1);
  
        // simple swap
        int a = this._deck.get(index);
        this._deck.set(index, this._deck.get(i));
        _deck.set(i, a);

        // int a = deck[index];
        // deck[index] = deck[i];
        // deck[i] = a;
      }
    }
  
    return _deck;
  }

  /**
   * Simple Fisher-Yates algorithm to randomize the pre-set @param array
   * @param array
   */
  public void shuffleArray(ArrayList<Integer> array) {
    Random rand = ThreadLocalRandom.current();
      for(int i = array.size() - 1; i > 0; i--) {
        int index = rand.nextInt(i + 1);
  
        // simple swap
        int a = array.get(index);
        array.set(index, array.get(i));
        array.set(i, a);

        // int a = deck[index];
        // deck[index] = deck[i];
        // deck[i] = a;
      }
  }

  /**
   * Makes another array of strings based on the array specified and returns another with all the ranks.
   * There is also generation of a suit list that you can get in super.getSuit()
   * @param array is the array to analyze.
   * @return the other array that is returned in full of card ranks (strings from ENUM).
   */
  public ArrayList<String> toRealCards(ArrayList<Integer> array)  {
    _displayDeck = new ArrayList<String>();
    for(int i = 0; i < array.size(); i++) {
      _displayDeck.add(String.valueOf(array.get(i)));
    }

    // holy motherload of converting numbers into a string from an enum
    for(int i = 0; i < array.size(); i++) {
      switch(array.get(i))  {
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

    // suits
    _displaySuitDeck = new ArrayList<String>();
    for(int i = 0; i < array.size(); i++) {
      _displaySuitDeck.add(String.valueOf(_suitDeck.get(i)));
    }
    
    for(int i = 0; i < _suitDeck.size(); i++)  {
      switch(_suitDeck.get(i))  {
        case 0:
          _displaySuitDeck.set(i, SuitNames.SPADES.toString() + " \u2660");
          break;
          case 1:
          _displaySuitDeck.set(i, SuitNames.CLUBS.toString() + " \u2663");
          break;
          case 2:
          _displaySuitDeck.set(i, SuitNames.HEARTS.toString() + " \u2665");
          break;
          case 3:
          _displaySuitDeck.set(i, SuitNames.DAIMONDS.toString() + " \u2666");
          break;
        default:
          _displaySuitDeck.set(i, "undefined");
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
  public ArrayList<Integer> toBlackjackValues(ArrayList<Integer> array) {
    for(int i = 0; i < array.size(); i++) {
      if(array.get(i) >= 11)  {
        array.set(i, 10);
        // array[i] = 10;
      }
    }
    return array;
  }
  /**
   * 
   * @param array in which the next element is taken.
   * @return the next element of the array.
   */
  public String drawCard(ArrayList<Integer> array, ArrayList<Integer> toArray) {
    this.selection++;
    toArray.add(array.get(this.selection - 1));
    return (this._displayDeck.get(this.selection - 1));
  }

  /**
   * Gets the immediately drawn card's suit. Ususally used for GUI stuff.
   */
  public String getSuit() {
    return (this._displaySuitDeck.get(selection - 1));
  }

  /**
   * @return the immediately previous selected card
   */
  public String getDrawnCard() {
    return this._displayDeck.get(selection);
  }
}
