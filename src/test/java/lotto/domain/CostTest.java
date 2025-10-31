package lotto.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class CostTest {

    @DisplayName("정상적으로 Cost 객체를 생성한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "3000", "1000000"})
    void 비용_생성_테스트(String input) {
        // given// when
        Cost cost = Cost.of(input);
        // then
        Assertions.assertThat(cost).isNotNull();
    }
}
