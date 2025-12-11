package it.unibo.es2;

import java.util.HashMap;
import java.util.Map;

public class LogicsImpl implements Logics {

    private final Map<Pair<Integer, Integer>, Boolean> grid;
    private final int size;

    public LogicsImpl(final int diagonalSize) {
        this.size = diagonalSize;
        this.grid = new HashMap<>();
        for (int i = 0; i < this.size; i++) {
            for (int j = 0 ; j < this.size; j++) {
                grid.put(new Pair<>(i, j), false);
            }
        } 
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void hit(Pair<Integer, Integer> pos) {
        this.grid.put(pos, !this.grid.get(pos));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean toQuit() {
        Boolean cols = this.grid.entrySet()
        .stream()
        .map(e -> new Pair<Integer, Boolean>(e.getKey().x(), e.getValue()))
        .collect(
        () -> new HashMap<Integer, Boolean>(), 
        (a, b) -> a.merge(b.x(), b.y(), (first, second) -> first && second), 
        HashMap::putAll)
        .values()
        .contains(true);

        Boolean raws = this.grid.entrySet()
        .stream()
        .map(e -> new Pair<Integer, Boolean>(e.getKey().y(), e.getValue()))
        .collect(
        () -> new HashMap<Integer, Boolean>(), 
        (a, b) -> a.merge(b.x(), b.y(), (first, second) -> first && second), 
        HashMap::putAll)
        .values()
        .contains(true);
        
        return cols || raws;
    }
}
