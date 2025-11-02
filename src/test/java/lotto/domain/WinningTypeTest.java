package lotto.domain;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.result.MatchResult;
import lotto.domain.result.WinningType;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class WinningTypeTest {

    @DisplayName("매칭 개수/보너스 조합에 따른 결과 결정")
    @ParameterizedTest(name = "matched={0}, bonus={1} → {2}")
    @CsvSource({
            "0,false,NONE",
            "2,false,NONE",
            "3,false,FIFTH",
            "4,false,FOURTH",
            "5,false,THIRD",
            "5,true,SECOND",
            "6,false,FIRST",
            "6,true,FIRST"
    })
    void 결과_테스트(int matched, boolean bonus, WinningType expected) {
        // given // when
        MatchResult result = MatchResult.of(matched, bonus);

        // then
        assertThat(WinningType.from(result)).isEqualTo(expected);
    }
}
