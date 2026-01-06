package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;
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
        Lottos lottos = Lottos.from(cost);

        showBuyLottos(cost, lottos);
        WinningNumbers winningNumbers = WinningNumbers.from(makeWinningLotto(), makeBonusNumber());

        int[] result = makeResult(lottos, winningNumbers);
        showResult(result, cost);

    }

    private Cost makeCost() {
        outputView.printlnMessage(Message.INPUT_BUY_LOTTO.getMessage());
        return repeatUntilSuccessWithReturn(() ->
                Cost.from(inputView.readLine()));
    }

    private void showBuyLottos(Cost cost, Lottos lottos) {
        outputView.printLottoBuy(cost.getPrice());
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            outputView.printBuyLotto(lottos.getLottos().get(i));
        }
    }

    private List<Integer> makeList(String input) {
        List<Integer> lotto = new ArrayList<>();
        String[] inputs = input.split(",");
        for (String s : inputs) {
            lotto.add(Integer.parseInt(s));
        }
        return lotto;
    }

    private Lotto makeWinningLotto() {
        outputView.printlnMessage(Message.INPUT_WINNING_NUMBER.getMessage());
        return repeatUntilSuccessWithReturn(() ->
                new Lotto(makeList(inputView.readLine())));
    }

    private int makeBonusNumber() {
        outputView.printlnMessage(Message.INPUT_BONUS_NUMBER.getMessage());
        return Integer.parseInt(inputView.readLine());
    }

    private int[] makeResult(Lottos lottos, WinningNumbers winningNumbers) {
        return lottos.compareLottos(winningNumbers);
    }

    private void showResult(int[] result, Cost cost) {
        outputView.printResult(result);
        outputView.printEarning(cost.getEarning(result));
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
