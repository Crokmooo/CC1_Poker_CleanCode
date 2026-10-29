package fr.crokmoo.cc1.poker;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CardTest {

    @ParameterizedTest
    @CsvSource({
            "DEUX, TREFLE",
            "AS, CARREAU"
    })
    void cardShouldHaveValueBetween2And14(Value value, Type type) {
        Card card = new Card(value, type);
        assertThat(card.getValue()).isBetween(Value.DEUX, Value.AS);
    }
}
