package pokersimulator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by Subrina on 1/21/14.
 */
public class Deck {
    private ArrayList<Card> cards;


    public Deck() {
        cards = new ArrayList<Card>();

        int index1, index2;
        Random generator = new Random();
        Card temp;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 13; j++) {
                cards.add(new Card(i, j));
            }
        }

        // Randomly shuffle cards
        for(int i = 0; i < 100; i++){
            index1 = generator.nextInt(cards.size() - 1);
            index2 = generator.nextInt(cards.size() - 1);

            temp = cards.get(index2);
            cards.set(index2, cards.get(index1));
            cards.set(index1, temp);
        }
    }

    public Card drawFromDeck() {
        return cards.remove(0);
    }

    public int getTotalCards() {
        return cards.size();
    }
}
