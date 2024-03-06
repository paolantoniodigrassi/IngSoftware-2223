package it.uniba.app.FloydGame.Boundaries;

import java.nio.charset.StandardCharsets;
import java.util.Scanner;
import it.uniba.app.FloydGame.Controller.Dispatcher;

/**
 * <<Boundary>> Classe che si occupa
 * di gestire il comando inserito dall'utente.
 */
public final class CommandParser {
    private static final Scanner SCANNER =
        new Scanner(System.in, StandardCharsets.UTF_8.name());
    private static String userCommand = "/";

    /**
     * Costruttore privato.
     */
    private CommandParser() {
    }

    /**
     * Permette di acquisire il comando.
     */
    public static void setUserCommand() {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        dispatcher.showHelpMsg();
        dispatcher.showBattleship();
        String userInput = SCANNER.nextLine();
        userCommand = userInput.toLowerCase();
    }

    /**
     * Permette di ottenere il comando.
     * @return userCommand il comando inserito dall'utente
     */
    public static String getUserCommand() {
        return userCommand;
    }

    /**
     * Chiede conferma prima di abbandonare la partita.
     */
    public static boolean checkExitAnswer(final String msg) {
        String keepPlaying = "y";
        System.out.print(msg);

        do {
            keepPlaying = SCANNER.nextLine().toLowerCase();
            if (!keepPlaying.matches("[yn]")) {
                System.out.println("\n--- Input non valido. Inserisci"
                    + " 'y' per continuare o 'n' per abbandonare ---\n");
            }
        } while (!keepPlaying.matches("[yn]"));

        switch (keepPlaying) {
            case "y":
                System.out.print("\n+++ Uscita in corso +++\n");
                return true;
            case "n":
            System.out.print("\n +++ Continua a giocare +++ \n\n");
                return false;
            default:
                //nessun caso
        }
        return false;
    }
}
