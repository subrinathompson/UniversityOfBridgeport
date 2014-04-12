/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pokersimulator;

/**
 *
 * @author Subrina
 */
public class PokerSimulator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Deck deck = new Deck();
        Hand myHand = new Hand(deck);
        myHand.displayAll();

        System.out.println("\n\nChecking for one pair\n" + myHand.checkForOnePair());
        System.out.println("\n\nChecking for two pairs\n" + myHand.checkForTwoPairs());

//        System.out.println("\n\nChecking for straight \n" + myHand.checkForStraight());

//        System.out.println("\n\nChecking for 3 of kind \n" + myHand.checkForThreeKind());

//        System.out.println("\n\nChecking for flush \n" + myHand.checkForFlush());
    }
    
}
