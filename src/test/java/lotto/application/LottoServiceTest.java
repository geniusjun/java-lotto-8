package lotto.application;

import static org.assertj.core.api.Assertions.assertThat;

import lotto.domain.Cost;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class LottoServiceTest {
    private LottoService lottoService;

    @BeforeEach
    void setUp() {
        lottoService = new LottoService(new RandomLottoFactory());
    }

    @DisplayName("구매 금액에 맞는 개수의 로또를 생성한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000:1", "10000:10", "35000:35", "59000:59"}, delimiter = ':')
    void 금액에_맞는_로또_생성_테스트(String price, int count) {
        // given
        Cost cost = Cost.from(price);

        // when // then
        assertThat(lottoService.buyLottos(cost)
                .getStream()
                .count())
                .isEqualTo(count);
    }
}
