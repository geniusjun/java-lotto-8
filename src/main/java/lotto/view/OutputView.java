package lotto.view;

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
}
