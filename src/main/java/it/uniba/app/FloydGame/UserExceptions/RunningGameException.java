package it.uniba.app.FloydGame.UserExceptions;

/**
 * Eccezione lanciata quando si tenta di istanziare
 * una nuova tabella nel mentre una è già istanziata.
 */
public class RunningGameException extends Exception {
    /**
     * Costruttore della classe.
     * @param message
     */
    public RunningGameException(final String message) {
        super(message);
    }
}
