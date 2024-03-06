package it.uniba.app;

import it.uniba.app.FloydGame.Util.CommandLineShell;

/**
 * Main class of the application.
 */
public final class App {
    public String getGreeting() {
        return "Hello World!!!";
    }
    /**
     * Main method.
     * @param args Parametri da linea di comando
     */
    public static void main(final String[] args) {
        new CommandLineShell().execute(args);
    }
}
