// Deck Class
// import arraylist
import java.util.ArrayList;
// Creates deck for blackjack game
public class Deck {
    // instance variables
    // static variables
    // number of cards in a deck
    private static final int NUM_CARDS = 52;
    // number of suits in a deck
    private static final int NUM_SUITS = 4;
    // number of values in a deck
    private static final int NUM_VALUES = 13;
    // non-static variables
    // list of cards
    private ArrayList<Card> deck;
    // number of decks of cards
    private int decks;
    // constructor
    public Deck(int decks) {
        // initialize
        this.decks = decks;
        deck = new ArrayList<Card>();
        // create cards in deck
        createDeck();
    }
    // method to create decks of cards
    private void createDeck() {
        for(int i = 0; i < decks; i++) {
            create();
        }
    }
    // method to create a deck of cards
    private void create() {
        for (int i = 0; i < NUM_SUITS) {
            // start at 1 for ace, 2-10 numbers, 11-13 face
            for (int j = 1; j < NUM_VALUES + 1; j++) {
                deck.add(new Card(i, j));
            }
        }
    }
}
