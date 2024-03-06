package it.uniba.app.FloydGame.UserExceptions;

/**
 * Eccezione lanciata quando i comandi di
 * selezione grandezza e mostra gruiglia vengono
 * evocati senza chiamare il costruttore.
 */
public class NullTableException extends Exception {
    /**
     * Costruttore della classe.
     * @param message
     */
    public NullTableException(final String message) {
        super(message);
    }
}

