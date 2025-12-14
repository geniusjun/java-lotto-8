package lotto.util;

public enum ErrorMessage {
    INVALID_COST("로또 구매 입력 형식이 잘못되었습니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    LOTTO_DUPLICATE("로또 숫자는 중복되지 않는 숫자여야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}