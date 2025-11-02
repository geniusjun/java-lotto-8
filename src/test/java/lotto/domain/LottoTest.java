package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
        List<Number> numbers = List.of(
                Number.valueOf(1),
                Number.valueOf(8),
                Number.valueOf(11),
                Number.valueOf(31),
                Number.valueOf(41),
                Number.valueOf(42));
        // then
        Assertions.assertThatCode(() ->
                Lotto.from(numbers)).doesNotThrowAnyException();
    }

    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(6),
                Number.valueOf(7))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_SIZE_ERROR.getMessage());

    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> Lotto.from(List.of(
                Number.valueOf(1),
                Number.valueOf(2),
                Number.valueOf(3),
                Number.valueOf(4),
                Number.valueOf(5),
                Number.valueOf(5))))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());
    }
    // TODO: 추가 기능 구현에 따른 테스트 코드 작성
}
