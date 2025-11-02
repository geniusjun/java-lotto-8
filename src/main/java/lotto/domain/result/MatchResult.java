package lotto.domain.result;

public record MatchResult(int matchedCount, boolean bonusMatched) {

    public static MatchResult of(int matchedCount, boolean bonusMatched) {
        return new MatchResult(matchedCount, bonusMatched);
    }
}
