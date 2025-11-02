package lotto.domain;

import static lotto.global.constans.ErrorMessage.INVALID_UNIT_ERROR;
import static lotto.global.constans.NumberType.COST_UNIT;

import lotto.global.Parser;

public class Cost {
    private final int price;

    private Cost(int price) {
        this.price = price;
    }

    public static Cost from(String message) {
        return new Cost(Validator.validate(message));
    }

    public int getCount() {
        return price / COST_UNIT.getValue();
    }

    public int getPrice() {
        return price;
    }

    private static class Validator {
        public static int validate(String cost) {
            int value = Parser.stringToInt(cost);
            validateUnit(value);
            return value;
        }

        private static void validateUnit(int value) {
            if (isNotDivisible(value)) {
                throw new IllegalArgumentException(INVALID_UNIT_ERROR.getMessage());
            }
        }

        private static boolean isNotDivisible(int value) {
            return value % COST_UNIT.getValue() != 0;
        }
    }
}
