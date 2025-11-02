package lotto.domain;

import java.util.List;
import java.util.stream.Stream;

public class Lottos {
    private List<Lotto> lottos;

    private Lottos(List<Lotto> lottos) {
        this.lottos = List.copyOf(lottos);
    }

    public static Lottos from(List<Lotto> lottos) {
        return new Lottos(lottos);
    }

    public Stream<Lotto> getStream() {
        return lottos.stream();
    }
}
