package lotto.view.format;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Cost;
import lotto.domain.WinningResult;
import lotto.domain.result.WinningType;

public class StatisticsFormatter {
    public static final String HEADER = "당첨 통계";
    public static final String DIVIDER = "---";
    public static final String YIELD_TEMPLATE = "총 수익률은 %.1f%%입니다.";

    private StatisticsFormatter() {
    }

    public static String formatYield(double yieldPercent) {
        return String.format(YIELD_TEMPLATE, yieldPercent);
    }

    public static String formatCountLine(WinningType type, int count) {
        return type.label() + " - " + count + "개";
    }

    /**
     * 최종 출력 라인 모음
     */
    public static List<String> lines(WinningResult result, Cost purchaseCost) {
        List<String> lines = new ArrayList<>();
        lines.addAll(headerLines());
        lines.addAll(countLines(result));
        lines.add(yieldLine(result, purchaseCost));
        return List.copyOf(lines);
    }

    /**
     * 헤더/구분선
     */
    private static List<String> headerLines() {
        return List.of(HEADER, DIVIDER);
    }

    /**
     * 등수별 카운트 라인
     */
    private static List<String> countLines(WinningResult result) {
        return result.displayOrder().stream()
                .map(type -> formatCountLine(type, result.countFor(type)))
                .toList();
    }

    /**
     * 수익률 라인
     */
    private static String yieldLine(WinningResult result, Cost purchaseCost) {
        double yield = result.yieldPercentage(purchaseCost.getPrice());
        return formatYield(yield);
    }
}
