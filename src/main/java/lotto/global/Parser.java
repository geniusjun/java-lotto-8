package lotto.global;

import static lotto.global.constans.ErrorMessage.NUMBER_FORMAT_ERROR;

public class Parser {
    public static int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
        }
    }
}
