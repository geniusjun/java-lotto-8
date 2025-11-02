package lotto.domain;

public class WinningNumbers {
    private final Lotto winning;
    private final Number bonus;

    private WinningNumbers(Lotto winning, Number bonus) {
        this.winning = winning;
        this.bonus = bonus;
    }

    public static WinningNumbers of(Lotto winning, Number bonus) {
        return new WinningNumbers(winning, bonus);
    }
}
