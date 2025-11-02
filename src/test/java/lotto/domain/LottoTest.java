package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import lotto.global.constans.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {

    @DisplayName("로또 객체 생성에 성공한다(서로 다른 6개, 1~45)")
    @Test
    void 로또_생성_성공() {
        // given // when
        List<Number> numbers = numbersOf(1, 8, 11, 31, 41, 42);

        // then
        Assertions.assertThatCode(() -> Lotto.from(numbers))
                .doesNotThrowAnyException();
    }

    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다")
    @Test
    void 로또_번호_개수_초과_예외() {
        assertThatThrownBy(() -> Lotto.from(numbersOf(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void 로또_번호_중복_예외() {
        assertThatThrownBy(() -> Lotto.from(numbersOf(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());
    }

    // 테스트 헬퍼 메서드
    private List<Number> numbersOf(Integer... values) {
        return Arrays.stream(values)
                .map(Number::valueOf)
                .toList();
    }

}
