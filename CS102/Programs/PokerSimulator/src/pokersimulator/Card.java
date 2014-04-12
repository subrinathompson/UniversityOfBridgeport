package pokersimulator;

/**
 * Created by Subrina on 1/21/14.
 */
public class Card {
    private int rank, suit;

    private static String [] suits = {"Hearts", "Spades", "Diamonds", "Clubs"};
    private static String [] ranks = {"Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen", "King"};

    /**
     *
     * @param suit
     * @param rank
     */
    public Card(int suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }


    /**
     * Returns current suit
     * @return
     */
    public int getSuit() {
        return suit;
    }

    /**
     * Returns current suit
     * @return
     */
    public int getRank() {
        return rank;
    }

    /**
     * Returns a rank
     * @param rank
     * @return
     */
    public static String rankAsString(int rank) {
        return ranks[rank];
    }

    @Override
    public String toString() {
        return ranks[rank] + " of " + suits[suit];
    }
}