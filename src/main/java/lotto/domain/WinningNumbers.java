package lotto.domain;

import static lotto.global.constans.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR;

public class WinningNumbers {
    private final Lotto winning;
    private final Number bonus;

    private WinningNumbers(Lotto winning, Number bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public static WinningNumbers of(Lotto winning, Number bonus) {
        Validator.validateDuplicate(winning, bonus);
        return new WinningNumbers(winning, bonus);
    }

    private static class Validator {
        private static void validateDuplicate(Lotto winning, Number bonus) {
            if (isDuplicated(winning, bonus)) {
                throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
            }
        }

        private static boolean isDuplicated(Lotto winning, Number bonus) {
            return winning.getStream()
                    .anyMatch(number ->
                            number.equals(bonus));
        }
    }
}
