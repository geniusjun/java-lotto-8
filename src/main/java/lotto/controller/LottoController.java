package lotto.controller;

import static lotto.global.constans.MessageType.BONUS_REQUEST_MESSAGE;
import static lotto.global.constans.MessageType.COST_REQUEST_MESSAGE;
import static lotto.global.constans.MessageType.WINNING_REQUEST_MESSAGE;

import lotto.application.LottoService;
import lotto.domain.Bonus;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Number;
import lotto.domain.WinningNumbers;
import lotto.domain.WinningResult;
import lotto.domain.result.WinningType;
import lotto.global.Parser;
import lotto.view.format.LottoFormatter;
import lotto.view.format.StatisticsFormatter;
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

        Cost cost = askCost();
        Lottos lottos = buy(cost);
        showLottos(lottos);

        WinningNumbers winningNumbers = askWinningNumbers();
        WinningResult winningResult = WinningResult.of(lottos, winningNumbers);
        printWinningStatistics(winningResult, cost);
    }

    private Cost askCost() {
        return loop.ask(COST_REQUEST_MESSAGE.getMessage(),
                () -> Cost.from(inputView.enterMessage()));
    }

    private Lottos buy(Cost cost) {
        return lottoService.buyLottos(cost);
    }

    private void showLottos(Lottos lottos) {
        outputView.printlnMessage(LottoFormatter.lottoCount(lottos.getSize()));
        outputView.printLottos(lottos);
    }

    private WinningNumbers askWinningNumbers() {
        Lotto winning = askWinningLotto();
        Bonus bonus = askBonus(winning);
        return WinningNumbers.of(winning, bonus);
    }

    private Lotto askWinningLotto() {
        return loop.ask(WINNING_REQUEST_MESSAGE.getMessage(),
                () -> Lotto.from(Parser.stringToNumbers(inputView.enterMessage())));
    }

    private Bonus askBonus(Lotto winning) {
        return loop.ask(BONUS_REQUEST_MESSAGE.getMessage(), () -> {
            Number number = Number.valueOf(Parser.stringToInt(inputView.enterMessage()));
            return Bonus.of(number, winning);
        });
    }

    private void printWinningStatistics(WinningResult result, Cost purchaseCost) {
        printStatisticsHeader();
        printCountLines(result);
        printYieldLine(result, purchaseCost);
    }

    private void printStatisticsHeader() {
        outputView.printlnMessage(StatisticsFormatter.header());
        outputView.printlnMessage(StatisticsFormatter.divider());
    }

    private void printCountLines(WinningResult result) {
        for (WinningType type : result.displayOrder()) {
            outputView.printlnMessage(
                    StatisticsFormatter.formatCountLine(type, result.countFor(type))
            );
        }
    }

    private void printYieldLine(WinningResult result, Cost purchaseCost) {
        double yieldPercent = result.yieldPercentage(purchaseCost.getPrice());
        outputView.printlnMessage(StatisticsFormatter.formatYield(yieldPercent));
    }
}
