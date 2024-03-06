package it.uniba.app.FloydGame.UserExceptions;

/**
 * Classe che fornisce un'eccezione.
 */
public class GameNotStartedException extends Exception {

    /**
     * Costruttore con parametro.
     * @param message
     */
    public GameNotStartedException(final String message) {
        super(message);
    }

    /**
     * Costruttore senza parametro.
     */
    public GameNotStartedException() {
        super("\n--- Comando non valido: "
            + "nessuna partita in corso. ---\n\n");
    }
}
