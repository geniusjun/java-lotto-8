package lotto.view.format;


import lotto.domain.result.WinningType;

public class StatisticsFormatter {
    public static final String HEADER = "당첨 통계";
    public static final String DIVIDER = "---";
    public static final String YIELD_TEMPLATE = "총 수익률은 %.1f%%입니다.";

    private StatisticsFormatter() { /* util class */ }

    public static String header() {
        return HEADER;
    }

    public static String divider() {
        return DIVIDER;
    }

    public static String formatCountLine(WinningType type, int count) {
        return type.label() + " - " + count + "개";
    }

    public static String formatYield(double yieldPercent) {
        return String.format(YIELD_TEMPLATE, yieldPercent);
    }
}
