package it.uniba.app.FloydGame.Boundaries;
/**
 * <<Boundary>> Classe che contiene il messaggio di benvenuto.
 */
public final class Welcome {
    /**
     * Modificatore di accesso che impedisce la creazione di oggetti di tipo.
     */
    private Welcome() {
    }
    /**
     * Messaggio di benvenuto all'inizio dell'applicazione.
     */
    private static final String WELCOME_MESSAGE =
                    "\n                |    |    |"
                    + "\n               )_)  )_)  )_)"
                    + "\n              )___))___))___)"
                    + "\n             )____)____)_____)"
                    + "\n           _____|____|____|____\\__"
                    + "\n  ---------\\                   /---------"
                    + "\n    ^^^^^ ^^^^^^^^^^^^^^^^^^^^^"
                    + "\n      ^^^^      ^^^^     ^^^    ^^"
                    + "\n           ^^^^      ^^^\n"
                    + " ____        _   _   _           _     _       \n"
                    + "| __ )  __ _| |_| |_| | ___  ___| |__ (_)_ __\n"
                    + "|  _ \\ / _` | __| __| |/ _ \\/ __| '_ \\| | '_ \\\n"
                    + "| |_) | (_| | |_| |_| |  __/\\__ \\ | | | | |_) |\n"
                    + "|____/ \\__,_|\\__|\\__|_|\\___||___/_| |_|_| .__/\n"
                    + "       _____ _                 _   _    | |\n"
                    + "      |  ___| | ___  _   _  __| | | |\n"
                    + "      | |_  | |/ _ \\| | | |/ _` | | |\n"
                    + "      |  _| | | (_) | |_| | (_| | |_|\n"
                    + "      |_|   |_|\\___/ \\__, |\\__,_| (_)\n"
                    + "                     |___/           \n";
    /**
     * Stampa il messaggio di benvenuto.
     */
    public static void printWelcome() {
        System.out.println(WELCOME_MESSAGE);
    }
}
