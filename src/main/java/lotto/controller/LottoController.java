package lotto.controller;

import static lotto.global.constans.MessageType.COST_REQUEST_MESSAGE;

import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;

    public LottoController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void play() {
        requestCost();
    }

    private int requestCost() {
        try {
            outputView.printlnMessage(COST_REQUEST_MESSAGE.getMessage());
            return Integer.parseInt(inputView.enterMessage());
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return requestCost();
        }
    }
}
