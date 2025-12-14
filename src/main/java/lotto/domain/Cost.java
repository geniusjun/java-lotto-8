package lotto.domain;

import lotto.util.ErrorMessage;

public class Cost {
    private final int price;

    private Cost(int price) {
        this.price = price;
    }

    public int getCount() {
        return price / 1000;
    }

    public int getPrice() {
        return price;
    }

    public static Cost from(String price) {
        validateCost(price);
        return new Cost(Integer.parseInt(price));
    }

    private static void validateCost(String price) {
        try {
            if (Integer.parseInt(price) % 1000 != 0) {
                throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getMessage());
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_COST.getMessage());
        }
    }
}
