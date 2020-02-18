package aiClass;

import deck.Card;
import deck.Deck;

/**
 * Class that is for testing of the AI.
 * And also been used for doing the WhiteBox testing of the ai-player.
 *
 * @author Max Frennessen 17-05-25, Reengineered by Andreas Andersson 20-02-11
 * @version 1.0
 */
public class TestAi {
    private Deck deck = new Deck();;
    private Ai ai;
    private Card card1;
    private Card card2;
    private Card[] flop = new Card[3];
    private Card cardTurn;
    private Card cardRiver;
    private String aiName;
    private int aiPot;
    private ClassLoader classLoader = Thread.currentThread().getContextClassLoader();

	/**
	 * Method which returns a specified card from the deck.
	 * @param index the index of the specified card in the deck.
	 * @return
	 */
	public Card getSpecifiedCard(int index) {
        return this.deck.getCard(index);
    }

	/**
	 * Method which instantiates an AI-player and sets its name and starting pot.
	 * @param aiPot the starting pot for the AI-player
	 * @param aiName the name for the AI-player
	 */
	public void setAi(int aiPot, String aiName){
		this.aiName = aiName;
		this.aiPot = aiPot;
		ai = new Ai(this.aiPot, this.aiName);
	}

	/**
	 * Function which tests the AI-players decision making capabilities with a given starting hand and the current bet.
	 * The AI-players decision is printed in the console.
	 * @param card1Index the index of the first card in the deck.
	 * @param card2Index the index of the second card in the deck.
 	 * @param currentBet the current bet.
	 */
	public void testAiStartingHand(int card1Index, int card2Index, int currentBet){
		card1 = getSpecifiedCard(card1Index);
		card2 = getSpecifiedCard(card2Index);

		//Adds card to AIs ArrayList of cards
		ai.setStartingHand(card1, card2);
		System.out.println("\n\n-Test First Round-");
		//Sends the current bet the AI has to pay to keep playing.
		ai.makeDecision(currentBet);
		System.out.println(ai.getDecision());
	}

	/**
	 * Function which generates the flop for the round and calls the AI-player to make a decision based on it.
	 * The decision is then printed in the console.
	 * @param flopIndex the indexes of the chosen cards in the flop.
	 * @param currentBet the current bet.
	 */
    public void testAiFlop(int[] flopIndex, int currentBet){
    	flop[0] = getSpecifiedCard(flopIndex[0]);
		flop[1] = getSpecifiedCard(flopIndex[1]);
		flop[2] = getSpecifiedCard(flopIndex[2]);

<<<<<<< HEAD
    ai.setStartingHand(card1, card2);
//    ai.makeDecision(150);

    ai.makeDecision(32, flop);
//
//    System.out.println("\n\n-Test TURN-");
//    ai.makeDecision(32, cardTurn);
//    System.out.println(ai.getDecision());
//
//    System.out.println("\n\n-Test RIVER-");
//    ai.makeDecision(32, cardRiver);
//    System.out.println(ai.getDecision());
=======
		System.out.println("\n\n-Test FLOP-");
		//Sends the current bet the AI has to pay to keep playing and the flop (the first three cards that everyone gets to see).
		ai.makeDecision(currentBet, flop);
		System.out.println(ai.getDecision());
	}

	/**
	 * Function which takes the turn card and the current bet as parameters.
	 * Calls the AI-player to make a decision on them.
	 * @param turnIndex the turn cards index in the deck.
	 * @param currentBet the current bet.
	 */
	public void testAiTurn(int turnIndex, int currentBet){
		cardTurn = getSpecifiedCard(turnIndex);
>>>>>>> Andreas

		System.out.println("\n\n-Test TURN-");
		ai.makeDecision(currentBet, cardTurn);
		System.out.println(ai.getDecision());
	}

	/**
	 * Function which takes the river card and the current bet as parameters.
	 * Calls the AI-player to make a decision on them.
	 * @param turnIndex the turn cards index in the deck.
	 * @param currentBet the current bet.
	 */
	public void testAiRiver(int riverIndex, int currentBet){
		cardRiver = getSpecifiedCard(riverIndex);

		System.out.println("\n\n-Test RIVER-");
		ai.makeDecision(currentBet, cardRiver);
		System.out.println(ai.getDecision());
	}
	
    public static void main(String[] args) {
        TestAi run = new TestAi();
		//Card Values:
		// 2H - 14H = 0 - 12,
		// 2S - 14S = 13 - 25,
		// 2C - 14C = 26 - 38,
		// 2D - 14D = 39 - 51.
		int card1Value = 12;
		int card2Value = 25;
		// To test the test cases: TF1, TF6, TF7 & TF8.
		// Assign the starting hand cards (card1Value, card2Value), set the AI name and pot(aiName, aiPot).
		// Set the current bet and then run the method testAiStartingHand().
		String aiName = "Tramse";
		int aiPot = 500;
		run.setAi(aiPot, aiName);
        run.testAiStartingHand(card1Value, card2Value,32);

        //To test the test case TF2 & TF9, also assign the flopIndexes, turnCard and riverCard variable and run all methods.
		int[] flopIndexes = {38,51,0};
		run.testAiFlop(flopIndexes,48);

		//Methods for testing test case TF2. Assign turnCard, riverCard and run the methods.
		int turnCard = 13;
        run.testAiTurn(turnCard, 52);
		int riverCard = 26;
		run.testAiRiver(riverCard, 70);
    }
}
