# blackjava
## simple black-jack simulator in the CLI
### refactoring of https://github.com/amimista/simple-java-blackjack
---
## File Breakdown
### `Exec.java`
- This is used to perform the actions of the game with various do while-loop, all the opperations set up by the other classes.

### `Game.java`
- This handles the game operations, like hit, stand, split, and calculateing if you have gone over the 21 threshold.

### `Deck.java`
- This is used to perform the opperations of handling a deck. i.e -> Shuffle, prefacing the card values-- as mentioned in `CardName.java`.

### `CardRanks.java`
- This is used to preface the card values that appear in the player's or the dealer's hand.

### `CardSuits.java`
- This is used to make cards with a certain suit.
<!-- SuitNames preview -->
```java
public enum SuitNames {
  DAIMONDS, CLUBS, SPADES, HEARTS
}
```

## Things to do:
- ~~SuitNames~~
- ~~implament player and dealers hand~~
- ~~user input (hits, stands)~~
- game rules (half way there)
- GUI??
- ~~Optimization (only if we want to hehe)~~

---
## Group Members:
- Marcus Walker
- Jaxon Albanese
- David Handcock
