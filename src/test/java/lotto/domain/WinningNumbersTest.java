package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.result.MatchResult;
import lotto.domain.result.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningNumbersTest {

    private static List<Number> nums(int... arr) {
        return java.util.Arrays.stream(arr)
                .mapToObj(Number::valueOf)
                .toList();
    }

    @DisplayName("일치하는 개수와 보너스 일치 여부에 따른 결과 흐름 확인")
    @ParameterizedTest(name = "당첨:[1,2,3,4,5,6] 보너스:7 / {0} → {1}")
    @MethodSource("cases")
    void 비교_확인결과_테스트(List<Number> ticket, WinningType expected) {

        // given
        Lotto winning = Lotto.from(nums(1, 2, 3, 4, 5, 6));
        WinningNumbers winningNumbers = WinningNumbers.of(winning, Bonus.of(Number.valueOf(7), winning));

        // when
        MatchResult result = winningNumbers.compare(Lotto.from(ticket));
        WinningType actual = WinningType.from(result);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    // 테스트 헬퍼 메서드
    private static Stream<Arguments> cases() {
        return Stream.of(
                // 0~2개: NONE
                Arguments.of(nums(10, 11, 12, 13, 14, 15), WinningType.NONE),
                Arguments.of(nums(1, 10, 11, 12, 13, 14), WinningType.NONE),
                Arguments.of(nums(1, 2, 10, 11, 12, 13), WinningType.NONE),

                // 3개: 5등
                Arguments.of(nums(1, 2, 3, 10, 11, 12), WinningType.FIFTH),

                // 4개: 4등
                Arguments.of(nums(1, 2, 3, 4, 10, 11), WinningType.FOURTH),

                // 5개: 보너스 X → 3등
                Arguments.of(nums(1, 2, 3, 4, 5, 45), WinningType.THIRD),

                // 5개 + 보너스 일치 → 2등 (보너스=7)
                Arguments.of(nums(1, 2, 3, 4, 5, 7), WinningType.SECOND),

                // 6개: 1등
                Arguments.of(nums(1, 2, 3, 4, 5, 6), WinningType.FIRST)
        );
    }
}
