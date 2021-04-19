import java.util.ArrayList;

/**
 * Game.java is the file that handles all of the actions that you would take in game.
 * (i.e. calculating if your hand is over 21, hits, stands, splits(?), and winning)
 * 
 */
public class Game {
  // feilds
  private int threshhold = 21;
  private Deck deckActions = new Deck(true); // yes we want to shuffle
  public ArrayList<Integer> _deck;
  
  public ArrayList<Integer> dealerHand;
  public ArrayList<String> _displayDealerHand;

  public ArrayList<Integer> playerHand;
  public ArrayList<String> _displayPlayerHand;


  // constructors
  public Game() throws Exception {

    _deck = deckActions.genDeck();
    ArrayList<String> rankDeck = deckActions.toRealCards(_deck);
    _deck = deckActions.toBlackjackValues(_deck);


    // debuging TAKEOUT when final is due
    System.out.print("Current Deck: " + rankDeck + "\n");
  }


  // methods

  /**
   * 
   * @param targetList is the list that will be added up.
   * @return 0 = Uh oh, bad. dealer wins! 
   * 1 = You can still hit or stand. 
   * 2 = blackjack! player wins!
   * 3 = list not made
   */
  private int aboveThreshhold(ArrayList<Integer> targetList)  {
    int result = 0;
    int returns = 3;
    if(targetList.size() > 0)  {
      for(int i = 0; i < targetList.size(); i++)  {
        result += targetList.get(i);
      }

      if(result > 21) {
       returns = 0; // above 21 -> Game over, dealer wins!
      } else if(result < 21)  {
       returns = 1; // below 21 -> option to hit or stand.
      } else  {
       returns = 2; //blackjack! (in often cases, player wins!)
      }
    }

    
    return returns;
  }

  /**
   * 
   * @param hand
   * @return
   */
  public ArrayList<Integer> dealCards(ArrayList<Integer> hand) {
    deckActions.drawCard(this._deck, hand);
    deckActions.drawCard(this._deck, hand);

    return hand;
  }


  public void hit(ArrayList<Integer> targetDeck)  {
    if(this.aboveThreshhold(targetDeck) == 1)  {
      deckActions.drawCard(this._deck, targetDeck);
    }
  }
}
