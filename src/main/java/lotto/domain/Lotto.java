package lotto.domain;

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
            if (numbers.size() != 6) {
                throw new IllegalArgumentException("[ERROR] 로또 번호는 6개여야 합니다.");
            }
        }
    }

    // TODO: 추가 기능 구현
}
