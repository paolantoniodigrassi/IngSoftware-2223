package it.uniba.app.FloydGame.UserExceptions;

/**
 * Eccezione lanciata quando si tenta di cambiare il tempo di gioco
 * durante il gioco in corso.
 */
public class ChangingGameDurationException extends Exception {
    /**
     * Costruttore.
     */
    public ChangingGameDurationException() {
        super("\nImpossibile cambiare il tempo "
        + "di gioco durante il gioco in corso.\n\n");
    }
}
