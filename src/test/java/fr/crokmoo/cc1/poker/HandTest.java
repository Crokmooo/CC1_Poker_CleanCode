package fr.crokmoo.cc1.poker;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class HandTest {

    @Test
    void handShouldHave5Cards() {
        List<Card> cards = List.of(
                new Card(Value.AS, Type.CARREAU),
                new Card(Value.AS, Type.TREFLE),
                new Card(Value.AS, Type.PIQUE),
                new Card(Value.AS, Type.PIQUE),
                new Card(Value.AS, Type.COEUR));

        Hand hand = new Hand(cards);
        assertThat(hand.getCards()).hasSize(5);
    }

    @Test
    void handShouldNotBeCreatedWithNullCards() {
        assertThatThrownBy(() -> new Hand(List.of(new Card(Value.AS, Type.CARREAU))))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
