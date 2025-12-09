package it.unibo.es1;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementation of the Logics interface.
 */
public class LogicsImpl implements Logics {

    //private static final String ERROR_MESSAGE = "Unimplemented method";
    private final List<Integer> buttons;

    /**
     * Constructor.
     *
     * @param size the size of the logics
     */
    public LogicsImpl(final int size) {
        this.buttons = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            this.buttons.add(0);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int size() {
        return this.buttons.size();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Integer> values() {
        return List.copyOf(this.buttons);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Boolean> enabledStates() {
        return this.buttons.stream()
        .map(b -> b < this.size())
        .toList();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hit(final int elem) {
        this.buttons.set(elem, this.buttons.get(elem) + 1);
        return this.buttons.get(elem);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String result() {
        return this.buttons.stream()
        .map(String::valueOf)
        .reduce((a, b) -> a.concat("|").concat(b))
        .orElse("error");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        return this.buttons.stream()
        .allMatch(b -> b.equals(this.buttons.size()));
    }
}
