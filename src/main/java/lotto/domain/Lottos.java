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

    public int[] compareLottos(WinningNumbers winningNumbers) {
        int[] result = new int[8];
        for (int i = 0; i < lottos.size(); i++) {
            result[compareLotto(lottos.get(i), winningNumbers)]++;
        }
        return result;
    }

    private int compareLotto(Lotto lotto, WinningNumbers winningNumbers) {
        int count = 0;
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (isEqualNumber(lotto.getNumbers().get(i), winningNumbers)) {
                count++;
            }
        }
        if (count == 5 && checkBonus(lotto, winningNumbers)) {
            count += 2;
        }
        return count;
    }

    private boolean isEqualNumber(int number, WinningNumbers winningNumbers) {
        for (int i = 0; i < winningNumbers.getLotto().getNumbers().size(); i++) {
            if (number == winningNumbers.getLotto().getNumbers().get(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean checkBonus(Lotto lotto, WinningNumbers winningNumbers) {
        for (int i = 0; i < lotto.getNumbers().size(); i++) {
            if (lotto.getNumbers().get(i) == winningNumbers.getBonusNumber()) {
                return true;
            }
        }
        return false;
    }

}
