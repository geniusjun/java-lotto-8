package lotto.controller;

import static lotto.global.constans.MessageType.BONUS_REQUEST_MESSAGE;
import static lotto.global.constans.MessageType.COST_REQUEST_MESSAGE;
import static lotto.global.constans.MessageType.WINNING_REQUEST_MESSAGE;

import java.util.List;
import lotto.application.LottoService;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import lotto.global.Parser;
import lotto.view.InputView;
import lotto.view.OutputView;
import lotto.view.format.LottoFormatter;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;

    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
    }

    public void play() {
        Cost cost = requestCost();
        Lottos lottos = lottoBuy(cost);
        showLottos(lottos);
        WinningNumbers numbers = requestWinningNumbers();
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

    private Lottos lottoBuy(Cost cost) {
        try {
            return lottoService.buyLottos(cost);
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return lottoBuy(cost);
        }
    }

    private void showLottos(Lottos lottos) {
        outputView.printlnMessage(LottoFormatter.lottoCount(lottos.getSize()));
        outputView.printLottos(lottos);
    }

    private WinningNumbers requestWinningNumbers() {
        try {
            WinningNumbers numbers = WinningNumbers.of(requestWinningNumber(), requestBonusNumber());
            return numbers;
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return requestWinningNumbers();
        }
    }

    private Lotto requestWinningNumber() {
        outputView.printlnMessage(WINNING_REQUEST_MESSAGE.getMessage());
        List<Number> numbers = Parser.stringToNumbers(inputView.enterMessage());
        return Lotto.from(numbers);
    }

    private Number requestBonusNumber() {
        outputView.printlnMessage(BONUS_REQUEST_MESSAGE.getMessage());
        int number = Parser.StringToInt(inputView.enterMessage());
        return Number.valueOf(number);
    }
}
