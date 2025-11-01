package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.global.constans.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class LottoTest {
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
