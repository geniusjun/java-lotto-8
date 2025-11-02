package lotto.domain;

import static lotto.global.constans.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR;

public class Bonus {
    private final Number value;

    private Bonus(Number value) {
        this.value = value;
    }

    public static Bonus of(Number bonus, Lotto winning) {
        Validator.validateDuplicate(bonus, winning);
        return new Bonus(bonus);
    }

    private static class Validator {
        private static void validateDuplicate(Number bonus, Lotto winning) {
            if (isDuplicated(bonus, winning)) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
            }
        }

        private static boolean isDuplicated(Number bonus, Lotto winning) {
            return winning.getStream()
                    .anyMatch(number ->
                            number.equals(bonus));
        }
    }
}
