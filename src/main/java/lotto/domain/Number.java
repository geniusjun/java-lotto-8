package lotto.domain;

public class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number of(int value) {
        return new Number(value);
    }
}
