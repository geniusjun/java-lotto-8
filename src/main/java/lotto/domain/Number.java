package lotto.domain;

import static lotto.global.constans.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constans.NumberType.MIN_LOTTO_NUMBER;

import java.util.Objects;
import lotto.global.constans.ErrorMessage;

public class Number {
    private int value;

    private Number(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Number number = (Number) o;
        return value == number.value;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(value);
    }

    public static Number valueOf(int value) {
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
