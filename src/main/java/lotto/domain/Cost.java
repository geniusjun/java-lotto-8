package lotto.domain;

import static lotto.global.constans.ErrorMessage.INVALID_UNIT_ERROR;

import lotto.global.Parser;

public class Cost {
    private final int price;

    private Cost(int price) {
        this.price = price;
    }

    public static Cost from(String message) {
        return new Cost(Validator.validate(message));
    }

    private static class Validator {
        public static int validate(String cost) {
            int value = Parser.StringToInt(cost);
            validateUnit(value);
            return value;
        }

        private static void validateUnit(int value) {
            if (isNotDivisible(value)) {
                throw new IllegalArgumentException(INVALID_UNIT_ERROR.getMessage());
            }
        }

        private static boolean isNotDivisible(int value) {
            return value % 1000 != 0;
        }
    }
}
