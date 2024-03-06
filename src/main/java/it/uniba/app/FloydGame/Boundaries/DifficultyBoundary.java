package it.uniba.app.FloydGame.Boundaries;

import it.uniba.app.FloydGame.Util.Difficulty;

/**
 * <<Boundary>> Classe che si occupa della stampa della difficoltà.
 */
public final class DifficultyBoundary {

 /**
   * Costruttore di DifficultyBoundary.
   */
  private DifficultyBoundary() {
  }

  /**
   * Mostra all'utente il livello di gioco selezionato, il
   * numero di errori possibili e il numero di errori commessi.
   */
  public static void printDifficulty() {
    System.out.print("\nLivello di gioco attuale: ");
    System.out.print(Difficulty.getLevel());
    System.out.print("\nNumero di errori possibili:");
    System.out.print(Difficulty.getMaxMistakes());
    System.out.print("\nNumero di errori fatti: ");
    System.out.print(Difficulty.getNumMistakes());
    System.out.print("/");
    System.out.println(Difficulty.getMaxMistakes());
    System.out.println("\n");
  }

  /**
   * Mostra all'utente il numero di tentativi fallibili
   * e il numero di errori commessi.
   */
  public static void printAttempts() {
    System.out.print("\nNumero di tentativi fallibili:");
    System.out.print(Difficulty.getMaxMistakes());
    System.out.print("\nNumero di errori fatti: ");
    System.out.print(Difficulty.getNumMistakes());
    System.out.print("/");
    System.out.print(Difficulty.getMaxMistakes());
    System.out.print("\nNumero di tentativi effettuati: ");
    System.out.print(Difficulty.getTurns());
    System.out.println("\n");
  }

  /**
   * Mostra all'utente il livello di gioco selezionato e il
   * numero di errori possibili.
   */
  public static void printChoosenDifficulty(final String level,
    final int mistakes) {
    System.out.println("\nOK, hai scelto la difficoltà: "
    + level
    + "\n"
    + "Hai a disposizione "
    + mistakes
    + " errori.\n");
  }

  /**
   * Stampa il numero di tentativi già effettuati.
   */
  public static void printTurns() {
    System.out.print("\nNumero di errori fatti: ");
    System.out.print(Difficulty.getNumMistakes());
    System.out.print("/");
    System.out.print(Difficulty.getMaxMistakes());
    System.out.print("\nNumero di tentativi effettuati: ");
    System.out.print(Difficulty.getTurns());
  }
}
