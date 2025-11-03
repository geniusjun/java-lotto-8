package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import lotto.global.constants.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @DisplayName("정상적으로 Number 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(ints = {1, 45, 33, 20})
    void 숫자_생성_테스트(int input) {
        // given // when
        Number number = Number.valueOf(input);
        // then
        Assertions.assertThat(number).isNotNull();
    }

    @DisplayName("범위가 넘는 숫자를 입력하면 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, -1, 48, 100})
    void 숫자_범위_에러_테스트(int input) {
        // given // when // then
        assertThatThrownBy(() -> Number.valueOf(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_RANGE_ERROR.getMessage());
    }
}
