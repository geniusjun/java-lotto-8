package lotto.domain.result;

import java.util.function.Predicate;

public enum WinningType {
    NONE(0, "", result -> result.matchedCount() < 3),
    FIFTH(5_000, "3개 일치 (5,000원)", exactly(3)),
    FOURTH(50_000, "4개 일치 (50,000원)", exactly(4)),
    THIRD(1_500_000, "5개 일치 (1,500,000원)", result -> result.matchedCount() == 5 && !result.bonusMatched()),
    SECOND(30_000_000, "5개 일치, 보너스 볼 일치 (30,000,000원)", result -> result.matchedCount() == 5 && result.bonusMatched()),
    FIRST(2_000_000_000, "6개 일치 (2,000,000,000원)", exactly(6));

    private final int prizeAmount;
    private final String label;
    private final Predicate<MatchResult> rule;

    WinningType(int prizeAmount, String label, Predicate<MatchResult> rule) {
        this.prizeAmount = prizeAmount;
        this.label = label;
        this.rule = rule;
    }

    public int prizeAmount() {
        return prizeAmount;
    }

    public String label() {
        return label;
    }

    public boolean printable() {
        return this != NONE;
    }

    /**
     * 주어진 비교 결과에 가장 먼저 부합하는 등수를 반환한다. - 각 상수에 저장된 rule.test(result)를 순서대로 평가한다. - 어느 등수에도 해당하지 않으면 NONE을 반환한다.
     */
    public static WinningType from(MatchResult result) {
        for (WinningType type : values()) {
            if (type.rule.test(result)) {
                return type;
            }
        }
        return NONE;
    }

    private static Predicate<MatchResult> exactly(int n) {
        return result -> result.matchedCount() == n;
    }
}
