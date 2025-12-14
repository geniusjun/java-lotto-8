package lotto.util;

public enum ErrorMessage {
    ;

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}