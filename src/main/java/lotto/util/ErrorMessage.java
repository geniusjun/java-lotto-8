package lotto.util;

public enum ErrorMessage {
    INVALID_COST("로또 구입 금액의 형식이 잘못되었습니다."),
    INVALID_LOTTO_SIZE("로또 번호는 6개여야 합니다."),
    INVALID_LOTTO_DUPLICATE("로또 번호는 중복되면 안됩니다."),
    INVALID_LOTTO_NUMBER("로또 숫자는 1이상 45이하여야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}