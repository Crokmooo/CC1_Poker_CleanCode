package fr.crokmoo.cc1.poker;

import java.util.ArrayList;
import java.util.List;

public class Hand {
    private final List<Card> cards;

    public Hand(List<Card> cards) {
        if (cards == null || cards.size() != 5)
            throw new IllegalArgumentException("Invalid hand");
        this.cards = new ArrayList<>(cards);
    }

    public List<Card> getCards() {
        return cards;
    }
}
