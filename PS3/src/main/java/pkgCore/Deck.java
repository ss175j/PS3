package pkgCore;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

import pkgEnum.eRank;
import pkgEnum.eSuit;

import pkgException.DeckException;
public class Deck {

	private ArrayList<Card> cardsInDeck;

	public Deck() {
		for (eSuit eSuit : eSuit.values()) {
			for (eRank eRank : eRank.values()) {
				cardsInDeck.add(new Card(eSuit, eRank));
			}
		}
		Collections.shuffle(cardsInDeck);
	}
    
	//TODO: Fix the Draw method so it throws an exception if the deck is empty
	public Card Draw() throws DeckException {
		try {
			if (cardsInDeck.size() == 0) {
				throw new DeckException(this);
			}
		} catch (DeckException e) {
			throw e;
		}
		return cardsInDeck.remove(0);
	}
	
	
	//TODO: Write an overloaded Draw method to Draw a card of a given eSuit
	
	//TODO: Write an overloaded Draw method to Draw a card of a given eRank		
	public Card Draw(eSuit eSuit) {

			for (Card c :cardsInDeck) {
				if (c.geteSuit() == eSuit) {
					cardsInDeck.remove(c);
					return c;
				}
			}
			return null;
		}
	public Card Draw(eRank eRank) {
		for (Card c : cardsInDeck) {
			if (c.geteRank() == eRank) {
				cardsInDeck.remove(c);
				return c;
			}
		}
		return null;
	}
	

	//TODO: Write a method that will return the number of a given eSuit left in the deck.

	//TODO: Write a method that will return the number of a given eRank left in the deck.

	public int cardCounteRank(eRank eRank) {
		ArrayList<Card> cards = (ArrayList<Card>) cardsInDeck.stream().filter(c -> c.geteRank() == eRank).collect(Collectors.toList());
		return cards.size();
	}
	
	
	public int cardCounteSuit(eSuit eSuit) {
		ArrayList<Card> cards = (ArrayList<Card>) cardsInDeck.stream().filter(c -> c.geteSuit() == eSuit).collect(Collectors.toList());
		return cards.size();

	}

	//TODO: Write a method that will return 0 or 1 if a given card is left in the deck.
	public int isCardLeft(eSuit eSuit, eRank eRank) {
		List<Card> cards = cardsInDeck.stream().filter(c ->c.geteRank() == eRank && c.geteSuit() == eSuit)
				.collect(Collectors.toList());
		if (cards.size() == 0) {
			return 0;
		} else {
			return 1;
		}

	}
}
