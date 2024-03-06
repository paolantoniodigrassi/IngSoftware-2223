package it.uniba.app.FloydGame.Controller;

import it.uniba.app.FloydGame.UserExceptions.ChangingGameDurationException;
import it.uniba.app.FloydGame.UserExceptions.GameDurationNotSetException;
import it.uniba.app.FloydGame.Util.CommandLineShell;
import it.uniba.app.FloydGame.Util.GameTimer;

/**
 * <<control>> Classe che gestisce i comandi
 * /tempo e /mostratempo del gioco.
 */
public class GameTimeCommand {
    /**
     * Istanziazione timer di gioco.
     */
    private GameTimer gameTimer;
    /**
     * Thread per il countdown.
     */
    private Thread countdownThread;
    /**
     * Durata del gioco in minuti.
     */
    private int gameDuration;
    /**
     * Flag di tempo impostato o no.
     */
    private boolean isGameDurationSet = false;
    /**
     * Tempo trascorso nel gioco in minuti.
     */
    private int elapsedTime;

    /**
     * Metodo per ottenere la durata del gioco.
     * @return la durata del gioco in minuti.
     */
    public int getGameDuration() {
        return gameDuration;
    }

    /**
     * Metodo per impostare la durata del gioco.
     * @param duration la durata del gioco in minuti.
     */
    public void setGameDuration(final int duration) {
        this.gameDuration = duration;
    }

    /**
     * Metodo per ottenere il tempo trascorso.
     * @return il tempo trascorso nel gioco in minuti.
     */
    public int getElapsedTime(final int value) {
        elapsedTime = value;
        return elapsedTime;
    }

    /**
     * Metodo per impostare il valore del flag isGameDurationSet.
     * @param isGameDurationSetted indica se è stato inserito il tempo
     */
    public void setisGameDurationSet(final boolean isGameDurationSetted) {
        this.isGameDurationSet = isGameDurationSetted;
    }

    /**
     * Metodo per avere remainingTime.
     */
    public int getRemainingTime() {
        return gameTimer.getRemainingTime();
    }

    /**
     * Metodo per avere elapsedTime.
     */
    public int getElapsedTime() {
        return gameTimer.getElapsedTime();
    }

    /**
     * Metodo per impostare setGameTimer.
     * @param timer il gameTimer da impostare.
     */
    void setGameTimer(final GameTimer timer) {
        if (gameTimer != null) {
            gameTimer.reset();
        }
        this.gameTimer = timer;
    }

    /**
     * Metodo che estrae la flag.
     * @return isGameDurationSet flag.
     */
    public boolean getTimerFlag() {
        return isGameDurationSet;
    }

    /**
     * Metodo per impostare il countdownThread.
     * @param thread il countdownThread da impostare.
     */
    public void setCountdownThread(final Runnable thread) {
        this.countdownThread = new Thread(thread);
    }

    /**
     * Classe che gestisce il comando /tempo del gioco.
     * @param gameStarted true se il gioco è iniziato, false altrimenti.
     * @param number la durata del gioco in minuti.
     */
    public void timeCommand(final boolean gameStarted, final String number) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        if (!number.isEmpty()) {
            try {
                if (gameStarted) {
                    throw new ChangingGameDurationException();
                }
                int duration = Integer.parseInt(number);
                setGameDuration(duration);
                GameDurationController.
                setGameDuration(duration);
                isGameDurationSet = true;
                gameTimer = new GameTimer(duration);
            } catch (NumberFormatException e) {
                dispatcher.showTxt("\nIl parametro del comando"
                    + " '/tempo' non è un numero valido.\n\n");
            } catch (ChangingGameDurationException e) {
                dispatcher.showTxt(e.getMessage());
            }
        } else {
            try {
                throw new GameDurationNotSetException();
            } catch (GameDurationNotSetException e) {
                dispatcher.showTxt(e.getMessage());
            }
        }
    }

    /**
     * Classe che gestisce il comando /mostratempo del gioco.
     * @param gameStarted true se il gioco è iniziato, false altrimenti.
     */
    public void showTimeCommand(final boolean gameStarted) {
        Dispatcher dispatcher = Dispatcher.singletonDispatcher();
        if (gameStarted) {
            if (isGameDurationSet) {
                int remainingTime = gameTimer.
                getRemainingTime();
                GameTimeController.
                displayGameTime(remainingTime, elapsedTime);
            } else {
                dispatcher.showTxt("\nIl tempo non "
                    + "è stato impostato.\n\n");
            }
        } else {
            if (isGameDurationSet) {
                dispatcher.showTxt("\nIl tempo di"
                    + " gioco è pari a "
                    + gameDuration
                    + ".\nSi avvierà quando"
                    + " inizierai a giocare.\n\n");
            } else {
                dispatcher.showTxt("\nIl gioco non è ancora"
                    + " iniziato e il tempo "
                    + "non è stato impostato.\n\n");
            }
        }
    }

    /**
     * Metodo per avviare il countdown del timer di gioco.
     */
    public void countdown() {
        int remainingTime = getGameDuration();
        if (remainingTime > 0) {
            while (remainingTime > 0) {
                remainingTime--;
                elapsedTime++;
                gameTimer.incrementElapsedTime();
                try {
                    Thread.sleep(Const.MINUTE);
                } catch (InterruptedException e) {
                    stopCountdownThread();
                    return;
                }
            }
            stopCountdownThread();
            CommandLineShell.timerExit(countdownThread);
        }
    }

    /**
     * Metodo per interrompere il thread del countdown.
     */
    public void stopCountdownThread() {
        if (countdownThread != null) {
            countdownThread.interrupt();
        }
    }
}

