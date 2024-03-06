package it.uniba.app.FloydGame.Util;

import it.uniba.app.FloydGame.UserExceptions.MalformedCommand;
import it.uniba.app.FloydGame.UserExceptions.WrongAttemptsValue;
import it.uniba.app.FloydGame.Boundaries.CommandParser;
import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.GameTable.GameTable;

import java.util.List;
import java.util.StringTokenizer;

/**
 * <<control>> Classe che si occupa di gestire il comando inserito dall'utente.
 */
public final class CommandUtil {
  /**
   * Stringa che rappresenta la parte numerica del comando.
   */
  private static String number = "";

  /**
   * Costruttore privato della classe CommandParser.
   */
  private CommandUtil() {
  }

  /**
   * Permette di acquisire le coordinate.
   * @param command comando inserito dall'utente.
   * @param tab tabella di gioco.
   * @param cord lista contenente le coordinate.
   */
  static void cordsParser(final String command,
    final GameTable tab, final List<Integer> cord) throws MalformedCommand {
      String rawCords;
      int x = 0;
      int y = 0;
      char rawy = ' ';
      String[] cords = null;
      try {
        rawCords = command.toUpperCase();
        if (rawCords.contains("-")) {
          cords = rawCords.split("-");
          if (cords[0].length() > 1) {
            throw new IllegalArgumentException(Const.COMMAND_ERROR);
          }
          try {
            x = Integer.parseInt(cords[1]);
          } catch (NumberFormatException e) {
            throw new IllegalArgumentException(Const.COMMAND_ERROR);
          }
        } else {
          throw new IllegalArgumentException(Const.COMMAND_ERROR);
        }
        if (x > 0 && x <= tab.getRows() - 2) {
          rawy = cords[0].charAt(0);
          y = toInt(rawy);
          if (y < 1 || y > tab.getColumns() - 2) {
            throw new IllegalArgumentException(Const.COMMAND_ERROR);
          }
        } else {
          throw new IllegalArgumentException(Const.COMMAND_ERROR);
        }
      } catch (IllegalArgumentException e) {
        throw new MalformedCommand(e.getMessage());
      } catch (IndexOutOfBoundsException e) {
        throw new MalformedCommand(Const.COMMAND_ERROR);
      }
    cord.add(x);
    cord.add(y);
  }

  /**
   * Verifica e restituisce un intero positivo dalla stringa fornita.
   * @param userMaxAttempts La stringa contenente il numero di tentativi.
   * @return Il numero di tentativi come intero.
   * @throws WrongAttemptsValue Se il valore
   * inserito non è valido (negativo o non numerico).
   */
  static int checkPos(final String userMaxAttempts)
  throws WrongAttemptsValue {
    try {
      int maxFailedAttempts = Integer.parseInt(userMaxAttempts);
      if (maxFailedAttempts <= 0) {
        throw new WrongAttemptsValue("Valore inserito non valido. "
        + "Il numero deve essere maggiore di zero.");
      }
      return Integer.parseInt(userMaxAttempts);
    } catch (NumberFormatException e) {
      throw new WrongAttemptsValue("Impossibile "
      + "convertire la stringa in un intero.");
    }
  }

  /**
   * Divide la stringa in comando e numero.
   * @return stringa del comando
   */
  static String commandTokenizer() {
    String command;
    do {
      try {
          CommandParser.setUserCommand();
          StringTokenizer tokenizer = new
          StringTokenizer(CommandParser.getUserCommand());
          String[] commandParts = new String[tokenizer.countTokens()];
          int index = 0;
          while (tokenizer.hasMoreTokens()) {
              commandParts[index++] = tokenizer.nextToken();
          }
          command = (commandParts[0]);
          if (commandParts.length > 1) {
              number = commandParts[1];
          }
          break;
      } catch (ArrayIndexOutOfBoundsException e) {
        System.out.print(Const.COMMAND_ERROR);
      }
    } while (true);
    return command;
  }

  /**
   * Ritorna la parte numerica.
   * @return number stringa numerica del comando.
   */
  static String numberTokenizer() {
    return number;
  }

  /**
   * Resetta la stringa numero del comando.
   */
  static void resetNumber() {
    number = "";
  }

  /**
   * Si occupa di convertire un char in int.
   * @param cord coordinata char da convertire in int.
   * @return count cordinata convertita in int.
   */
  private static int toInt(final char cord) {
    int count = 1;
    char temp = 'A';
    while (cord != temp) {
        count++;
        temp++;
    }
    return count;
  }
}
