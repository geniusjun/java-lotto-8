package lotto.application;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Cost;
import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class LottoService {
    private final LottoFactory lottoFactory;

    public LottoService(LottoFactory lottoFactory) {
        this.lottoFactory = lottoFactory;
    }

    public Lottos buyLottos(Cost cost) {
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < cost.getCount(); i++) {
            lottos.add(lottoFactory.create());
        }
        return Lottos.from(lottos);
    }
}
