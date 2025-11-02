package lotto.view.format;

import static lotto.global.constans.MessageType.LOTTO_COUNT_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;

public class LottoFormatter {
    private static final String SEPARATOR = ", ";
    private static final String PREFIX = "[";
    private static final String POSTFIX = "]";

    private LottoFormatter() {
    }

    public static String lottoCount(int count) {
        return String.format(LOTTO_COUNT_MESSAGE.getMessage(), count);
    }

    /**
     * 로또 여러 장을 문자열 리스트로 반환한다.
     */
    public static List<String> lottoLines(Lottos lottos) {
        return lottos.getStream()
                .map(LottoFormatter::lottoLine)
                .toList();
    }

    /**
     * 한 장을 "[1, 8, 11, 31, 41, 42]" 형태로 정렬하여 반환한다.
     */
    private static String lottoLine(Lotto lotto) {
        return lotto.getStream()
                .map(Number::getValue)
                .sorted()
                .map(String::valueOf)
                .collect(Collectors.joining(SEPARATOR, PREFIX, POSTFIX));
    }
}
