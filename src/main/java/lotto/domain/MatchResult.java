package lotto.domain;

public record MatchResult(int matchedCount, boolean bonusMatched) {

    public static MatchResult of(int matchedCount, boolean bonusMatched) {
        return new MatchResult(matchedCount, bonusMatched);
    }
}
