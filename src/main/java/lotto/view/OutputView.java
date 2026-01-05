package lotto.view;

import lotto.domain.Lotto;
import lotto.util.Message;

public class OutputView {

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printlnMessage(String message) {
        System.out.println(message);
    }

    public void printLottoBuy(int price) {
        System.out.println(price / 1000 + Message.BUY_LOTTO_NUMBER.getMessage());
    }

    public void printBuyLotto(Lotto lotto) { // 뷰가 도메인 의존 덜하게끔 리팩토링 필요
        System.out.print("[");
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (i == lotto.getNumbers().size() - 1) {
                System.out.print(lotto.getNumbers().get(i));
                continue;
            }
            System.out.print(lotto.getNumbers().get(i) + ", ");
        }
        System.out.println("]");
    }

    public void printResult(int[] result) {
        System.out.println(Message.SHOW_RESULT.getMessage());
        System.out.println("3개 일치 (5,000원) - " + result[3] + "개"); // 리팩토링 필요
        System.out.println("4개 일치 (50,000원) - " + result[4] + "개");
        System.out.println("5개 일치 (1,500,000원) - " + result[5] + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000원) - " + result[7] + "개");
        System.out.println("6개 일치 (2,000,000,000원) - " + result[6] + "개");
    }

    public void printEarning(float earn) {
        System.out.println(String.format(Message.SHOW_EARNING.getMessage(), earn));
    }
}