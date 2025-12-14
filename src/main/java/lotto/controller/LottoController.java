package lotto.controller;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
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
        Lottos lottos = makeLottos(cost);
        outputView.printLottos(lottos);
        Lotto winningLotto = askWinningLotto();
        int bonusNumber = askBonusNumber();
    }

    private Cost askCost() {
        outputView.printBuyCost();
        return repeatUntilSuccessWithReturn(
                () -> Cost.from(inputView.enterMessage()));
    }

    private Lottos makeLottos(Cost cost) {
        outputView.printLottoCount(cost.getCount());
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cost.getCount(); i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            numbers.sort(Comparator.naturalOrder());
            lottos.add(Lotto.from(numbers));
        }
        return Lottos.from(lottos);
    }

    private Lotto askWinningLotto() {
        outputView.printWinningMessage();
        return repeatUntilSuccessWithReturn(
                () -> Lotto.from(makeWinningLotto()));
    }

    private List<Integer> makeWinningLotto() {
        List<Integer> winningLotto = new ArrayList<>();
        String[] input = inputView.enterMessage().split(",");
        for (int i = 0; i < input.length; i++) {
            winningLotto.add(Integer.parseInt(input[i]));
        }
        return winningLotto;
    }

    private int askBonusNumber() {
        outputView.printBonusMessage();
        return Integer.parseInt(inputView.enterMessage());
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
