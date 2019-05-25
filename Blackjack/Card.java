// Card Class
public class Card {
    // instance variables
    // static variables
    private final static int[] ACE = {1,11};
    private final static int JACK = 10;
    private final static int QUEEN = 10;
    private final static int KING = 10;
    // non-static variables
    // suit
    private int suit;
    // 0 = hearts, 1 = spades, 2 = clubs, 3 = diamonds
    // value
    private int value;
    // just value of card for blackjack
    public Card(int value) {
        this.value = value;
    }
}
