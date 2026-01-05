package lotto.util;

public enum Message {
    INPUT_BUY_LOTTO("구입금액을 입력해 주세요."),
    BUY_LOTTO_NUMBER("개를 구매했습니다"),
    INPUT_WINNING_NUMBER("당첨 번호를 입력해 주세요."),
    INPUT_BONUS_NUMBER("보너스 번호를 입력해 주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}