package aiClass;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import deck.Card;
import deck.Deck;

/**
 * Class that is for testing of the AI. *
 * @author Ekaterina Korotetskaya
 * @version 1.0
 */

class AiTest {
	
	private Card card1;
    private Card card2;
    private Deck deck = new Deck();
    
	
	@Test
    void checkHighCardsTest() {

        ArrayList<String> cards = new ArrayList<String>();
        cards.add("10,S");
        cards.add("7,H");
        AiCalculation aiCalculation = new AiCalculation(cards);
        assertEquals(true, aiCalculation.checkHighCards());
        
        cards = new ArrayList<String>();
        cards.add("5,D");
        cards.add("7,S");
        aiCalculation = new AiCalculation(cards);
        assertEquals(false, aiCalculation.checkHighCards());
    }
	
	@Test
	void checkSuitTest() {
		ArrayList<String> cards = new ArrayList<String>();
        cards.add("10,C");
        cards.add("7,H");
        AiCalculation aiCalculation = new AiCalculation(cards);
        assertEquals(1, aiCalculation.checkSuit());     
        
        cards = new ArrayList<String>(); 
        cards.add("10,C");
        cards.add("7,C");
        aiCalculation = new AiCalculation(cards);
        assertEquals(2, aiCalculation.checkSuit());          
        
        cards = new ArrayList<String>(); 
        cards.add("10,C");
        cards.add("7,C");
        cards.add("3,C");
        aiCalculation = new AiCalculation(cards);
        assertEquals(3, aiCalculation.checkSuit()); 
        
        cards = new ArrayList<String>(); 
        cards.add("10,C");
        cards.add("7,C");
        cards.add("3,C");
        cards.add("3,D");
        aiCalculation = new AiCalculation(cards);
        assertEquals(3, aiCalculation.checkSuit()); 
        
        
        cards = new ArrayList<String>(); 
        cards.add("10,C");
        cards.add("7,D");
        cards.add("7,H");
        cards.add("7,S");
        cards.add("5,C");
        aiCalculation = new AiCalculation(cards);
        assertEquals(2, aiCalculation.checkSuit());  
        
        cards = new ArrayList<String>(); 
        cards.add("10,C");
        cards.add("7,C");
        cards.add("7,C");
        cards.add("7,S");
        cards.add("5,C");
        aiCalculation = new AiCalculation(cards);
        assertEquals(4, aiCalculation.checkSuit());
	}
	
	@Test
	void checkStraightTest() {
		ArrayList<String> cards = new ArrayList<String>();
		cards.add("2,C");
	    cards.add("3,D");
	    cards.add("4,H");
	    cards.add("5,S");
	    cards.add("6,C");
	    AiCalculation aiCalculation = new AiCalculation(cards);
	    assertEquals(5, aiCalculation.checkStraight());
	}
	
	
	@Test
	void testDecisionPreFlop() {
		// AI Player makes a decision from the cards Hearts 2 and Spades 9
		// The AI player should give the result “fold”.
		int card1AI = 0;
		int card2AI = 20;
		int currentBet = 50;		
		String aiName = "Test";
		int aiPot = 50;		
		Ai ai = new Ai(aiPot, aiName);		
		card1 = deck.getCard(card1AI);
		card2 = deck.getCard(card2AI);		
		ai.setStartingHand(card1, card2); 		
		ai.makeDecision(currentBet); 		
		assertEquals("fold", ai.getDecision());
		
		
		// AI Player makes a decision from the cards Club Ace and Spades Ace
		// The AI player should give the result “raise”.
		card1AI = 25;
		card2AI = 38;
		currentBet = 50;		
		aiName = "Test";
		aiPot = 500;		
		ai = new Ai(aiPot, aiName);		
		card1 = deck.getCard(card1AI);
		card2 = deck.getCard(card2AI);		
		ai.setStartingHand(card1, card2); 		
		ai.makeDecision(currentBet); 		
		assertEquals("raise,62", ai.getDecision());
		
		// AI Player makes a decision from the cards Hearts 3 and Hearts 4
		// The AI player should give the result “call”.
		card1AI = 1;
		card2AI = 2;
		currentBet = 50;		
		aiName = "Test";
		aiPot = 500;		
		ai = new Ai(aiPot, aiName);		
		card1 = deck.getCard(card1AI);
		card2 = deck.getCard(card2AI);		
		ai.setStartingHand(card1, card2); 		
		ai.makeDecision(currentBet); 		
		assertEquals("call,50", ai.getDecision());
	}
}
