package hand;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import deck.Card;
import deck.Deck;

/**
 * Class for testing the hand class and has also been used for the Whitebox Testing of the hand class.
 *
 * @author Max Frennessen 17-05-25, Reengineerd by Malin Hällström 20-02-12
 * @version 2.0
 */
public class TestHand {
	Deck deck = new Deck();

	public Card getSpecifiedCard(int index) {
		return this.deck.getCard(index);
	}

	/**
	 * To test cases for hands with two cards.
	 */
	public void testTwoCards(int cIndex1, int cIndex2) {
		Card card1 = getSpecifiedCard(cIndex1);
		Card card2 = getSpecifiedCard(cIndex2);
		// Bara för att dubbelkolla att det faktiskt är rätt kort vi skrivit in, kan tas bort sen.
		// System.out.println("Cardvalue: " + card1.getCardValue() + " suit: " + card1.getCardSuit());
		// System.out.println("Cardvalue: " + card2.getCardValue() + " suit: " + card2.getCardSuit());
		ArrayList<Card> twoCards = new ArrayList<>();
		twoCards.add(card1);
		twoCards.add(card2);

		Hand hand = new Hand(twoCards);

		System.out.println(hand.theHelp() + "\n" + hand.theAdvice()  + "\n" + hand.toPowerBar() + "\n" + hand.getHighlightedCards());
		System.out.println("_________________________________");
	}

	/**
	 * To test cases for hands with five cards.
	 */
	public void testFiveCard(int cIndex1, int cIndex2, int cIndex3, int cIndex4, int cIndex5) {
		Card card1 = getSpecifiedCard(cIndex1);
		Card card2 = getSpecifiedCard(cIndex2);
		Card card3 = getSpecifiedCard(cIndex3);
		Card card4 = getSpecifiedCard(cIndex4);
		Card card5 = getSpecifiedCard(cIndex5);

		ArrayList<Card> fiveCards = new ArrayList<>();
		fiveCards.add(card1);
		fiveCards.add(card2);
		fiveCards.add(card3);
		fiveCards.add(card4);
		fiveCards.add(card5);

		Hand hand = new Hand(fiveCards);
		System.out.println(hand.theHelp() + "\n" + hand.theAdvice()  + "\n" + hand.toPowerBar() + "\n" + hand.getHighlightedCards());
		System.out.println("_________________________________");
	}

	/*
        Card Values:
        2H - 14H = 0 - 12,
        2S - 14S = 13 - 25,
        2C - 14C = 26 - 38,
        2D - 14D = 39 - 51.
     */
	public static void main(String[] args) {
		TestHand run = new TestHand();

		// Added an underline between the test cases to make it easier to separate the hands.

		// To test the test case: TF14
		run.testTwoCards(12, 17);

		// To test the test case: TF15
		run.testTwoCards(4, 17);

		// To test the test case: TF16
		run.testFiveCard(0, 15, 13, 28, 40);

		// To test the test case: TF17
		run.testFiveCard(0, 13, 39, 28, 40);

		// To test the test case: TF18
		run.testFiveCard(0, 1, 2, 3, 17);

		// To test the test case: TF19
		run.testFiveCard(0, 2, 4, 6, 8);

		// To test the test case: TF20
		run.testFiveCard(0, 15, 26, 2, 13);

		// To test the test case: TF21
		run.testFiveCard(0, 13, 26, 39, 2);

		// To test the test case: TF22
		run.testFiveCard(0, 1, 2, 3, 4);
	}
}