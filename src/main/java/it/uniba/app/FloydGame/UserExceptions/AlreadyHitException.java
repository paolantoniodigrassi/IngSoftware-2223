package it.uniba.app.FloydGame.UserExceptions;

/**
 * Classe che si occupa di gestire l'eccezione AlreadyHit.
 */
public class AlreadyHitException extends Exception {
    /**
     * Costruttore di AlreadyHit.
     * @param message Messaggio di errore.
     */
    public AlreadyHitException(final String message) {
        super(message);
    }
}
