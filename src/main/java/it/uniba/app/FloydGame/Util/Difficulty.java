package it.uniba.app.FloydGame.Util;

import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.Controller.Dispatcher;

/**
 * <<Entity>> Classe che si occupa di gestire il livello di difficoltà
 * e il numero di errori che si possono commettere.
 */
public final class Difficulty {

  /**
   * Livello di difficoltà scelto.
   */
  private static String level;

  /**
   * Numero di errori commessi.
   */
  private static int numMistakes;

  /**
   * Numero massimo di errori fattibili.
   */
  private static int maxMistakes;

  /**
   * Numero dei turni effettuati.
   */
  private static int turns = 0;

  /**
   * Modificatore di accesso che impedisce la creazione di oggetti di tipo.
   */
  private Difficulty() {
  }

  /**
   * Assegna i valori corretti in base alla difficoltà scelta.
   * @param levelDiff stringa inserita dall'utente.
   */
  public static void setDifficulty(final String levelDiff,
      final Integer userMaxAttempts) {
      Dispatcher dispatcher = Dispatcher.singletonDispatcher();
      if (userMaxAttempts != null) {
        switch (levelDiff) {
          case "/facile":
            setDifficultyWithMaxAttempts("Facile", userMaxAttempts);
            break;
          case "/medio":
            setDifficultyWithMaxAttempts("Medio", userMaxAttempts);
            break;
          case "/difficile":
            setDifficultyWithMaxAttempts("Difficile", userMaxAttempts);
            break;
          case "/tentativi":
            setDifficultyWithMaxAttempts("Personalizzato", userMaxAttempts);
            break;
          default:
            //Non è previsto un caso di default
        }
      } else {
        switch (levelDiff) {
          case "/facile":
            setLevel("Facile");
            setMaxMistakes(Const.EASY);
            dispatcher.showChoosenDifficulty(getLevel(), getMaxMistakes());
            break;
          case "/medio":
            setLevel("Medio");
            setMaxMistakes(Const.MEDIUM);
            dispatcher.showChoosenDifficulty(getLevel(), getMaxMistakes());
            break;
          case "/difficile":
            setLevel("Difficile");
            setMaxMistakes(Const.HARD);
            dispatcher.showChoosenDifficulty(getLevel(), getMaxMistakes());
            break;
          default:
            //nessuna istruzione da eseguire se non c'è nessun caso
          }
        }
      }

  /**
   * Assegna il livello di difficoltà e il numero di tentativi falliti.
   * @param levelDiff livello di difficoltà scelto.
   * @param maxFailedAttempts numero di tentativi falliti.
   */
  public static void setDifficultyWithMaxAttempts(final String levelDiff,
  final int maxFailedAttempts) {
    setLevel(levelDiff);
    setMaxMistakes(maxFailedAttempts);
  }

  /**
   * Ritorna il livello corrente.
   */
  public static String getLevel() {
    return level;
  }

  /**
   * Ritorna il numero di errori commessi.
   */
  public static int getNumMistakes() {
    return numMistakes;
  }

  /**
   * Imposta il numero di errori commessi.
   * @param mistakes errori commessi.
   */
  public static void setNumMistakes(final int mistakes) {
    numMistakes = mistakes;
  }
  /**
   * Ritorna il numero di errori massimo che si possono commettere.
   */
  public static int getMaxMistakes() {
    return maxMistakes;
  }

  /**
   * Imposta il livello di difficoltà scelto.
   * @param levelDiff livello di difficoltà scelto.
   */
  static void setLevel(final String levelDiff) {
    level = levelDiff;
  }

  /**
   * Imposta il numero massimo di errori che si possono.
   * commettere in base alla difficoltà scelta
   * @param maxMistakesNum numero massimo di errori.
   */
  static void setMaxMistakes(final int maxMistakesNum) {
    maxMistakes = maxMistakesNum;
  }

  /**
   * Incrementa il numero di errori commessi.
   */
  public static void increaseNumMistakes() {
    setNumMistakes(getNumMistakes() + 1);
  }

  /**
   * Ritorna il numero di turni effettuati.
   */
  public static int getTurns() {
    return turns;
  }

  /**
   * Imposta il numero di turni effettuati.
   * @param nTurns numero dei turni aggiornato
   */
  public static void setTurns(final int nTurns) {
    turns = nTurns;
  }

}
