import java.util.ArrayList;

public class Game {
  // feilds
  private Deck deckActions;

  public ArrayList<Integer> _playerHand = new ArrayList<Integer>();
  public ArrayList<Integer> _dealerHand = new ArrayList<Integer>();

  private int threshhold = 21;
  
  // constructors
  public Game(ArrayList<String> tDisplayPlayerDeck, ArrayList<String> tDisplayDealerDeck) {
    dealHands();
    
  }
  public Game() {
    dealHands();
    
  }

  // methods
  /**
   * Deals 2 cards to the player and one to the dealer (for the display sake and rules)
   * prints them out after that.
   */
  public void dealHands()  {
    deckActions = new Deck();
    this._playerHand.add(this.deckActions.drawCard(this.deckActions._bjDeck));
    this._playerHand.add(this.deckActions.drawCard(this.deckActions._bjDeck));
    
    // System.out.println("Player Hand: " + this._playerHand);

    this._dealerHand.add(this.deckActions.drawCard(this.deckActions._bjDeck));

    // System.out.println("Dealer Hand: " + this._dealerHand);
  }

  /**
   * @param targetList is the list that will be added up.
   * @return 0 = Uh oh, bad. dealer wins! 
   * 1 = You can still hit or stand. 
   * 2 = blackjack! player wins!
   */
  public int checkThreshhold(ArrayList<Integer> targetList)  {
    int result = 0;
    for(int i = 0; i < targetList.size(); i++)  {
      result += targetList.get(i);
    }
    
    int returns;
    if(result > threshhold) {
      returns = 0;
    } else if(result == threshhold) {
      returns = 2;
    } else  {
      returns = 1;
    }

    // System.out.print(returns);
    return returns;
  }

  /**
   * Sums all elements from the list.
   * @param targetList is the list that is added up
   * @return is the sum of all elements in the list.
   */
  public int sums(ArrayList<Integer> targetList) {
    int returns = 0;
    for(int i = 0; i < targetList.size(); i++)  {
      returns += targetList.get(i);
    }

    return returns;
  }

  /**
   * Compares the two lists that are presented
   * @param tList1 is the 1st list
   * @param tList2 is the 2nd list
   * @return returns 0 for if the second hand has won, 1 for a draw, and 2 for the second hand's sum.
   */
  public int compare(ArrayList<Integer> tList1, ArrayList<Integer> tList2)  {
    int t1 = sums(tList1);
    int t2 = sums(tList2);
    int returns;
    if(t1 < t2) {
      returns = 0;
    } else if(t1 == t2) {
      returns = 1;
    } else  {
      returns = 2;
    }

    return returns;
  }

  // moves
  /**
   * 
   * @param targetList the new card will go to this list
   * @return 0 = Uh oh, bad. dealer wins! 
   * 1 = You can still hit or stand. 
   * 2 = blackjack! player wins!
   */
  public int hit(ArrayList<Integer> targetList)  {
    targetList.add(this.deckActions.drawCard(this.deckActions._bjDeck));
    return checkThreshhold(targetList);
  }

  /**
   * no more actions. This is mostly for readability in code.
   * @param targetList is the list that you will add up @see sum(ArrayList<iInteger> targetList)
   * @return is the sum of the hand
   */
  public int stand(ArrayList<Integer> targetList) {    
    return sums(targetList);
  }


  // dealer decisions
  public int dealer() {
    // check what you have already
    int handSum = sums(this._dealerHand);
    // what if you have some really low cards
    do {
      hit(this._dealerHand);
      handSum = sums(this._dealerHand);
    } while(handSum < 18); 

    // draw the card even if it goes over
    this._dealerHand.add(this.deckActions.drawCard(this.deckActions._bjDeck));
    handSum = sums(this._dealerHand);
    
    
    return checkThreshhold(this._dealerHand);
  }

}
