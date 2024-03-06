package it.uniba.app.FloydGame.GameTable;

import it.uniba.app.FloydGame.Ships.ShipMap;
import it.uniba.app.FloydGame.UserExceptions.AlreadyHitException;
import it.uniba.app.FloydGame.Controller.Dispatcher;
import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.Util.Difficulty;
import it.uniba.app.FloydGame.Controller.GameTimeCommand;

/**
 * <<control>> Classe che si occupa di colpire le navi
 * e controllare se sono affondate.
 */
public final class TableController {

  /**
   * Modificatore di accesso che impedisce la creazione di oggetti di tipo.
   */
  private TableController() {
  }

  /**
   * Metodo che permette di colpire le navi.
   * @param x valore che indica la riga della cella da colpire.
   * @param y valore che indica la colonna della cella da colpire.
   * @param completedTab tabella con tutte le navi visibili.
   * @param map Map di navi
   * @throws AlreadyHitException eccezione sollevata quando si prova a
   * colpire la cella già colpita.
   */
 public static void shootShip(final int x, final int y,
    final GameTable completedTab, final ShipMap map, final GameTable playerTab,
     final GameTimeCommand gameTimeCommand)
  throws AlreadyHitException {

    Dispatcher dispatcher = Dispatcher.singletonDispatcher();
    switch (completedTab.getValue(x, y)) {
    case Const.SEA:
      if (playerTab.getValue(x, y) == Const.SEA) {
        throw new AlreadyHitException("\n--- La casella scelta"
          + " è stata già colpita! ---\n\n");
      } else {
        Difficulty.setTurns(Difficulty.getTurns() + 1);
        Difficulty.increaseNumMistakes();
        playerTab.setValue(x, y, Const.SEA);
        dispatcher.showTable(playerTab);
        dispatcher.showTxt(Const.WATER);
        dispatcher.showGameStats(gameTimeCommand);
        break;
      }
    case Const.SHIP:
       if (playerTab.getValue(x, y) == Const.HIT
         || playerTab.getValue(x, y) == Const.SUNK) {
         throw new AlreadyHitException("\n--- La casella scelta"
         + " è stata già colpita! ---\n\n");
      } else {
        Difficulty.setTurns(Difficulty.getTurns() + 1);
        playerTab.setValue(x, y, Const.HIT);
        if (sunkenShip(map, playerTab)) {
          dispatcher.showTable(playerTab);
          dispatcher.showTxt(Const.SUNKEN);
          dispatcher.showGameStats(gameTimeCommand);
        } else {
          dispatcher.showTable(playerTab);
          dispatcher.showTxt(Const.HITTEN);
          dispatcher.showGameStats(gameTimeCommand);
        }
        break;
      }
    default:
      //Non è previsto un caso di default
    }
  }

  /**
   * Metodo che permette di stabilire se una nave è stata affondata.
   * @param map Map di navi
   * @return sunken indica se la nave è stata affondata o no.
   */
  public static boolean sunkenShip(final ShipMap map,
    final GameTable playerTab) {
    boolean sunken = false;
    int tempX;
    int tempY;
    boolean foundShip;
    int shipCount;
    int j;

    for (int i = 1; i <= Const.MAX_INSTANCE; i++) {
      if (map.getShip(i).getStatus()) { //La nave non è affondata?
        shipCount = 0;
        foundShip = false;
        tempX = map.getShip(i).getX();
        tempY = map.getShip(i).getY();

        if (map.getShip(i).getDirection() == 1) { //Caso orizzontale.
          j = 0;
          while (j < map.getShip(i).getShipLength() && !foundShip) {
            if (playerTab.getValue(tempX, tempY + j) == Const.SHIP) {
              foundShip = true;
            } else if (playerTab.getValue(tempX, tempY + j) == Const.HIT) {
              shipCount++;
            }
            j++;
          }
          if (shipCount == map.getShip(i).getShipLength()) {
            sunken = true;
            map.changeStatus(i, true);
            map.changeInstance(shipCount);
            for (int k = 0; k < map.getShip(i).getShipLength(); k++) {
              playerTab.setValue(tempX, tempY + k, Const.SUNK);
            }
          }
        } else if (map.getShip(i).getDirection() == 2) { //Caso verticale.
          j = 0;
          while (j < map.getShip(i).getShipLength() && !foundShip) {
            if (playerTab.getValue(tempX + j, tempY) == Const.SHIP) {
              foundShip = true;
            } else if (playerTab.getValue(tempX + j, tempY) == Const.HIT) {
              shipCount++;
            }
            j++;
          }
          if (shipCount == map.getShip(i).getShipLength()) {
            sunken = true;
            map.changeStatus(i, true);
            map.changeInstance(shipCount);
            for (int k = 0; k < map.getShip(i).getShipLength(); k++) {
              playerTab.setValue(tempX + k, tempY, Const.SUNK);
            }
          }
        }
      }
    }
    return sunken;
  }
}
