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

    public int getPrice() {
        return price;
    }

    public float getEarning(int[] result) {
        int sum = 0;
        sum = result[3] * Match.THREE.getMoney() + result[4] * Match.FOUR.getMoney()
                + result[5] * Match.FIVE.getMoney() + result[6] * Match.SIX.getMoney()
                + result[7] * Match.FIVE_BONUS.getMoney();
        return (float) sum / price * 100;
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
