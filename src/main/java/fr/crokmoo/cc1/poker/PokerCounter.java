package fr.crokmoo.cc1.poker;

import java.util.List;

public class PokerCounter {

    public Integer count(List<Hand> hands) {
        int totalPoints = 0;
        for (Hand hand : hands) {
            int pointsMain = hand.getCards().stream()
                    .mapToInt(c -> c.getValue().getValue())
                    .max()
                    .orElse(0);
            totalPoints += pointsMain;
        }
        return totalPoints;
    }
}
