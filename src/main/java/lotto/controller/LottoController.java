package lotto.controller;

import static lotto.global.constans.MessageType.COST_REQUEST_MESSAGE;
import static lotto.global.constans.MessageType.LOTTO_COUNT_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import lotto.application.LottoService;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.view.InputView;
import lotto.view.OutputView;

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
            return makeLottos(cost);
        } catch (IllegalArgumentException e) {
            outputView.printlnMessage(e.getMessage());
            return lottoBuy(cost);
        }
    }

    private Lottos makeLottos(Cost cost) {
        outputView.printlnMessage(String.format(LOTTO_COUNT_MESSAGE.getMessage(), cost.getCount()));
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cost.getCount(); i++) {
            //lottos.add(lottoFactory.create());
        }
        return Lottos.from(lottos);
    }
}
