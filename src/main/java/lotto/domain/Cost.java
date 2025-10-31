package lotto.domain;

import lotto.global.Parser;

public class Cost {
    private final int price;

    private Cost(int price) {
        this.price = price;
    }

    public static Cost from(String message) {
        return new Cost(Parser.StringToInt(message));
    }
}
