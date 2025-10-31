package lotto;

import lotto.application.RandomLottoFactory;
import lotto.controller.LottoController;
import lotto.view.InputView;
import lotto.view.OutputView;

public class Application {
    public static void main(String[] args) {
        OutputView outputView = new OutputView();
        InputView inputView = new InputView();
        RandomLottoFactory lottoFactory = new RandomLottoFactory();

        LottoController lottoController = new LottoController(outputView, inputView, lottoFactory);
        lottoController.play();
    }
}
