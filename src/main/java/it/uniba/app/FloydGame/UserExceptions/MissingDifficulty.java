package it.uniba.app.FloydGame.UserExceptions;

/**
 * Classe che si occupa di gestire l'eccezione MissingDifficulty.
 */
public class MissingDifficulty extends Exception {
    /**
     * Costruttore di MissingDifficulty.
     */
    public MissingDifficulty() {
        super("\nNon hai impostato la difficoltà!\n\n");
    }
}
