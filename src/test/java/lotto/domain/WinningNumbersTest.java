package lotto.domain;

import static lotto.global.constans.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class WinningNumbersTest {

    // 테스트 헬퍼 메서드
    private Lotto lottoOf(Integer... values) {
        return Lotto.from(Arrays.stream(values)
                .map(Number::valueOf)
                .toList());
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되지 않으면 WinningNumbers 생성에 성공한다")
    @Test
    void 당첨번호_보너스_중복_없으면_성공() {
        // given
        Lotto winning = lottoOf(1, 2, 3, 4, 5, 6);
        Number bonus = Number.valueOf(7);

        // when // then
        assertThatCode(() -> WinningNumbers.of(winning, bonus))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스 번호가 당첨 번호와 중복되면 예외가 발생한다")
    @Test
    void 당첨번호_보너스_중복시_예외() {
        // given
        Lotto winning = lottoOf(1, 2, 3, 4, 5, 6);
        Number bonus = Number.valueOf(6);

        // when // then
        assertThatThrownBy(() -> WinningNumbers.of(winning, bonus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
