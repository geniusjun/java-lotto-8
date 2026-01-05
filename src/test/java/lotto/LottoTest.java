package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.domain.Lotto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoTest {

    @DisplayName("정상적으로 Lotto 객체를 생성한다.")
    @Test
    void 로또_생성_테스트() {
        // given // when
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        // then
        Assertions.assertThat(lotto).isNotNull();
    }


    @Test
    void 로또_번호의_개수가_6개가_넘어가면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void 로또_번호에_중복된_숫자가_있으면_예외가_발생한다() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호가 1미만 45초과일경우 에러가 발생한다")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6})
    void 로또_번호가_범위를_넘어서면_에러가_발생한다(int input) {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 55)))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
