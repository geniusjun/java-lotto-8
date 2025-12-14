package lotto.view;

import lotto.domain.Lottos;
import lotto.domain.Match;

public class OutputView {

    public void printBuyCost() {
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printLottoCount(int cost) {
        System.out.println(cost + "개를 구매했습니다.");
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printLottos(Lottos lottos) {
        for (int i = 0; i < lottos.getLottos().size(); i++) {
            System.out.print("[");
            for (int j = 0; j < 6; j++) {
                System.out.print(lottos.getLottos().get(i).getNumbers().get(j));
                if (j != 5) {
                    System.out.print(", ");
                }
            }
            System.out.println("]");
        }
    }

    public void printWinningMessage() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusMessage() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printMatchResult(Match match) {
        System.out.println("당첨 통계\n---");
        System.out.println("3개 일치 (5,000원) - " + match.getThree() + "개\n"
                + "4개 일치 (50,000원) - " + match.getFour() + "개\n"
                + "5개 일치 (1,500,000원) - " + match.getFive() + "개\n"
                + "5개 일치, 보너스 볼 일치 (30,000,000원) - " + match.getFiveBonus() + "개\n"
                + "6개 일치 (2,000,000,000원) - " + match.getSix() + "개");
    }
}
