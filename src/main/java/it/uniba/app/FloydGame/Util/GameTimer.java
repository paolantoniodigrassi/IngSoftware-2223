package it.uniba.app.FloydGame.Util;

/**
 * <<Entity>> Questa classe rappresenta un timer di gioco.
 */
public class GameTimer {

    /**
     * Durata del gioco in minuti.
     */
    private int gameDuration;

    /**
     * Tempo trascorso nel gioco in minuti.
     */
    private int elapsedTime;

    /**
     * Crea un nuovo oggetto GameTimer con la durata specificata.
     * @param duration La durata del gioco in minuti.
     */
    public GameTimer(final int duration) {
        this.gameDuration = duration;
        this.elapsedTime = 0;
    }

    /**
     * Incrementa il tempo trascorso nel gioco di 1 minuto.
     */
    public void incrementElapsedTime() {
        elapsedTime++;
    }

    /**
     * Restituisce il tempo trascorso nel gioco.
     * @return Il tempo trascorso nel gioco in minuti.
     */
    public int getElapsedTime() {
        return elapsedTime;
    }

    /**
     * Imposta il tempo trascorso nel gioco.
     */
    public void setElapsedTime(final int elapsed) {
        this.elapsedTime = elapsed;
    }
    /**
     * Imposta il tempo trascorso nel gioco.
     */
    public void setRemainingTime(final int remaining) {
        this.elapsedTime = gameDuration - remaining;
    }

    /**
     * Restituisce il tempo rimanente nel gioco.
     * @return Il tempo rimanente nel gioco in minuti.
     * Se la durata del gioco è 0, viene restituito -1 (tempo illimitato).
     */
    public int getRemainingTime() {
        if (this.gameDuration <= 0) {
            return -1;  // Tempo illimitato
        } else {
            return this.gameDuration - elapsedTime;
        }
    }

    /**
     * Azzera il tempo trascorso nel gioco.
     */
    public void reset() {
        gameDuration = 0;
        elapsedTime = 0;
    }
}
