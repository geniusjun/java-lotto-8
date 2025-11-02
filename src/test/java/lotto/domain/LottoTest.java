package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import lotto.global.constans.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

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
        // given // when // then
        assertThatThrownBy(() -> Lotto.from(numbersOf(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.INVALID_LOTTO_SIZE_ERROR.getMessage());
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다")
    @Test
    void 로또_번호_중복_예외() {
        // given // when // then
        assertThatThrownBy(() -> Lotto.from(numbersOf(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(ErrorMessage.NUMBER_DUPLICATE_ERROR.getMessage());
    }

    @DisplayName("contains 동작 확인")
    @ParameterizedTest(name = "[contains] {0} 에 {1} 포함? → {2}")
    @MethodSource("containsArgs")
    void contains_동작(List<Number> base, int probe, boolean expected) {
        // given
        Lotto lotto = Lotto.from(base);
        // when // then
        assertThat(lotto.contains(Number.valueOf(probe))).isEqualTo(expected);
    }

    // contains 테스트 헬퍼 메서드
    static Stream<Arguments> containsArgs() {
        return Stream.of(
                Arguments.of(numbersOf(1, 2, 3, 4, 5, 6), 1, true),
                Arguments.of(numbersOf(1, 2, 3, 4, 5, 6), 6, true),
                Arguments.of(numbersOf(10, 11, 12, 13, 14, 15), 9, false),
                Arguments.of(numbersOf(40, 41, 42, 43, 44, 45), 45, true),
                Arguments.of(numbersOf(7, 8, 9, 10, 11, 12), 1, false)
        );
    }

    @DisplayName("countMatches(other) 교집합 크기 계산 (대칭성 포함)")
    @ParameterizedTest(name = "[countMatches] {0} ∩ {1} = {2}")
    @MethodSource("matchArgs")
    void countMatches_교집합(List<Number> a, List<Number> b, int expected) {
        Lotto A = Lotto.from(a);
        Lotto B = Lotto.from(b);
        assertThat(A.countMatches(B)).isEqualTo(expected);
        assertThat(B.countMatches(A)).isEqualTo(expected); // 대칭성 보장
    }

    // countMatches 테스트 헬퍼 메서드
    static Stream<Arguments> matchArgs() {
        return Stream.of(
                Arguments.of(numbersOf(1, 2, 3, 4, 5, 6), numbersOf(1, 2, 3, 7, 8, 9), 3),
                Arguments.of(numbersOf(1, 2, 3, 4, 5, 6), numbersOf(4, 5, 6, 7, 8, 9), 3),
                Arguments.of(numbersOf(10, 11, 12, 13, 14, 15), numbersOf(1, 2, 3, 4, 5, 6), 0),
                Arguments.of(numbersOf(40, 41, 42, 43, 44, 45), numbersOf(41, 42, 43, 44, 45, 1), 5),
                Arguments.of(numbersOf(1, 3, 5, 7, 9, 11), numbersOf(2, 4, 6, 8, 10, 12), 0)
        );
    }

    // 테스트 헬퍼 메서드
    private static List<Number> numbersOf(Integer... values) {
        return Arrays.stream(values)
                .map(Number::valueOf)
                .toList();
    }

}
