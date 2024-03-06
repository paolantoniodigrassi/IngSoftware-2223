package it.uniba.app.FloydGame.Ships;
import java.util.Map;
import it.uniba.app.FloydGame.Controller.Const;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * <<Entity>> Classe contenitore di navi e loro istanze.
 */
public class ShipMap {
    /**
     * Map che contiene le navi.
     */
    private Map<Integer, Ship> shipMap;
    /**
     * Lista che contiene le istanze.
     */
    private List<Integer> ist;

/**
     * Costruttore della classe ShipMap,
     * istanzia le 10 navi.
     */
    public ShipMap() {
        shipMap = new HashMap<>();
        ist = new ArrayList<>();
        loadList();
        loadMap();
    }

    /**
     * Popola la lista con le istanze di ogni nave
     */
    private void loadList() {
        ist.add(Const.IST_PORTAEREI);
        ist.add(Const.IST_CORAZZATA);
        ist.add(Const.IST_INCROCIATORE);
        ist.add(Const.IST_CACCIATORPEDINIERE);
    }

    /**
     * Popola la Map con le istanze di ogni nave
     */
    private void loadMap() {
        int i = 1;
        shipMap.put(i++, new Ship(Const.SHIP1, Const.DIM_PORTAEREI));
        for(int j=0; j<2; j++) {
            shipMap.put(i++, new Ship(Const.SHIP2, Const.DIM_CORAZZATA));
        }
        for(int j=0; j<3; j++) {
            shipMap.put(i++, new Ship(Const.SHIP3, Const.DIM_INCROCIATORE));
        }
        for(int j=0; j<4; j++) {
            shipMap.put(i++, new Ship(Const.SHIP4, Const.DIM_CACCIATORPEDINIERE));
        }
    }


   /**
     * Metodo che estrae una nave specifica dalla map.
     * @param key chiave dell'elemento da estrarre
     * @return Ship nave estratta
     */
    public Ship getShip(final Integer key) {
        return shipMap.get(key);
    }

    /**
     * Metodo che estrare le istanze della nave.
     * @param pos posizione nella lista
     * @return istanza
     */
    public int getInstance(final int pos) {
        return ist.get(pos);
    }

    /**
     * Metodo che estrae la dimensione della Map.
     * @return shipMap.size() dimensione.
     */
    public final int getMapSize() {
        return shipMap.size();
    }

    /**
     * Metodo che estrae la dimensione della lista.
     * @return ist.size() dimensione.
     */
    public final int getListSize() {
        return ist.size();
    }

    /**
     * Metodo che imposta dei valori precisi.
     * @param key chiave dell'elemento da estrarre
     */
    public void setValues(final Integer key, final List<Integer> cords) {
        getShip(key).setX(cords.get(0));
        getShip(key).setY(cords.get(1));
        getShip(key).setDirection(cords.get(2));
    }

    /**
     * Metodo che permette di impostare le istanze di una nave.
     * @param pos posizione nella lista
     * @param numIst nuovo numero di istanze
     */
    public void setInstance(final int pos, final int numIst) {
        ist.set(pos, numIst);
    }

    /**
     * Metodo che permette di cambiare lo status di una nave.
     * @param pos posizione nella lista
     * @param status nuovo status della nave
     */
    public void changeStatus(final int pos, final boolean status) {
        getShip(pos).setStatus(status);
    }

    /**
     * Metodo che permette di ridurre le istanze delle navi.
     * @param shipCount dimensione della nave.
     */
    public void changeInstance(final int shipCount) {
        switch (shipCount) { //Riduzione numero di istanze.
        case Const.DIM_PORTAEREI:
            setInstance(0, getInstance(0) - 1);
            break;
        case Const.DIM_CORAZZATA:
            setInstance(1, getInstance(1) - 1);
            break;
        case Const.DIM_INCROCIATORE:
            setInstance(2, getInstance(2) - 1);
            break;
        case Const.DIM_CACCIATORPEDINIERE:
            setInstance(3, getInstance(3) - 1);
            break;
        default:
            //Non è previsto un caso di default.
        }
    }

    /**
     * Controlla se il giocatore ha vinto la partita.
     * @return flag indica l'esito del controllo delle istanze
     */
    public final boolean checkGameStatus() {
        boolean flag = false;
        Iterator<Integer> i = ist.iterator();
        while (i.hasNext()) {
            if (i.next().equals(0)) {
                flag = true;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
