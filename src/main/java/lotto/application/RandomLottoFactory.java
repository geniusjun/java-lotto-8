package lotto.application;

import static lotto.global.constans.NumberType.LOTTO_SIZE;
import static lotto.global.constans.NumberType.MAX_LOTTO_NUMBER;
import static lotto.global.constans.NumberType.MIN_LOTTO_NUMBER;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Number;

public class RandomLottoFactory implements LottoFactory {
    @Override
    public Lotto create() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(
                MIN_LOTTO_NUMBER.getValue(),
                MAX_LOTTO_NUMBER.getValue(),
                LOTTO_SIZE.getValue()
        );
        return Lotto.from(IntegerToNumber(numbers));
    }

    private static List<Number> IntegerToNumber(List<Integer> numbers) {
        return numbers.stream()
                .map(Number::valueOf)
                .toList();
    }
}
