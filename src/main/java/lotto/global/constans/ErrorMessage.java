package lotto.global.constans;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NUMBER_FORMAT_ERROR("숫자 형식이 아닙니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
