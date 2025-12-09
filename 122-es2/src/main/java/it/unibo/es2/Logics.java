package it.unibo.es2;

import java.util.List;

public interface Logics {
    /**
     * @return the size of the diagonal.
     */
    int size();

    /**
     * @return the grid.
     */
    List<List<Boolean>> grid();

    /**
     * @param <X> usually an integer for the X axis.
     * @param <Y> usually an integer for the Y axis.
     * @param pos The position pressed.
     * @return the new status of the button clicked.
     */
    <X, Y> boolean hit(Pair<X, Y> pos);

    /**
     * @return Checks if the program has to end.
     */
    boolean toQuit();
}
