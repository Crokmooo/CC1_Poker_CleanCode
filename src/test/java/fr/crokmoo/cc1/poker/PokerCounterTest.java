package fr.crokmoo.cc1.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class PokerCounterTest {

    @Test
    void shouldReturnHighestCardValue() {
        Hand hand = new Hand(List.of(
                new Card(Value.DEUX, Type.COEUR),
                new Card(Value.CINQ, Type.PIQUE),
                new Card(Value.HUIT, Type.CARREAU),
                new Card(Value.DIX, Type.TREFLE),
                new Card(Value.ROI, Type.COEUR)
        ));
        PokerCounter counter = new PokerCounter();

        assertThat(counter.count(List.of(hand))).isEqualTo(13);
    }

    @Test
    void shouldReturn30PointsForBrelan() {
        Hand hand = new Hand(List.of(
                new Card(Value.SEPT, Type.COEUR),
                new Card(Value.SEPT, Type.PIQUE),
                new Card(Value.SEPT, Type.CARREAU),
                new Card(Value.DIX, Type.TREFLE),
                new Card(Value.ROI, Type.COEUR)
        ));
        PokerCounter counter = new PokerCounter();

        assertThat(counter.count(List.of(hand))).isEqualTo(30);
    }

    @Test
    void shouldReturn40PointsForSuite() {
        Hand hand = new Hand(List.of(
                new Card(Value.CINQ, Type.TREFLE),
                new Card(Value.SIX, Type.CARREAU),
                new Card(Value.SEPT, Type.COEUR),
                new Card(Value.HUIT, Type.PIQUE),
                new Card(Value.NEUF, Type.TREFLE)
        ));
        PokerCounter counter = new PokerCounter();

        assertThat(counter.count(List.of(hand))).isEqualTo(40);
    }

    @Test
    void shouldReturn45PointsForColor() {
        Hand hand = new Hand(List.of(
                new Card(Value.DEUX, Type.COEUR),
                new Card(Value.SEPT, Type.COEUR),
                new Card(Value.NEUF, Type.COEUR),
                new Card(Value.VALET, Type.COEUR),
                new Card(Value.ROI, Type.COEUR)
        ));
        PokerCounter counter = new PokerCounter();

        assertThat(counter.count(List.of(hand))).isEqualTo(45);
    }
}
