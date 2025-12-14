package lotto.domain;

import java.util.List;

public class Lottos {
    private final List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = lottos;
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public Match compareLottos(Lotto winningLotto, int bonusNumber) {
        Match match = new Match();
        makeResult(winningLotto, bonusNumber, match);
        return match;
    }

    private void makeResult(Lotto winningLotto, int bonusNumber, Match match) {
        for (int i = 0; i < lottos.size(); i++) {
            int countMatch = lottos.get(i).countMatches(winningLotto);
            if (countMatch == 3) {
                match.plusThree();
            }
            if (countMatch == 4) {
                match.plusFour();
            }
            if (countMatch == 5 && !winningLotto.bonusContains(bonusNumber)) {
                match.plusFive();
            }
            if (countMatch == 5 && winningLotto.bonusContains(bonusNumber)) {
                match.plusFiveBonus();
            }
            if (countMatch == 6) {
                match.plusSix();
            }
        }
    }
}
