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
    private final OutputView outputView = new OutputView();
    private final InputView inputView = new InputView();
    private final LottoFactory lottoFactory = new RandomLottoFactory();
    private final LottoService lottoService = new LottoService(lottoFactory);
    private final InputLoop inputLoop = new InputLoop(outputView);

    public LottoController lottoController() {
        return new LottoController(outputView, inputView, lottoService, inputLoop);
    }
}
