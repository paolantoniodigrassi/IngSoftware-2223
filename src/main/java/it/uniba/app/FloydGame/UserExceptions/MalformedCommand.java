package it.uniba.app.FloydGame.UserExceptions;

/**
 * Eccezione lanciata quando il comando inserito
 *  dall'utente non inizia con una barra.
 */
public class MalformedCommand extends Exception {
    /**
     * Costruttore della classe.
     * @param message
     */
    public MalformedCommand(final String message) {
        super(message);
    }
}
