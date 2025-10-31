package lotto.domain;

import static lotto.global.constans.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constans.NumberType.MIN_LOTTO_NUMBER;

import lotto.global.constans.ErrorMessage;

public class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public static Number of(int value) {
        Validator.validate(value);
        return new Number(value);
    }

    private static class Validator {
        private static void validate(int value) {
            validateInvalidRange(value);
        }

        private static void validateInvalidRange(int value) {
            if (isInvalidRange(value)) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_RANGE_ERROR.getMessage());
            }
        }

        private static boolean isInvalidRange(int value) {
            return value < MIN_LOTTO_NUMBER.getValue() || value > MAX_LOTTO_NUMBER.getValue();
        }
    }
}
