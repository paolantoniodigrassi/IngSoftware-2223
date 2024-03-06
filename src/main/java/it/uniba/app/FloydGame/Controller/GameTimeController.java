package it.uniba.app.FloydGame.Controller;

/**
 * <<Control>> Classe che fornisce un controller
 * per la visualizzazione del tempo di gioco.
 */
public final class GameTimeController {
    /**
     * Costruttore privato per impedire l'istanziazione della classe.
     */
    private GameTimeController() {
        throw new AssertionError("Classe non istanziabile.");
    }
    /**
     * Visualizza il tempo di gioco trascorso e il tempo rimanente.
     * @param remainingTime il tempo rimanente in minuti.
     * @param elapsedTime  il tempo trascorso in minuti.
     */
    public static void displayGameTime(final int remainingTime,
        final int elapsedTime) {
        if (remainingTime == -1) {
            System.out.print("\nTempo di gioco illimitato. Tempo trascorso: "
                + elapsedTime
                + " minuti.\n\n");
        } else {
            System.out.print("\nTempo trascorso: "
                + (elapsedTime - 1)
                + " minuti. \nTempo rimanente: "
                + (remainingTime + 1) + " minuti.\n\n");
        }
    }
}
