package lotto.domain;

import lotto.global.constans.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CostTest {

    @DisplayName("정상적으로 Cost 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "1000000"})
    void 비용_생성_테스트(String input) {
        // given // when
        Cost cost = Cost.from(input);
        // then
        Assertions.assertThat(cost).isNotNull();
    }

    @DisplayName("1000원 단위가 아닌 비용을 입력하면 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1100", "10500", "1000001"})
    void 비용_생성_실패_테스트(String input) {
        // given // when // then
        Assertions.assertThatThrownBy(() -> {
                    Cost.from(input);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_UNIT_ERROR.getMessage());
    }

}
