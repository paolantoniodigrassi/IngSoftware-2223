package it.uniba.app.FloydGame.GameTable;

import java.util.Random;

import java.util.List;
import java.util.ArrayList;

import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.UserExceptions.NullTableException;
import it.uniba.app.FloydGame.Ships.ShipMap;

/**
 * <<Entity>> Classe che modella il dato astratto gameTable,
 * griglia per giocare alla battaglia navale.
 */
public class GameTable {

  /**
   * Array di caratteri a doppia dimensione raffigurante la tabella di gioco.
   */
  private char[][] table;

  /**
   * Intero rappresentante il numero di righe.
   */
  private int rows;

  /**
   * Intero rappresentante il numero di colonne.
   */
  private int columns;

  /**
   * Costruttore della classe gameTable
   * con dimensione dichiarata.
   * @param dim dimensione tabella
   */
  public GameTable(final int dim) {
    rows = dim;
    columns = dim;
    table = new char[rows][columns];
  }

  /**
   * Ritorna il valore in posizione rows e columns.
   * @param row intero raffigurante la riga.
   * @param column intero raffigurante la colonna.
   */
  public char getValue(final int row, final int column) {
    return table[row][column];
  }

  /**
   * Inserisce il valore in table in posizione riga e colonna.
   * @param row intero raffigurante la riga.
   * @param column intero raffigurante la colonna.
   * @param value carattere raffiguarante l'elemento da inserire.
   */
  public void setValue(final int row, final int column, final char value) {
    table[row][column] = value;
  }

  /**
   * Ritorna il numero di righe disponibili.
   */
  public int getRows() {
    return rows;
  }

  /**
   * Ritorna il numero di colonne disponibili.
   */
  public int getColumns() {
    return columns;
  }

  /**
   *  Imposta la tabella di gioco vuota.
   */
  public void setGameTable() {
    setBound();

    for (int i = 1; i < rows - 1; i++) {
      for (int j = 1; j < columns - 1; j++) {
        setValue(i, j, Const.VOID);
      }
    }

  }

  /**
   * Imposta la tabella di gioco con le navi.
   * @param s shipMap dove salvare la posizione delle navi.
   * @return shipMap con navi posizionate.
   */
  public ShipMap setGameTable(final ShipMap s) {
    setBound();

    for (int i = 1; i < rows - 1; i++) {
      for (int j = 1; j < columns - 1; j++) {
        setValue(i, j, Const.SEA);
      }
    }

    ShipMap shipMap = s;
    shipMap = setShips(shipMap);
    return shipMap;
  }

  /**
   * Controlla che la tabella non sia stata già inizializzata.
   * @param tab
   * @throws NullTableException
   */
  public static void isNull(final GameTable tab)
    throws NullTableException {
    if (tab == null) {
      throw new NullTableException(
        ("\nNon hai impostato la dimensione della tabella.")
        + (" E stata impostata quella di deafult\n"));
    }
  }

  /**
   * Imposta i bordi della tabella.
   */
  private void setBound() {
    for (int i = 0; i < rows; i++) {
      setValue(i, Const.MINRANGE_TAB, Const.BOUND);
    }

    for (int j = 0; j < columns; j++) {
      setValue(Const.MINRANGE_TAB, j, Const.BOUND);
    }

    for (int i = 0; i < rows; i++) {
      setValue(i, getColumns() - 1, Const.BOUND);
    }

    for (int j = 0; j < columns; j++) {
      setValue(getRows() - 1, j, Const.BOUND);
    }
  }

  /**
   * Chiama il metodo loadShip in base a quante navi inserire.
   * @param shipMap map di navi dove inserire x, y e dim
   */
  private ShipMap setShips(final ShipMap shipMap) {
    List<Integer> cords = new ArrayList<>();

    int key = 1;
    cords = loadShip(Const.DIM_PORTAEREI);
    shipMap.setValues(key, cords);

    for (int i = 0; i < Const.IST_CORAZZATA; i++) {
      key++;
      cords = loadShip(Const.DIM_CORAZZATA);
      shipMap.setValues(key, cords);
    }

    for (int i = 0; i < Const.IST_INCROCIATORE; i++) {
      key++;
      cords = loadShip(Const.DIM_INCROCIATORE);
      shipMap.setValues(key, cords);
    }

    for (int i = 0; i < Const.IST_CACCIATORPEDINIERE; i++) {
      key++;
      cords = loadShip(Const.DIM_CACCIATORPEDINIERE);
      shipMap.setValues(key, cords);
    }

    return shipMap;
  }

  /**
   * Calcola la posizione in maniera randomica in table di una
   * nave in base alla posizione passata in input e la
   * inserisce nella tabella.
   * @param dim intero raffigurante la dimensione di una nave
   * @return cords lista di coordinate
   */
  private List<Integer> loadShip(final int dim) {
    int rowPos;
    int columnPos;
    int direction;
    Random rand = new Random();
    List<Integer> cords = new ArrayList<>();

    do {
      rowPos = computeInfo(getRows() - 2, rand);
      columnPos = computeInfo(getColumns() - 2, rand);
      direction = computeInfo(Const.MAX_DIRECTION, rand);
    } while (!freeArea(rowPos, columnPos, direction, dim));

    cords.add(rowPos);
    cords.add(columnPos);
    cords.add(direction);

    switch (direction) {
    case 1: //horizontal
      for (int i = 0; i < dim; i++) {
        setValue(rowPos, columnPos + i, Const.SHIP);
      }
      break;
    case 2: //vertical
      for (int i = 0; i < dim; i++) {
        setValue(rowPos + i, columnPos, Const.SHIP);
      }
      break;
    default:
      //non esegue nessuna istruzione
      break;
    }

    return cords;
  }

  /**
   * Metodo che implementa i controlli di sicurezza in base
   * alla posizione, dimensione e direzione della nave.
   * @param r intero raffigurante la riga.
   * @param c intero raffigurante la colonna.
   * @param direction intero raffigurante la direzione della nave.
   * @param dim intero raffigurante la dimensione della nave.
   */
  private boolean freeArea(final int r, final int c,
    final int direction, final int dim) {

    if (getValue(r, c) == Const.SHIP) {
      return false;
    }

    switch (direction) {
    case 1:
      for (int i = 0; i < dim; i++) {
        if (getValue(r, c + i) == Const.BOUND) {
          return false;
        }
      }

      for (int i = 0; i < Const.BORDERCHECK; i++) {
        for (int j = 0; j < dim + 2; j++) {
          if (getValue(r - 1 + i, c - 1 + j) == Const.SHIP) {
            return false;
          }
        }
      }
      break;

    case 2:
      for (int i = 0; i < dim; i++) {
        if (getValue(r + i, c) == Const.BOUND) {
          return false;
        }
      }

      for (int i = 0; i < dim + 2; i++) {
        for (int j = 0; j < Const.BORDERCHECK; j++) {
          if (getValue(r - 1 + i, c - 1 + j) == Const.SHIP) {
            return false;
          }
        }
      }
      break;

    default:
      //non esegue nessuna istruzione
      break;
    }
    return true;
  }

  /**
   * Genera un intero randomico in base al parametro in input.
   * @param maxValue intero massimo dell'insieme.
   * @return info intero computato.
   */
  private int computeInfo(final int maxValue, final Random rand) {
    int info;
    info = rand.nextInt(maxValue) + 1;
    return info;
  }
}
