package lotto.controller;

import static lotto.global.constans.MessageType.COST_REQUEST_MESSAGE;

import lotto.application.LottoFactory;
import lotto.domain.Cost;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoFactory lottoFactory;

    public LottoController(OutputView outputView, InputView inputView, LottoFactory lottoFactory) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoFactory = lottoFactory;
    }

    public void play() {
        Cost cost = requestCost();
    }

    private Cost requestCost() {
        try {
            outputView.printlnMessage(COST_REQUEST_MESSAGE.getMessage());
            return Cost.from(inputView.enterMessage());
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return requestCost();
        }
    }
}
