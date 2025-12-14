package lotto.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.util.ErrorMessage;

public class Lotto {
    private final List<Integer> numbers;

    private Lotto(List<Integer> numbers) {
        validateSize(numbers);
        validateDuplicate(numbers);
        this.numbers = numbers;
    }

    public static Lotto from(List<Integer> numbers) {
        return new Lotto(numbers);
    }

    public List<Integer> getNumbers() {
        return numbers;
    }

    private void validateSize(List<Integer> numbers) {
        if (numbers.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private void validateDuplicate(List<Integer> numbers) {
        Set<Integer> set = new HashSet<>(numbers);
        if (set.size() != 6) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_DUPLICATE.getMessage());
        }
    }
}
