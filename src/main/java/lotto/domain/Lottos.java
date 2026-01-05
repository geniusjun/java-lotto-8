package lotto.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(Cost cost) {
        List<Lotto> lottoBucket = makeLottos(cost);
        return new Lottos(lottoBucket);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    private static List<Lotto> makeLottos(Cost cost) {
        List<Lotto> lottoBucket = new ArrayList<>();
        for (int i = 0; i < cost.getPrice() / 1000; i++) {
            lottoBucket.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
        return lottoBucket;
    }

}
