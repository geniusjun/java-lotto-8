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
}