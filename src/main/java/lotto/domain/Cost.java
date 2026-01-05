package lotto.domain;

import lotto.util.ErrorMessage;

public class Cost {
    private int price;

    private Cost(int price) {
        this.price = price;
    }

    public static Cost from(String input) {
        return new Cost(validateInput(input));
    }

    private static int validateInput(String input) {
        try {
            return validatePrice(Integer.parseInt(input));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getMessage());
        }
    }

    private static int validatePrice(int price) {
        if (price % 1000 != 0) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getMessage());
        }
        return price;
    }
}
