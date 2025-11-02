package lotto.domain;

public class WinningNumbers {
    private final Lotto winning;
    private final Bonus bonus;

    private WinningNumbers(Lotto winning, Bonus bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public static WinningNumbers of(Lotto winning, Bonus bonus) {
        return new WinningNumbers(winning, bonus);
    }

}
