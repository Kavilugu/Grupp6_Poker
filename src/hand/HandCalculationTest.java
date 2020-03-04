package hand;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class HandCalculationTest {

    @Test
    void checkNoPairTest() {

        //Player has no pairs
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(0, hc.checkPairAndMore());

        //Player has no pairs
        cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");
        cards.add("2,D");
        cards.add("3,H");
        cards.add("1,D");
        cards.add("8,H");

        hc = new HandCalculation(cards);

        assertEquals(0, hc.checkPairAndMore());

    }

    @Test
    void checkPairTest() {

        //Player has one pair
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,H");

        HandCalculation hc = new HandCalculation(cards);

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

        //Player has one pair in community cards
        cards = new ArrayList<String>();
        cards.add("6,D");
        cards.add("7,H");
        cards.add("9,H");
        cards.add("10,S");
        cards.add("11,H");
        cards.add("8,D");
        cards.add("8,D");

        hc = new HandCalculation(cards);

        assertEquals(2, hc.checkPairAndMore());

    }

    @Test
    void checkTwoPairTest() {

        //Player has two pair
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("7,H");
        cards.add("7,S");
        cards.add("8,C");
        cards.add("9,H");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(22, hc.checkPairAndMore());

        //Player has two pair with one pair only in community cards
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,H");
        cards.add("8,S");
        cards.add("8,C");
        cards.add("9,H");

        hc = new HandCalculation(cards);

        assertEquals(22, hc.checkPairAndMore());

        //Player has two pair with one pair only in community cards
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("7,H");
        cards.add("6,S");
        cards.add("8,C");
        cards.add("6,H");

        hc = new HandCalculation(cards);

        assertEquals(22, hc.checkPairAndMore());

        //Player has two pair with both pairs in community cards
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("7,H");
        cards.add("6,S");
        cards.add("3,C");
        cards.add("3,H");
        cards.add("6,H");

        hc = new HandCalculation(cards);

        assertEquals(22, hc.checkPairAndMore());

    }

    @Test
    void checkThreeOfAKindTest() {

        //Player has three of a kind with one card not among community cards
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("9,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("3,D");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(3, hc.checkPairAndMore());

        //Player has three of a kind with all three cards among community cards
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("9,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("7,D");

        hc = new HandCalculation(cards);

        assertEquals(3, hc.checkPairAndMore());

    }

    @Test
    void checkFourOfAKindTest() {

        //Player has Four of a kind
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("9,H");

        HandCalculation hc = new HandCalculation(cards);

        assertEquals(4, hc.checkPairAndMore());

        //Player has Four of a kind with all four in community cards
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("6,H");
        cards.add("7,S");
        cards.add("7,C");
        cards.add("7,H");
        cards.add("7,D");

        hc = new HandCalculation(cards);

        assertEquals(4, hc.checkPairAndMore());

    }

    @Test
    void checkHighCards() {
        //should return "true" if the combined value of 2 cards >= 17
        ArrayList<String> cards = new ArrayList<String>();

        //test1
        cards.add("1,D");
        cards.add("1,H");
        HandCalculation hc = new HandCalculation(cards);
        assertFalse(hc.checkHighCards());

        //test2
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("8,H");
        hc = new HandCalculation(cards);
        assertFalse(hc.checkHighCards());

        //test3
        cards = new ArrayList<String>();
        cards.add("9,D");
        cards.add("8,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test4
        cards = new ArrayList<String>();
        cards.add("8,D");
        cards.add("9,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test5
        cards = new ArrayList<String>();
        cards.add("9,D");
        cards.add("9,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test6
        cards = new ArrayList<String>();
        cards.add("12,D");
        cards.add("12,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test7
        cards = new ArrayList<String>();
        cards.add("1,D");
        cards.add("13,H");
        hc = new HandCalculation(cards);
        assertFalse(hc.checkHighCards());

        //test8
        cards = new ArrayList<String>();
        cards.add("5,D");
        cards.add("12,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test9
        cards = new ArrayList<String>();
        cards.add("12,D");
        cards.add("5,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test10
        cards = new ArrayList<String>();
        cards.add("10,D");
        cards.add("7,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test11
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("10,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test12
        cards = new ArrayList<String>();
        cards.add("13,D");
        cards.add("4,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());

        //test13
        cards = new ArrayList<String>();
        cards.add("4,D");
        cards.add("13,H");
        hc = new HandCalculation(cards);
        assertTrue(hc.checkHighCards());


    }

    @Test
    void checkSuit() {
        //should return the amount of same-suited cards, of which there are most

        //test1
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("8,S");
        HandCalculation hc = new HandCalculation(cards);
        assertEquals(1, hc.checkSuit());

        //test2
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("9,D");
        hc = new HandCalculation(cards);
        assertEquals(2, hc.checkSuit());

        //test3
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,D");
        hc = new HandCalculation(cards);
        assertEquals(3, hc.checkSuit());

        //test4
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,D");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkSuit());

        //test5
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,D");
        hc = new HandCalculation(cards);
        assertEquals(5, hc.checkSuit());

        //test6
        cards = new ArrayList<String>();
        cards.add("9,D");
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,D");
        hc = new HandCalculation(cards);
        assertEquals(6, hc.checkSuit());

        //test7
        cards = new ArrayList<String>();
        cards.add("7,S");
        cards.add("9,S");
        cards.add("7,S");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(7, hc.checkSuit());

        //test8
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(5, hc.checkSuit());

        //test9
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,D");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkSuit());

        //test10
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,D");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkSuit());

        //test11
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,D");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(5, hc.checkSuit());

        //test12
        cards = new ArrayList<String>();
        cards.add("7,D");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(6, hc.checkSuit());

        //test13
        cards = new ArrayList<String>();
        cards.add("7,S");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        cards.add("7,S");
        cards.add("3,S");
        hc = new HandCalculation(cards);
        assertEquals(7, hc.checkSuit());

    }

    @Test
    void checkStraight() {
        //should return the amount of cards currently in a straight

        //test1
        ArrayList<String> cards = new ArrayList<String>();
        cards.add("4,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        cards.add("8,D");
        HandCalculation hc = new HandCalculation(cards);
        assertEquals(5, hc.checkStraight());

        //test2
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        cards.add("8,D");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkStraight());

        //test3
        cards = new ArrayList<String>();
        cards.add("2,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        cards.add("8,D");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkStraight());

        //test4
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        cards.add("9,D");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkStraight());

        //test5
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("8,C");
        cards.add("10,D");
        hc = new HandCalculation(cards);
        assertEquals(3, hc.checkStraight());

        //test6
        cards = new ArrayList<String>();
        cards.add("1,D");
        cards.add("3,H");
        cards.add("5,S");
        cards.add("7,C");
        cards.add("9,D");
        hc = new HandCalculation(cards);
        assertEquals(3, hc.checkStraight());

        //test7
        cards = new ArrayList<String>();
        cards.add("1,D");
        cards.add("3,H");
        cards.add("6,S");
        cards.add("9,C");
        cards.add("13,D");
        hc = new HandCalculation(cards);
        assertEquals(2, hc.checkStraight());

        //test8
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        hc = new HandCalculation(cards);
        assertEquals(2, hc.checkStraight());

        //test9
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        cards.add("6,S");
        hc = new HandCalculation(cards);
        assertEquals(3, hc.checkStraight());

        //test10
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkStraight());

        //test11
        cards = new ArrayList<String>();
        cards.add("3,D");
        cards.add("5,H");
        cards.add("6,S");
        cards.add("7,C");
        cards.add("8,D");
        cards.add("4,C");
        cards.add("2,D");
        hc = new HandCalculation(cards);
        assertEquals(5, hc.checkStraight());

        //test12
        cards = new ArrayList<String>();
        cards.add("1,D");
        cards.add("2,H");
        cards.add("3,S");
        cards.add("6,C");
        cards.add("7,D");
        cards.add("8,C");
        cards.add("9,D");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkStraight());

        //test13
        cards = new ArrayList<String>();
        cards.add("1,D");
        cards.add("2,H");
        cards.add("3,S");
        cards.add("4,C");
        cards.add("7,D");
        cards.add("8,C");
        cards.add("9,D");
        hc = new HandCalculation(cards);
        assertEquals(4, hc.checkStraight());
    }

   
}