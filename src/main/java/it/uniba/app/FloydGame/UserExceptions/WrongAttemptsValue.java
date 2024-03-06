package it.uniba.app.FloydGame.UserExceptions;

/**
 * Eccezione personalizzata per gestire un valore errato dei tentativi.
 */
public class WrongAttemptsValue extends Exception {

    /**
     * Costruttore della classe.
     * @param message
     */
    public WrongAttemptsValue(final String message) {
        super(message);
    }
}
