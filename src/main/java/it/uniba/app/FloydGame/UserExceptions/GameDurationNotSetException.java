package it.uniba.app.FloydGame.UserExceptions;

/**
 * Questa classe rappresenta un'eccezione
 * che viene lanciata quando si tenta di iniziare
 * a giocare senza aver prima impostato la durata
 * del gioco.
 */
public class GameDurationNotSetException extends Exception {
    /**
     * Costruttore della classe.
     */
    public GameDurationNotSetException() {
        super("\n--- Comando non valido: "
        + "'/tempo' deve essere succeduto da un numero! ---\n\n");
    }
}
