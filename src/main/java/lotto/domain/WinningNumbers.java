package lotto.domain;

import lotto.domain.result.MatchResult;

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

    public MatchResult compare(Lotto lotto) {
        int count = lotto.countMatches(this.winning);
        boolean bonus = lotto.contains(this.bonus.getValue());
        return MatchResult.of(count, bonus);
    }
}
