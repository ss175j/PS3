package pkgCore;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import pkgEnum.eRank;
import pkgEnum.eSuit;
import pkgException.DeckException;

public class DeckTest {

	@Test
	public void TestEmptyDeck() throws DeckException {
		//TODO: Build a deck, draw until you get a DeckException
		Deck d = new Deck();
		int i = 0;
		for (; i<54 ; i++) {
			d.Draw();
		}
	}
	
	@Test
	public void TestDrawSuit() {
		//TODO: Build a deck, test the Draw(eSuit) method
		Deck d= new Deck();
		Card c= d.Draw(eSuit.DIAMONDS);
		assertEquals(c.geteSuit(),eSuit.DIAMONDS);
	}
	
	@Test
	public void TestDrawRank() {
		//TODO: Build a deck, test the Draw(eRank) method
		Deck d= new Deck();
		Card c= d.Draw(eRank.ACE);
		assertTrue(c.geteRank() == eRank.ACE);
	}
	
	public void TestDeckRankCount() {
		//TODO: Build a deck, test the DeckRankCount method
		Deck d= new Deck();
		assertEquals(d.cardCounteRank(eRank.QUEEN),4);
	}
	
	public void TestDeckSuitCount() {
		//TODO: Build a deck, test the DeckSuitCount method
		Deck d = new Deck();
		assertEquals(d.cardCounteSuit(eSuit.CLUBS), 13);
	}

}
