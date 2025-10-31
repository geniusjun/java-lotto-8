package lotto.controller;

import static lotto.global.MessageType.COST_REQUEST_MESSAGE;

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
        outputView.printlnMessage(COST_REQUEST_MESSAGE.getMessage());
        int price = Integer.parseInt(inputView.enterMessage());
    }
}
