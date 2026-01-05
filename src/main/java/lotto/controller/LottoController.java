package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Cost;
import lotto.util.Message;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Cost cost = makeCost();

        outputView.printlnMessage(Message.INPUT_WINNING_NUMBER.getMessage());
    }

    private Cost makeCost() {
        outputView.printlnMessage(Message.INPUT_BUY_LOTTO.getMessage());
        return repeatUntilSuccessWithReturn(() ->
                Cost.from(inputView.readLine()));
    }


    private <T> T repeatUntilSuccessWithReturn(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
