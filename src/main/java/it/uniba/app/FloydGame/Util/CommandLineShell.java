package it.uniba.app.FloydGame.Util;

import it.uniba.app.FloydGame.Boundaries.CommandParser;
import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.Controller.Dispatcher;
import it.uniba.app.FloydGame.Controller.GameTimeCommand;
import it.uniba.app.FloydGame.GameTable.GameTable;
import it.uniba.app.FloydGame.GameTable.TableController;
import it.uniba.app.FloydGame.Ships.ShipMap;
import it.uniba.app.FloydGame.UserExceptions.AlreadyHitException;
import it.uniba.app.FloydGame.UserExceptions.MalformedCommand;
import it.uniba.app.FloydGame.UserExceptions.MissingDifficulty;
import it.uniba.app.FloydGame.UserExceptions.NullTableException;
import it.uniba.app.FloydGame.UserExceptions.RunningGameException;
import it.uniba.app.FloydGame.UserExceptions.WrongAttemptsValue;
import it.uniba.app.FloydGame.UserExceptions.GameNotStartedException;

import java.util.function.Consumer;

import java.util.List;
import java.util.ArrayList;

/**
 * <<Control>> Classe che controlla l'esecuzione dell'applicazione.
 */
public class CommandLineShell {
    private int maxFailedAttempts = 0;
    private static boolean gameStarted = false;
    private static GameTimer gameTimer;
    private static GameTimeCommand gameTimeCommand = new GameTimeCommand();
    private static ShipMap shipMap = new ShipMap();
    private static GameTable playerTab = null;
    private static GameTable completedTab = null;
    private Thread countdownThread = new Thread();
    /**
     * Metodo che si occupa di gestire il comando inserito dall'utente.
     * @param args Parametri da linea di comando
     * @throws ExitProgramException
     */
    private void start(final String[] args) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        clearScreen();
        if (args.length > 0 && (args[0].equals("-h")
            || args[0].equals("--help"))) {
                dispatcher.showHelp();
                return;
        }
        dispatcher.showWelcome();
        int turns = 0;
        String command;
        String number;
        while (true) {
            command = CommandUtil.commandTokenizer();
            number = CommandUtil.numberTokenizer();
            CommandUtil.resetNumber();
            switch (command) {
            case "/help":
                clearScreen();
                dispatcher.showHelp();
                break;
            case "/mostranavi":
                clearScreen();
                dispatcher.showShips(shipMap);
                break;
            case "/standard":
                clearScreen();
                completedTab = checkLoadTable(completedTab,
                    Const.STANDARD_DIM_TABLE);
                break;
            case "/large":
                clearScreen();
                completedTab = checkLoadTable(completedTab,
                    Const.LARGE_DIM_TABLE);
                break;
            case "/extralarge":
                clearScreen();
                completedTab = checkLoadTable(completedTab,
                    Const.EXTRA_LARGE_DIM_TABLE);
                break;
            case "/mostragriglia":
                clearScreen();
                dispatcher.showTable(playerTab);
                break;
            case "/tempo":
                clearScreen();
                gameTimeCommand.timeCommand(gameStarted, number);
                break;
            case "/mostratempo":
                clearScreen();
                gameTimeCommand.showTimeCommand(gameStarted);
                break;
            case "/svelagriglia":
                clearScreen();
                if (gameStarted) {
                    dispatcher.showTable(completedTab);
                } else {
                    dispatcher.showTxt("\nPrima di visualizzare la "
                    + "griglia devi iniziare a giocare!\n"
                    + "Digita /gioca per iniziare una nuova partita.\n\n");
                }
                break;
            case "/tentativi":
            case "/facile":
            case "/medio":
            case "/difficile":
                clearScreen();
                setDifficulty(number, command);
                break;
            case "/mostralivello":
                clearScreen();
                showLevel((Dispatcher) -> dispatcher.showDifficulty());
                break;
            case "/mostratentativi":
                clearScreen();
                showLevel((Dispatcher) -> dispatcher.showAttempts());
                break;
            case "/esci":
                clearScreen();
                if (exitTrue("Sicuro di voler uscire dall'app?[y|n]")) {
                    if (countdownThread != null) {
                        countdownThread.interrupt();
                    }
                    return;
                }
                break;
            case "/gioca":
                clearScreen();
                try {
                    if (gameStarted) {
                        throw new RunningGameException(("\nComando non "
                        + "disponibile durante la partita in corso!\n\n"));
                    }
                    gameStarted = true;
                    gameTimer =
                    new GameTimer(gameTimeCommand.getGameDuration());
                    Runnable countdownRunnable =
                    gameTimeCommand::countdown;
                    countdownThread = new Thread(gameTimeCommand::countdown);
                    if (countdownThread == null
                    || !countdownThread.isAlive()) {
                    gameTimeCommand.setCountdownThread(countdownRunnable);
                    countdownThread.start();
                    }
                    if (Difficulty.getLevel() == null) {
                        Difficulty.setDifficulty("/facile",
                        null);
                    }
                    completedTab = loadTable(completedTab,
                        Const.STANDARD_DIM_TABLE);
                    playerTab = new GameTable(
                        completedTab.getColumns());
                    playerTab.setGameTable();
                    shipMap = completedTab.setGameTable(shipMap);
                    dispatcher.showTxt("Inserisci le"
                        + " coordinate da colpire"
                        + " nel formato 'A-1'(Colonna-Riga)\n\n");
                    dispatcher.showTable(playerTab);
                } catch (RunningGameException e) {
                    dispatcher.showTxt(e.getMessage());
                }
                break;
            case "/abbandona":
                clearScreen();
                try {
                    tryQuitCurrentGame();
                    if (exitTrue("Sicuro di voler abbandondare"
                                + " la partita? [y|n]")) {
                        dispatcher.showTable(completedTab);
                        resetAll(countdownThread);
                    }
                } catch (GameNotStartedException e) {
                    dispatcher.showTxt(e.getMessage());
                }
                break;
            default:
                clearScreen();
                turns = defaultGame(command, turns);
                break;
            }
        }
    }

    /**
     * Metodo main.
     */
    public void execute(final String[] args) {
        start(args);
        gameTimeCommand.stopCountdownThread();
    }

    /**
     * Metodo per settare le variabili di
     * gioco alla scadenza del tempo.
     */
    public static void timerExit(final Thread countDown) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        if (!gameStarted) {
            dispatcher.showTxt("\nIl gioco non è in corso.\n\n");
            return;
        }
        clearScreen();
        dispatcher.showTxt("\n\nTempo scaduto! "
            + "Abbandono della partita in corso...\n\n");
        dispatcher.showTable(completedTab);
        dispatcher.showTxt(Const.LOST);
        dispatcher.showTxt("La partita è terminata. "
            + "Grazie per aver giocato!\n\n");
        dispatcher.showHelpMsg();
        dispatcher.showBattleship();
        resetAll(countDown);
    }

    /**
     * Metodo che setta la difficoltà.
     * @param number numero di tentativi falliti.
     * @param command comando inserito.
     */
    private void setDifficulty(final String number, final String command) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        if (gameStarted) {
            try {
                throw new RunningGameException("\nNon puoi impostare la "
                 + "difficoltà durante una partita in corso!\n\n");
            } catch (RunningGameException e) {
                dispatcher.showTxt(e.getMessage());
            }
        } else {
            if (!number.isEmpty()) {
                try {
                    CommandUtil.checkPos(number);
                    maxFailedAttempts = Integer.parseInt(number);
                    dispatcher.showTxt("\nOK. "
                        + "Il numero massimo di tentativi fallibili"
                        + " è stato impostato a "
                        + maxFailedAttempts + ".\n\n");
                    Difficulty.setDifficulty(command,
                        maxFailedAttempts);
                } catch (WrongAttemptsValue e) {
                    dispatcher.showTxt("\nErrore: "
                        + e.getMessage() + "\n\n");
                }
            } else {
                if (command.equals("/tentativi")) {
                    dispatcher.showTxt("\nComando non valido: '/tentativi'"
                    + " deve esssere succeduto da un numero!\n\n");
                } else {
                    Difficulty.setDifficulty(command, null);
                }
            }
        }
    }

    /**
     * Metodo che istanzia una tabella in base alla dimensione.
     * @param gameTable tabella da istanziare.
     * @param dim dimensione della tabella da istanziare.
     * @return tab ritorna la tabella istanziata.
     */
    private GameTable loadTable(final GameTable gameTable, final int dim) {
        GameTable tab = gameTable;
        try {
            GameTable.isNull(tab);
        } catch (NullTableException e) {
            tab = null;
            tab = new GameTable(dim);
        }
        return tab;
    }

    /**
     * Metodo che controlla se il gioco è iniziato.
     * Impedisce il cambio di dimensione se positivo.
     * @param gameTable tabella da istanziare.
     * @param dim dimensione della tabella da istanziare.
     * @return tab ritorna la tabella istanziata.
     */
    private GameTable checkLoadTable(final GameTable gameTable, final int dim) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        GameTable tab = gameTable;
        if (!gameStarted) {
            tab = loadTable(tab, dim);
            tab = new GameTable(dim);
            dispatcher.showTxt("\nOK, la tabella è stata impostata!\n\n");
        } else {
            dispatcher.showTxt("\nComando non valido: "
            + "la partita è già iniziata!\n\n");
        }
        return tab;
    }

    /**
     * Metodo che stampa le difficoltà (a seconda del
     * metodo passato in input).
     * @param b interfaccia Consumer.
     */
    private void showLevel(final Consumer<Dispatcher> b) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        try {
            if (Difficulty.getMaxMistakes() == 0) {
            throw new MissingDifficulty();
            }
            b.accept(dispatcher);
        } catch (MissingDifficulty e) {
            dispatcher.showTxt(e.getMessage());
        }
    }

    /**
     * Metodo che controlla se il comando inserito è valido.
     * @throws GameNotStartedException
     */
    private static void tryQuitCurrentGame()
    throws GameNotStartedException {
        if (!gameStarted) {
            throw new GameNotStartedException();
        }
    }

    /**
     * Esegue il gioco, colpendo le navi e segnando le tabelle.
     * @param command stringa contentenente il comando.
     * @param turns turni passati.
     * @return t turni del gioco.
     */
    private int defaultGame(final String command, final int turns) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        int t = turns;
        List<Integer> cords = new ArrayList<>();
        try {
            if (command.charAt(0) == '/') {
                throw new MalformedCommand(Const.COMMAND_ERROR);
            }
        } catch (MalformedCommand e) {
            dispatcher.showTxt(e.getMessage());
            return turns;
        }
        if (gameStarted) {
            try {
                CommandUtil.cordsParser(command,
                    completedTab, cords);
                TableController.shootShip(cords.get(0),
                    cords.get(1), completedTab, shipMap,
                    playerTab, gameTimeCommand);
                t++;
                if (t >= Const.MAX_DIM) {
                    if (shipMap.checkGameStatus()) {
                        dispatcher.showTxt(Const.WON);
                        resetAll(countdownThread);
                        return 0;
                    }
                }
                if (Difficulty.getNumMistakes()
                    == Difficulty.getMaxMistakes()) {
                    dispatcher.showTable(completedTab);
                    dispatcher.showTxt(Const.LOST);
                    dispatcher.showTxt("\n--- Hai terminato"
                        + " il numero di tentativi disponibili ---\n\n");
                    resetAll(countdownThread);
                    return 0;
                }
            } catch (MalformedCommand e) {
                dispatcher.showTxt(e.getMessage());
            } catch (AlreadyHitException e) {
                dispatcher.showTxt(e.getMessage());
            }
        } else {
            dispatcher.showTxt(Const.COMMAND_ERROR);
        }
        return t;
    }

    /**
     * Chiede la conferma dell'uscita dall'app.
     * @return boolean
     * @param msg messaggio da stampare.
     */
    private boolean exitTrue(final String msg) {
        if (CommandParser.checkExitAnswer("\n" + msg + "\n")) {
            return true;
        }
        return false;
    }

    /**
     * Metodo che permette di pulire il terminale.
     */
    private static void clearScreen() {
        try {
            String os = System.getProperty("os.name").toLowerCase();

            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c",
                    "cls").inheritIO().start().waitFor();
            } else {
                new ProcessBuilder("sh", "-c",
                    "clear").inheritIO().start().waitFor();
            }
        } catch (Exception e) {
            // Gestisci eventuali eccezioni
            e.printStackTrace();
        }
    }

    /**
     * Metodo che resetta tutti le funzioni di gioco.
     * @param countdownThread thread del timer.
     */
    private static void resetAll(final Thread countdownThread) {
        completedTab = null;
        playerTab = null;
        shipMap = new ShipMap();
        Difficulty.setLevel(null);
        Difficulty.setNumMistakes(0);
        Difficulty.setMaxMistakes(0);
        Difficulty.setTurns(0);
        gameTimeCommand.setGameDuration(0);
        gameTimeCommand.getElapsedTime(0);
        gameTimer.reset();
        gameTimeCommand.setisGameDurationSet(false);
        gameTimeCommand.stopCountdownThread();
        gameStarted = false;
        if (countdownThread != null) {
            countdownThread.interrupt();
        }
    }
}
