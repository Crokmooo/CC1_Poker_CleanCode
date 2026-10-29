package fr.crokmoo.cc1.poker;

public class Card {

    private Value value;
    private Type type;

    public Card(Value value, Type type) {
        if (value.getValue() < 2 || value.getValue() > 14)
            throw new IllegalArgumentException("Value must be between 2 and 14");
        this.value = value;
        this.type = type;
    }

    public Value getValue() {
        return value;
    }

    public void setValue(Value value) {
        this.value = value;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
