package lotto.global.constants;

import static lotto.global.constants.NumberType.COST_UNIT;
import static lotto.global.constants.NumberType.LOTTO_SIZE;

public enum ErrorMessage {
    BLANK_INPUT_ERROR("빈 문자열이 입력되었습니다."),
    NUMBER_FORMAT_ERROR("숫자 형식이 아닙니다."),
    NUMBER_DUPLICATE_ERROR("중복되지 않는 숫자를 입력해주세요"),
    INVALID_UNIT_ERROR(String.format("%d원 단위의 숫자만 입력해주세요.", COST_UNIT.getValue())),
    INVALID_RANGE_ERROR("올바르지 않은 범위의 숫자입니다."),
    INVALID_LOTTO_SIZE_ERROR(String.format("%d개의 로또 번호를 입력해주세요", LOTTO_SIZE.getValue())),
    BONUS_NUMBER_DUPLICATE_ERROR("보너스 번호는 입력하신 당첨 번호와 중복되지 않아야 합니다.");

    private static final String PREFIX = "[ERROR] ";
    private String message;

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
