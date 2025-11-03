package lotto.domain.result;

import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.WinningNumbers;

public class WinningResult {
    private static final List<WinningType> DISPLAY_ORDER = List.of(
            WinningType.FIFTH, WinningType.FOURTH, WinningType.THIRD,
            WinningType.SECOND, WinningType.FIRST
    );

    private final EnumMap<WinningType, Integer> countsByType = new EnumMap<>(WinningType.class);

    private WinningResult() {
        for (WinningType type : WinningType.values()) {
            countsByType.put(type, 0);
        }
    }

    /**
     * Lottos와 당첨번호를 비교해 집계 생성
     */
    public static WinningResult of(Lottos purchasedLottos, WinningNumbers drawnNumbers) {
        WinningResult aggregated = new WinningResult();
        purchasedLottos.getStream()
                .map(lotto -> decideType(lotto, drawnNumbers))
                .forEach(aggregated::increment);
        return aggregated;
    }

    /**
     * 로또 한 장의 당첨 등급 결정
     */
    private static WinningType decideType(Lotto lotto, WinningNumbers drawnNumbers) {
        return WinningType.from(drawnNumbers.compare(lotto));
    }

    private void increment(WinningType type) {
        countsByType.put(type, countsByType.get(type) + 1);
    }

    public int countFor(WinningType type) {
        return countsByType.get(type);
    }

    public long totalPrizeAmount() {
        long sum = 0;
        for (Map.Entry<WinningType, Integer> entry : countsByType.entrySet()) {
            sum += (long) entry.getKey().prizeAmount() * entry.getValue();
        }
        return sum;
    }

    /**
     * 구매 금액 대비 수익률(%)
     */
    public double yieldPercentage(long totalPurchaseAmount) {
        if (totalPurchaseAmount == 0) {
            return 0.0;
        }
        return (double) totalPrizeAmount() / totalPurchaseAmount * 100.0;
    }

    /**
     * 요구 출력 순서 고정
     */
    public List<WinningType> displayOrder() {
        return DISPLAY_ORDER;
    }
}
