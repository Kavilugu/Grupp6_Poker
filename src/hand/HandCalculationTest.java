package hand;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandCalculationTest {

    @Test
    void checkPairAndMore() {
        //Player has no pairs
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(0, hc.checkPairAndMore());

        //Player has one pair
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,H");

        hc = new HandCalculation(cards);

        assertEquals(2, hc.checkPairAndMore());

        //Player has one pair flop
        cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");
        cards.add("7,D");
        cards.add("9,H");
        cards.add("10,H");

        hc = new HandCalculation(cards);

        assertEquals(2, hc.checkPairAndMore());

        //Player has one pair turn
        cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");
        cards.add("9,H");
        cards.add("10,H");
        cards.add("11,H");
        cards.add("7,D");

        hc = new HandCalculation(cards);

        assertEquals(2, hc.checkPairAndMore());

        //Player has one pair river
        cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");
        cards.add("9,H");
        cards.add("10,S");
        cards.add("11,H");
        cards.add("2,D");
        cards.add("7,D");

        hc = new HandCalculation(cards);

        assertEquals(2, hc.checkPairAndMore());

        //Player has two pair
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("7,H");
        cards.add("7,S");
        cards.add("8,C");
        cards.add("9,H");

        hc = new HandCalculation(cards);
        System.out.println("TWO PAIR TEST");

        assertEquals(22, hc.checkPairAndMore());

        //Player has two pair with one pair only in community cards
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,H");
        cards.add("8,S");
        cards.add("8,C");
        cards.add("9,H");

        hc = new HandCalculation(cards);
        System.out.println("TWO PAIR TEST");

       // assertEquals(22, hc.checkPairAndMore());

        //Player has two pair with one pair only in community cards
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("7,H");
        cards.add("6,S");
        cards.add("8,C");
        cards.add("6,H");

        hc = new HandCalculation(cards);
        System.out.println("TWO PAIR TEST");

        //assertEquals(22, hc.checkPairAndMore());

        //Player has Four of a kind
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("9,H");

        hc = new HandCalculation(cards);

        assertEquals(4, hc.checkPairAndMore());

        //Player has three of a kind with one card not among community cards
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("9,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("3,D");

        hc = new HandCalculation(cards);

        assertEquals(3, hc.checkPairAndMore());

        //Player has three of a kind with all three cards among community cards
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("9,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("7,D");

        hc = new HandCalculation(cards);

        //assertEquals(3, hc.checkPairAndMore());





    }

    @Test
    void checkPairTest() {



    }

    @Test
    void checkHighCards() {

        ArrayList<String> cards = new ArrayList<String>();
        cards.add("13,D");
        cards.add("14,H");

        HandCalculation hc = new HandCalculation(cards);

        assertTrue(hc.checkHighCards());


    }

    @Test
    void checkSuit() {

        //No suit
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("9,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("3,D");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(2, hc.checkSuit());


        //No suit
         cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("9,D");
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");

        hc = new HandCalculation(cards);

        assertEquals(5, hc.checkSuit());

        cards = new ArrayList<String>();
        cards.add("7,S");
        cards.add("9,H");
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,D");

        hc = new HandCalculation(cards);

        assertEquals(5, hc.checkSuit());


    }

    @Test
    void checkStraight() {

        ArrayList<String> cards = new ArrayList<String>();
        cards.add("4,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        cards.add("8,D");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(5, hc.checkStraight());

    }

    @Test
    void getToHighlight() {
    }

    @Test
    void calcPwrBarLvl() {
    }

    @Test
    void pwrBarLvlOnTurnOne() {
    }

    @Test
    void pwrBarLvlOnTurnTwo() {
    }

    @Test
    void pwrBarLvlOnTurnThree() {
    }

    @Test
    void pwrBarLvlOnTurnFour() {
    }

    @Test
    void help() {
    }

    @Test
    void advice() {
    }

    @Test
    void toHiglight() {
    }

    @Test
    void calcHandstrenght() {
    }
}