package lotto.view;

import static lotto.global.ErrorMessage.BLANK_INPUT_ERROR;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String enterMessage() {
        return validateBlank(Console.readLine());
    }

    private static String validateBlank(String message) {
        if (message.isBlank()) {
            throw new IllegalArgumentException(BLANK_INPUT_ERROR.getMessage());
        }
        return message;
    }
}
