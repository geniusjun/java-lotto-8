package lotto.util;

public enum ErrorMessage {
    INVALID_COST("로또 구입 금액의 형식이 잘못되었습니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}