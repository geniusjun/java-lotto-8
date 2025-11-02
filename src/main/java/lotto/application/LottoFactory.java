package lotto.application;

import lotto.domain.Lotto;

@FunctionalInterface
public interface LottoFactory {
    Lotto create();
}
