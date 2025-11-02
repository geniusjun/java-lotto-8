package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WinningNumbersTest {

    private Lotto lottoOf(Integer... v) {
        return Lotto.from(Arrays.stream(v).map(Number::valueOf).toList());
    }

    @DisplayName("당첨번호+보너스 조립에 성공한다")
    @Test
    void 조립_성공() {
        Lotto winning = lottoOf(1, 2, 3, 4, 5, 6);
        Bonus bonus = Bonus.of(Number.valueOf(7), winning);

        WinningNumbers winningNumbers = WinningNumbers.of(winning, bonus);

        assertThat(winningNumbers.winning()).isEqualTo(winning);
        assertThat(winningNumbers.bonus()).isEqualTo(bonus);
    }
}
