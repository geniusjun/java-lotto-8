package lotto.format;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.view.format.LottoFormatter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class LottoFormatterTest {

    @DisplayName("로또 여러 장을 한 줄 문자열 리스트로 반환한다")
    @Test
    void 로또_여러장_포맷_테스트() {
        // given
        Lottos lottos = Lottos.from(List.of(
                lottoOf(1, 2, 3, 4, 5, 6),
                lottoOf(7, 8, 9, 10, 11, 12),
                lottoOf(22, 33, 35, 41, 43, 45)
        ));

        // when
        List<String> lines = LottoFormatter.lottoLines(lottos);

        // then
        assertThat(lines).containsExactly(
                "[1, 2, 3, 4, 5, 6]",
                "[7, 8, 9, 10, 11, 12]",
                "[22, 33, 35, 41, 43, 45]"
        );
    }

    // 테스트 헬퍼 메서드
    private Lotto lottoOf(Integer... numbers) {
        return Lotto.from(Arrays.stream(numbers)
                .map(Number::valueOf)
                .toList());
    }
}
