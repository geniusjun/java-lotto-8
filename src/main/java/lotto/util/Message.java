package lotto.util;

public enum Message {
    INPUT_BUY_LOTTO("구입금액을 입력해 주세요.");

    private String message;

    Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}