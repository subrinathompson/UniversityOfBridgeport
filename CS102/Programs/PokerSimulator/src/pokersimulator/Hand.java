package pokersimulator;

/**
 * Created by Subrina on 1/21/14.
 */
public class Hand {
    private Card [] cards;
    private int [] value;

    public Hand(Deck d){
        value = new int [6];
        cards = new Card[5];

        for(int i = 0; i < 5; i++){
            cards[i] = d.drawFromDeck();
        }
    }

    public void displayAll() {
        for(int i = 0; i < 5; i++){
            System.out.println(cards[i]);
        }
    }

    public void scoreHand() {

    }

    private boolean checkForNoPair() {
        boolean found = false;

        for(int i = 0; i < cards.length; i++){

        }
        return found;
    }

    public int countPair() {
        int count = 0;
        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                if(cards[i].getRank() == cards[j].getRank()){
                    count++;
                }
            }
        }

        return  count;
    }

    /**
     * Checks if it is a flush or not. i.e. all five cards of the same suit
     * @return
     */
    public boolean checkForFlush() {
        int count = 0;

        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                if(cards[i].getSuit() == cards[j].getRank()){
                    count++;
                }
            }
        }

        if(count == 5){
            return true;
        }
        else {
            return false;
        }
    }


    public boolean checkForOnePair() {
        boolean found = false;

        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                if(cards[i].getRank() == cards[j].getRank()){
                    return true;
                }
            }
        }

        return found;
    }


    public boolean checkForTwoPairs() {
        boolean found = false;

        int pairCount = 0;
        String firstPair = "";
        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                if(cards[i].getRank() == cards[j].getRank()){

                    if(firstPair != ""){
                        return true;
                    }
                    firstPair = Card.rankAsString(cards[i].getRank());
//                    continue;
                }
            }
        }

        return found;
    }

    public boolean checkForStraight() {
        boolean found = false;

        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                if(cards[i].getRank() == cards[j].getRank() - 1){
                    return true;
                }
            }
        }

        return found;
    }


    public boolean checkForThreeKind() {
        boolean found = false;

        for(int i = 0; i < cards.length; i++){
            for(int j = i+1; j < cards.length; j++){
                for(int k = i+2; k < cards.length; k++){
                    if(cards[i].getRank() == cards[j].getRank()
                            && cards[i].getRank() == cards[k].getRank()
                            && cards[j].getRank() == cards[k].getRank()){
                        return true;
                    }
                }
            }
        }

        return found;
    }
}
