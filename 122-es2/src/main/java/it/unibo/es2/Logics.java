package it.unibo.es2;

/**
 * Ignored.
 */
public interface Logics {

    /**
     * Ignored.
     * 
     * @param <X> Usually an integer for the X axis.
     * @param <Y> Usually an integer for the Y axis.
     * @param pos The position pressed.
     * @return The new status of the button clicked.
     */
    void hit(Pair<Integer, Integer> pos);

    /**
     * Ignored.
     * @return Checks if the program has to end.
     */
    boolean toQuit();
}
