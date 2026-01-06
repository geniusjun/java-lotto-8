package lotto.domain;

public class WinningNumbers {
    private Lotto lotto;
    private int bonusNumber;

    private WinningNumbers(Lotto lotto, int bonusNumber) {
        this.lotto = lotto;
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers from(Lotto lotto, int bonusNumber) {
        return new WinningNumbers(lotto, bonusNumber);
    }

    public Lotto getLotto() {
        return lotto;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }
}
