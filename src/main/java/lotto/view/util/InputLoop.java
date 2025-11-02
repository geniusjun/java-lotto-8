package lotto.view.util;

import java.util.function.Supplier;
import lotto.view.ui.OutputView;

public class InputLoop {
    private final OutputView out;

    public InputLoop(OutputView out) {
        this.out = out;
    }

    public <T> T ask(String prompt, Supplier<T> attempt) {
        while (true) {
            try {
                out.printlnMessage(prompt);
                return attempt.get();
            } catch (IllegalArgumentException e) {
                out.printlnMessage(e.getMessage());
            }
        }
    }

}
