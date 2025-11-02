package lotto.view.ui;

import java.util.List;
import lotto.domain.Lottos;
import lotto.view.format.LottoFormatter;

public class OutputView {

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printLottos(Lottos lottos) {
        List<String> lines = LottoFormatter.lottoLines(lottos);
        lines.forEach(System.out::println);
    }

    public void printLines(List<String> lines) {
        lines.forEach(this::printlnMessage);
    }
}
