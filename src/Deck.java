import java.util.ArrayList;
import java.util.Random;

public class Deck {
  // feilds

  // values to the deck
  private ArrayList<Integer> _deckRanks = new ArrayList<Integer>();
  public ArrayList<Integer> _deckSuits = new ArrayList<Integer>();
  // blackjack values will be stored here
  public ArrayList<Integer> _bjDeck = new ArrayList<Integer>();

  // user friendly lists of the deck
  public ArrayList<String> _stringRanks;
  public ArrayList<String> _stringSuits;

  public String _immediateStringRank;
  public String _immediateStringSuit;

  // constructors
  public Deck() {
    makeDeck();
    // System.out.print(this._deckSuits);
    this._stringRanks = new ArrayList<String>(this._deckRanks.size());
    this._stringSuits = new ArrayList<String>(this._deckSuits.size());
    makeStringLists();
    getBlackjackValues(_deckRanks);
  }

  // methods

  /**
   * Used to generate the values of the deck.
   */
  public void makeDeck() {

    // getting the card values
    for(int i = 0; i < 4; i++)  {
      for(int j = 1; j <= 13; j++)  {
        this._deckRanks.add(j);
      }
    }
    
    // shuffling the card rank values
    Random rand = new Random();
    for(int i = this._deckRanks.size() - 1; i > 0; i--)  {
      int index = rand.nextInt(i + 1);

      int a = this._deckRanks.get(index);
      this._deckRanks.set(index, this._deckRanks.get(i));
      this._deckRanks.set(i, a);
    }
    
    // getting the card suits
    for(int i = 0; i < 13; i++) {
      for(int j = 0; j < 4; j++)  {
        this._deckSuits.add(j);
      }
    }

    // shuffling the card suits the same way
    for(int i = this._deckSuits.size() - 1; i > 0; i--)  {
      int index = rand.nextInt(i + 1);

      int a = this._deckSuits.get(index);
      this._deckSuits.set(index, this._deckSuits.get(i));
      this._deckSuits.set(i, a);
    }

  }

  /**
   * Makes the _stringRanks into a list based on the generated _deckRanks
   * @param _dealerHand
   */
  public void makeStringLists() {

    // making the list as long as the deck
    for(int i = 0; i < _deckRanks.size(); i++)  {
      _stringRanks.add("undefined");
    }

    // takes the index and checks what value it is and sets it to the correct name.
    for(int i = 0; i < this._deckRanks.size(); i++) {
      switch(this._deckRanks.get(i))  {
        case 1:
          _stringRanks.set(i, CardRanks.ACE.toString());
          break;
        case 2:
          _stringRanks.set(i, CardRanks.TWO.toString());
          break;
        case 3:
          _stringRanks.set(i, CardRanks.THREE.toString());
          break;
        case 4:
          _stringRanks.set(i, CardRanks.FOUR.toString());
          break;
        case 5:
          _stringRanks.set(i, CardRanks.FIVE.toString());
          break;
        case 6:
          _stringRanks.set(i, CardRanks.SIX.toString());
          break;
        case 7:
          _stringRanks.set(i, CardRanks.SEVEN.toString());
          break;
        case 8:
          _stringRanks.set(i, CardRanks.EIGHT.toString());
          break;
        case 9:
          _stringRanks.set(i, CardRanks.NINE.toString());
          break;
        case 10:
          _stringRanks.set(i, CardRanks.TEN.toString());
          break;
        case 11:
          _stringRanks.set(i, CardRanks.JACK.toString());
          break;
        case 12:
          _stringRanks.set(i, CardRanks.QUEEN.toString());
          break;
        case 13:
          _stringRanks.set(i, CardRanks.KING.toString());
          break;
      } // end switch

    } // end for

    for(int i = 0; i < _deckSuits.size(); i++)  {
      _stringSuits.add("undefined");
    }

    for(int i = 0; i < this._deckSuits.size(); i++)  {
      switch(this._deckSuits.get(i))  {
        case 0:
          this._stringSuits.set(i, CardSuits.SPADES.toString() + " \u2660");
          break;
        case 1:
          this._stringSuits.set(i, CardSuits.CLUBS.toString() + " \u2663");
          break;
        case 2:
          this._stringSuits.set(i, CardSuits.HEARTS.toString() + " \u2665");
          break;
        case 3:
          this._stringSuits.set(i, CardSuits.DAIMONDS.toString() + " \u2666");
          break;
        default:
          this._stringSuits.set(i, "undefined");
          break;
      } // end switch

    } // end for

  } // end makeStringLists

  public ArrayList<Integer> getBlackjackValues(ArrayList<Integer> deck)  {
    for(int i = 0; i < this._deckRanks.size(); i++) {
      if(this._deckRanks.get(i) >= 11)  {
        this._bjDeck.add(10);
      } else  {
        this._bjDeck.add(this._deckRanks.get(i));
      }
    }

    return this._bjDeck;
  }

  public int drawCard(ArrayList<Integer> deck) {
    // store the first int in the deck and remove it
    int x = deck.get(0);
    deck.remove(0);

    // get and remove first element of ui ranks
    this._immediateStringRank = _stringRanks.get(0);
    _stringRanks.remove(0);

    // get and remove first element of ui suits
    this._immediateStringSuit= _stringSuits.get(0);
    _stringSuits.remove(0);

    // return x -> the value
    return x;
  }

  public String getImmediateStringRank()  {
    return this._immediateStringRank;
  }

  public String getImmediateStringSuit()  {
    return this._immediateStringSuit;
  }

  // @Override
  // public ArrayList<String> toString(ArrayList<Integer> tArrayList) {
  //   ArrayList<String> returnList = new ArrayList<String>();
    
  //   for(int i = 0; i < tArrayList.size(); i++) {
  //     returnList.add("0");
  //     switch(tArrayList.get(i))  {
  //       case 1:
  //         returnList.set(i, CardRanks.ACE.toString());
  //         break;
  //       case 2:
  //         returnList.set(i, CardRanks.TWO.toString());
  //         break;
  //       case 3:
  //         returnList.set(i, CardRanks.THREE.toString());
  //         break;
  //       case 4:
  //         returnList.set(i, CardRanks.FOUR.toString());
  //         break;
  //       case 5:
  //         returnList.set(i, CardRanks.FIVE.toString());
  //         break;
  //       case 6:
  //         returnList.set(i, CardRanks.SIX.toString());
  //         break;
  //       case 7:
  //         returnList.set(i, CardRanks.SEVEN.toString());
  //         break;
  //       case 8:
  //         returnList.set(i, CardRanks.EIGHT.toString());
  //         break;
  //       case 9:
  //         returnList.set(i, CardRanks.NINE.toString());
  //         break;
  //       case 10:
  //         returnList.set(i, CardRanks.TEN.toString());
  //         break;
  //       case 11:
  //         returnList.set(i, CardRanks.JACK.toString());
  //         break;
  //       case 12:
  //         returnList.set(i, CardRanks.QUEEN.toString());
  //         break;
  //       case 13:
  //         returnList.set(i, CardRanks.KING.toString());
  //         break;
  //     } // end switch

  //   } // end for

  //   return returnList;
  // }

}
