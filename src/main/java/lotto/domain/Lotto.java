package lotto.domain;

import static lotto.global.constans.ErrorMessage.INVALID_LOTTO_SIZE_ERROR;
import static lotto.global.constans.ErrorMessage.NUMBER_DUPLICATE_ERROR;

import java.util.List;

public class Lotto {
    private final List<Number> numbers;

    private Lotto(List<Number> numbers) {
        Validator.validate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Number> numbers) {
        return new Lotto(numbers);
    }

    private static class Validator {
        private static void validate(List<Number> numbers) {
            validateDuplicate(numbers);
            validateLottoSize(numbers);
        }

        private static void validateDuplicate(List<Number> numbers) {
            if (isDuplicated(numbers)) {
                throw new IllegalArgumentException(NUMBER_DUPLICATE_ERROR.getMessage());
            }
        }

        private static boolean isDuplicated(List<Number> numbers) {
            return getUniqueSize(numbers) != numbers.size();
        }

        private static int getUniqueSize(List<Number> numbers) {
            return (int) numbers
                    .stream()
                    .distinct()
                    .count();
        }

        private static void validateLottoSize(List<Number> numbers) {
            if (numbers.size() != 6) {
                throw new IllegalArgumentException(INVALID_LOTTO_SIZE_ERROR.getMessage());
            }
        }
    }

    // TODO: 추가 기능 구현
}
