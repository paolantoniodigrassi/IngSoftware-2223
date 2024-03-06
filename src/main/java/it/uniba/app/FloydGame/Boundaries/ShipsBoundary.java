package it.uniba.app.FloydGame.Boundaries;
import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.Ships.Ship;
import it.uniba.app.FloydGame.Ships.ShipMap;
/**
 * <<Boundary>> La classe mostra il tipo e il numero di navi da affondare.
 */
public final class ShipsBoundary {

  /**
   * Modificatore di accesso che impedisce la creazione di oggetti di tipo.
   */
  private ShipsBoundary() {
  }

  /**
   * Metodo che stampa le navi.
   */
  public static void printShips(final ShipMap shipMap) {
    String s = "\n";

    int i = 0;
    int j = 0;

    j += 1;
    s += shiptoString(shipMap.getShip(j)) + shipMap.getInstance(i) + " \n";

    j += 1;
    i++;
    s += shiptoString(shipMap.getShip(j)) + shipMap.getInstance(i) + " \n";

    j += 2;
    i++;
    s += shiptoString(shipMap.getShip(j)) + shipMap.getInstance(i) + " \n";

    j += 2 + 1;
    i++;
    s += shiptoString(shipMap.getShip(j)) + shipMap.getInstance(i) + " \n";

    System.out.println(s);
  }

  /**
   * Metodo che trasforma in stringa la singola nave.
   * @param ship nave da trasformare.
   * @return s stringa.
   */
  private static String shiptoString(final Ship ship) {
    String s = "";

    s += ship.getShipName();

    if (!s.equals(Const.SHIP4)) {
      s += " \t\t";
    } else {
      s += " \t";
    }

    for (int i = 0; i < ship.getShipLength(); i++) {
      s += Const.MARKED_SHIP;
    }

    if (!ship.getShipName().equals(Const.SHIP1)) {
      if (ship.getShipName().equals(Const.SHIP4)) {
        s += " \t\t\t";
      } else {
        s += " \t\t";
      }
    } else {
      s += " \t";
    }

    return s;
  }
}

