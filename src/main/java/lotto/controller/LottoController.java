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
import lotto.view.format.LottoFormatter;
import lotto.view.ui.InputView;
import lotto.view.ui.OutputView;
import lotto.view.util.InputLoop;

public class LottoController {
    private final OutputView outputView;
    private final InputView inputView;
    private final LottoService lottoService;
    private final InputLoop loop;

    public LottoController(OutputView outputView, InputView inputView, LottoService lottoService, InputLoop loop) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.lottoService = lottoService;
        this.loop = loop;
    }

    public void play() {
        Cost cost = requestCost();
        Lottos lottos = lottoBuy(cost);
        showLottos(lottos);
        WinningNumbers numbers = WinningNumbers.of(requestWinningNumber(), requestBonusNumber());
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


    private Lotto requestWinningNumber() {
        try {
            outputView.printlnMessage(WINNING_REQUEST_MESSAGE.getMessage());
            List<Number> numbers = Parser.stringToNumbers(inputView.enterMessage());
            return Lotto.from(numbers);
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return requestWinningNumber();
        }
    }

    private Number requestBonusNumber() {
        try {
            outputView.printlnMessage(BONUS_REQUEST_MESSAGE.getMessage());
            int number = Parser.StringToInt(inputView.enterMessage());
            return Number.valueOf(number);
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return requestBonusNumber();
        }

    }
}
