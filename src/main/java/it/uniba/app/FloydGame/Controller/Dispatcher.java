package it.uniba.app.FloydGame.Controller;

import it.uniba.app.FloydGame.Boundaries.DifficultyBoundary;
import it.uniba.app.FloydGame.Boundaries.GameTableBoundary;
import it.uniba.app.FloydGame.Boundaries.Help;
import it.uniba.app.FloydGame.Boundaries.ShipsBoundary;
import it.uniba.app.FloydGame.Boundaries.Welcome;
import it.uniba.app.FloydGame.GameTable.GameTable;
import it.uniba.app.FloydGame.Ships.ShipMap;
import it.uniba.app.FloydGame.UserExceptions.NullTableException;

/**
 * <<Control>> Permette la gestione dei messaggi di stampa.
 */
public final class Dispatcher {

    /**
     * Unica istanza di questa classe.
     */
    private static Dispatcher instance;

    /*
     * Costruttore privato, accessibile
     * solo dal metodo singletonDisparcher.
     */
    private Dispatcher() {

    }

    /**
     * Metodo che istanzia un'unica volta un oggetto dispatcher.
     * @return instance istanza unica.
     */
    public static Dispatcher singletonDispatcher() {
        if (instance == null) {
            instance = new Dispatcher();
        }
        return instance;
    }

    /**
     * Invia la tabella da stampare catturando l'eccezione se si verifica.
     * @param tab tabella da stampare.
     */
    public void showTable(final GameTable tab) {
        try {
            GameTableBoundary.printTable(tab);
        } catch (NullTableException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Invia la shipMap per la stampa delle navi.
     * @param shipMap contenitore delle navi.
     */
    public void showShips(final ShipMap shipMap) {
        ShipsBoundary.printShips(shipMap);
    }

    /**
     * Invia la stringa alla stampa.
     * @param txt stringa generica.
     */
    public void showTxt(final String txt) {
        System.out.print(txt);
    }

    /**
     * Richiede di stampare l'helper.
     */
    public void showHelp() {
        Help.printHelp();
    }

    /**
     * Richiede di stampare il benvenuto.
     */
    public void showWelcome() {
        Welcome.printWelcome();
    }

    /**
     * Invia la stringa dell'help alla stampa.
     */
    public void showHelpMsg() {
        System.out.print("Usa /help "
        + "per visualizzare la lista dei comandi disponibili\n");
    }

    /**
     * Invia la stringa inizio frase alla stampa.
     */
    public void showBattleship() {
        System.out.print("battleShip:> ");
    }

    /**
     * Invia alla stampa la difficoltà e il numero massimo di errori scelti.
     * @param level livello scelto.
     * @param mistakes numero massimo di errori.
     */
    public void showChoosenDifficulty(final String level, final int mistakes) {
        DifficultyBoundary.printChoosenDifficulty(level, mistakes);
    }

    /**
     * Richiama il metodo di stampa delle difficoltà.
     */
    public void showDifficulty() {
        DifficultyBoundary.printDifficulty();
    }

    /**
     * Richiama il metodo di stampa dei tentativi fallibili.
     */
    public void showAttempts() {
        DifficultyBoundary.printAttempts();
    }

    /**
     * Richiama il metodo di stampa dei tentativi.
     */
    public void showGameStats(final GameTimeCommand gameTimeCommand) {
        System.out.print("\nSTATISTICHE DELLA PARTITA: ");
        DifficultyBoundary.printTurns();
        if (gameTimeCommand.getTimerFlag()) {
            gameTimeCommand.showTimeCommand(true);
        } else {
            System.out.print("\n\n");
        }
    }
}
