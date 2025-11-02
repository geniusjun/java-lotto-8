package lotto.global;

import static lotto.global.constans.ErrorMessage.NUMBER_FORMAT_ERROR;

import java.util.Arrays;
import java.util.List;
import lotto.domain.Number;

public class Parser {
    public static int StringToInt(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NUMBER_FORMAT_ERROR.getMessage());
        }
    }

    public static List<Number> stringToNumbers(String s) {
        return Arrays.stream(s.split(","))
                .map(String::trim)
                .map(Parser::StringToInt)
                .map(Number::valueOf)
                .toList();
    }
}
