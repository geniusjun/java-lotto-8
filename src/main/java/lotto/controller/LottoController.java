package lotto.controller;

import static lotto.global.MessageType.COST_REQUEST_MESSAGE;

import lotto.view.OutputView;

public class LottoController {
    private final OutputView outputView;

    public LottoController(OutputView outputView) {
        this.outputView = outputView;
    }

    public void play() {
        outputView.printlnMessage(COST_REQUEST_MESSAGE.getMessage());
    }
}
