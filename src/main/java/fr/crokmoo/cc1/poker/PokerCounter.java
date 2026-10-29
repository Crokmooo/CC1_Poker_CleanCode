package fr.crokmoo.cc1.poker;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class PokerCounter {

    public Integer count(List<Hand> hands) {
        int totalPoints = 0;
        for (Hand hand : hands) {
            Map<Value, Long> occurrences = hand.getCards().stream()
                    .collect(Collectors.groupingBy(Card::getValue, Collectors.counting()));

            boolean hasBrelan = occurrences.containsValue(3L);

            if (hasBrelan) {
                totalPoints += 30;
            } else {
                totalPoints += hand.getCards().stream()
                        .mapToInt(c -> c.getValue().getValue())
                        .max().orElse(0);
            }
        }
        return totalPoints;
    }
}
