package lotto.domain;

import static lotto.global.constants.ErrorMessage.BONUS_NUMBER_DUPLICATE_ERROR;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BonusTest {
    private Lotto lottoOf(Integer... v) {
        return Lotto.from(Arrays.stream(v).map(Number::valueOf).toList());
    }

    @DisplayName("보너스가 당첨번호와 중복되지 않으면 생성 성공")
    @Test
    void 보너스_생성_성공() {
        Lotto winning = lottoOf(1, 2, 3, 4, 5, 6);
        Number n = Number.valueOf(7);

        assertThatCode(() -> Bonus.of(n, winning))
                .doesNotThrowAnyException();
    }

    @DisplayName("보너스가 당첨번호와 중복되면 예외")
    @Test
    void 보너스_중복_예외() {
        Lotto winning = lottoOf(1, 2, 3, 4, 5, 6);
        Number n = Number.valueOf(6);

        assertThatThrownBy(() -> Bonus.of(n, winning))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(BONUS_NUMBER_DUPLICATE_ERROR.getMessage());
    }
}
