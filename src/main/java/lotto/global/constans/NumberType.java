package lotto.global.constans;

public enum NumberType {
    COST_UNIT(1000);
    private final int value;

    NumberType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
