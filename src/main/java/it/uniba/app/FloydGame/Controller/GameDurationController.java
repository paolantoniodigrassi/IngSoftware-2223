package it.uniba.app.FloydGame.Controller;


/**
 * <<Control>> Questa classe rappresenta un controller
 * per la durata del gioco.
 */
public final class GameDurationController {
    /**
     * Costruttore privato per impedire l'istanziazione della classe.
     */
    private GameDurationController() {
        throw new AssertionError("Questa classe non è istanziabile.");
    }

    /**
     * Imposta la durata del gioco.
     * @param gameDuration La durata del gioco in minuti.
     */
    public static void setGameDuration(final int gameDuration) {
        if (gameDuration < 0) {
            System.out.print("\nIl tempo di gioco"
            + " non può essere negativo.\n");
        } else if (gameDuration == 0) {
            System.out.print("\nIl tempo di gioco è stato disattivato.\n");
        } else {
            System.out.print("\nIl tempo di gioco è stato impostato a "
            + gameDuration
            + " minuti.\n\n");
        }
    }
}
