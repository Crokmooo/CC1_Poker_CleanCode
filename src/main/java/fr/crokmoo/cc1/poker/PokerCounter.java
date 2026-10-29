package fr.crokmoo.cc1.poker;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerCounter {

    public Integer count(List<Hand> hands) {
        int totalPoints = 0;
        for (Hand hand : hands) {
            Map<Value, Long> occurrences = hand.getCards().stream()
                    .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

            boolean isSuite = isSuite(hand);
            boolean isColor = isColor(hand);

            boolean hasPair = occurrences.containsValue(2L);
            boolean hasBrelan = occurrences.containsValue(3L);
            boolean hasCarre = occurrences.containsValue(4L);

            if (isSuite && isColor) {
                totalPoints += 80;
            } else if (hasCarre) {
                totalPoints += 60;
            } else if (hasBrelan && hasPair) {
                totalPoints += 50;
            } else if (isColor) {
                totalPoints += 45;
            } else if (isSuite) {
                totalPoints += 40;
            } else if (hasBrelan) {
                totalPoints += 30;
            } else {
                totalPoints += getHighestCardValue(hand);
            }
        }
        return totalPoints;
    }

    private boolean isSuite(Hand hand) {
        List<Card> sorted = hand.getCards().stream()
                .sorted(Comparator.comparingInt(c -> c.getValue().getValue()))
                .toList();

        for (int i = 0; i < sorted.size() - 1; i++) {
            if (sorted.get(i + 1).getValue().getValue() != sorted.get(i).getValue().getValue() + 1) {
                return false;
            }
        }
        return true;
    }

    private boolean isColor(Hand hand) {
        return hand.getCards().stream()
                .map(Card::getType)
                .distinct()
                .count() == 1;
    }

    private int getHighestCardValue(Hand hand) {
        return hand.getCards().stream()
                .mapToInt(c -> c.getValue().getValue())
                .max()
                .orElse(0);
    }
}
