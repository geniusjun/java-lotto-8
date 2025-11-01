package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.global.constans.ErrorMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 48, 100})
    void 숫자_범위_에러_테스트(int input) {
        // given // when // then
        assertThatThrownBy(() -> Number.valueOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RANGE_ERROR.getMessage());
    }
}
