package lotto.view.ui;

import java.util.List;
import lotto.domain.Lottos;
import lotto.view.format.LottoFormatter;

public class OutputView {

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printLottos(Lottos lottos) {
        printLines(LottoFormatter.lottoLines(lottos));
    }

    public void printLines(List<String> lines) {
        lines.forEach(this::printlnMessage);
    }
}
