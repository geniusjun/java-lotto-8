package lotto.controller;

import java.util.function.Supplier;
import lotto.domain.Cost;
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
        Cost cost = askCost();
    }

    private Cost askCost() {
        outputView.printBuyCost();
        return repeatUntilSuccessWithReturn(
                () -> Cost.from(inputView.enterMessage()));
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
