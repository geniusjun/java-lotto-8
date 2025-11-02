package lotto.config;

import lotto.application.LottoFactory;
import lotto.application.LottoService;
import lotto.application.RandomLottoFactory;
import lotto.controller.LottoController;
import lotto.view.ui.InputView;
import lotto.view.ui.OutputView;
import lotto.view.util.InputLoop;

/**
 * 애플리케이션 객체의 의존 관계를 설정하고 조립하는 DI 컨테이너
 */
public class AppConfig {
    public LottoController lottoController() {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        LottoFactory lottoFactory = new RandomLottoFactory();
        LottoService lottoService = new LottoService(lottoFactory);
        InputLoop inputLoop = new InputLoop(outputView);
        return new LottoController(outputView, inputView, lottoService, inputLoop);
    }
}
