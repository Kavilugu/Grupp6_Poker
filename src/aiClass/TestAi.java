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

    public Card getSpecifiedCard(int index) {
        return this.deck.getCard(index);
    }

    public void setAi(int aiPot, String aiName){
		this.aiName = aiName;
		this.aiPot = aiPot;
		ai = new Ai(this.aiPot, this.aiName);
	}

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

    public void testAiFlop(int[] flopIndex, int currentBet){
    	flop[0] = getSpecifiedCard(flopIndex[0]);
		flop[1] = getSpecifiedCard(flopIndex[1]);
		flop[2] = getSpecifiedCard(flopIndex[2]);

		System.out.println("\n\n-Test FLOP-");
		//Sends the current bet the AI has to pay to keep playing and the flop (the first three cards that everyone gets to see).
		ai.makeDecision(currentBet, flop);
		System.out.println(ai.getDecision());
	}

	public void testAiTurn(int turnIndex, int currentBet){
		cardTurn = getSpecifiedCard(turnIndex);

		System.out.println("\n\n-Test TURN-");
		ai.makeDecision(currentBet, cardTurn);
		System.out.println(ai.getDecision());
	}

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
		// Assign the starting hands cards, set the AI name and pot.
		// Set the current bet and then run the program.
		String aiName = "Tramse";
		int aiPot = 500;
		run.setAi(aiPot, aiName);
        run.testAiStartingHand(card1Value, card2Value,32);

        //To test the test case TF2 & TF9 assign the flopIndexes, turnCard and riverCard variable and run all methods.
		int[] flopIndexes = {38,51,0};
		run.testAiFlop(flopIndexes,48);

		//method for testing test case TF
		int turnCard = 13;
        run.testAiTurn(turnCard, 52);
		//method for testing test case TF2
		int riverCard = 26;
		run.testAiRiver(riverCard, 70);
    }
}
