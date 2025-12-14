package lotto.view;

import lotto.domain.Lottos;

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
}
