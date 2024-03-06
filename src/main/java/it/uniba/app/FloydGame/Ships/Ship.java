package it.uniba.app.FloydGame.Ships;

/**
 * <<Entity>> La classe definisce le caratteristiche delle navi.
 */
public class Ship {
    private final String shipName;
    private final int shipLength;
    private boolean status;
    private int direction;
    private int x;
    private int y;

    /**
     * Costruttore della classe Ship.
     * @param name   il nome della nave
     * @param length la lunghezza della nave
     */
    Ship(final String name, final int length) {
        this.shipName = name;
        this.shipLength = length;
        status = true;
    }

    /**
     * Restituisce il nome della nave.
     * @return il nome della nave
     */
    public final String getShipName() {
        return shipName;
    }

    /**
     * Restituisce la lunghezza della nave.
     * @return la lunghezza della nave
     */
    public final int getShipLength() {
        return shipLength;
    }

    /**
     * Restituisce lo stato della nave.
     * @return lo stato della nave
     */
    public boolean getStatus() {
        return status;
    }

    /**
     * Imposta lo stato della nave.
     * @param stat lo stato della nave da impostare
     */
    public void setStatus(final boolean stat) {
        this.status = stat;
    }

    /**
     * Restituisce la direzione della nave.
     * @return la direzione della nave
     */
    public int getDirection() {
        return direction;
    }

    /**
     * Imposta la direzione della nave.
     * @param d direzione
     */
    public void setDirection(final int d) {
        this.direction = d;
    }

    /**
     * Restituisce la coordinata x della nave.
     * @return la coordinata x della nave
     */
    public int getX() {
        return x;
    }

    /**
     * Imposta la coordinata x della nave.
     * @param cordX la coordinata x della nave da impostare
     */
    public void setX(final int cordX) {
        this.x = cordX;
    }

    /**
     * Restituisce la coordinata y della nave.
     * @return y la coordinata y della nave
     */
    public int getY() {
        return y;
    }

    /**
     * Imposta la coordinata y della nave.
     * @param cordY la coordinata y della nave da impostare
     */
    public void setY(final int cordY) {
        this.y = cordY;
    }
}
