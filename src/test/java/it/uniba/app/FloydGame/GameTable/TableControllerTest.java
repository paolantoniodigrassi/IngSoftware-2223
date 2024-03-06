package it.uniba.app.FloydGame.GameTable;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.Controller.GameTimeCommand;
import it.uniba.app.FloydGame.Ships.ShipMap;
import it.uniba.app.FloydGame.UserExceptions.AlreadyHitException;

class TableControllerTest {

    /**
     * Test per colpire una casella di mare vuota.
     */
    @Test
    void testShootShipHitEmptySeaCell() {
        int dim = Const.STANDARD_DIM_TABLE;
        GameTable completedTab = new GameTable(dim);
        GameTable playerTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTimeCommand gameTimeCommand = new GameTimeCommand();

        completedTab.setValue(1, 2, Const.SEA);
        try {
            TableController.shootShip(1, 2, completedTab, map,
                playerTab, gameTimeCommand);
        } catch (AlreadyHitException e) {
            fail("Unexpected AlreadyHitException");
        }
        assertEquals(Const.SEA, playerTab.getValue(1, 2), "Error");
    }

    /**
     * Test per colpire una casella di mare già colpita.
     */
    @Test
    void testShootShipHitAlreadyHitSeaCell() {
        int dim = Const.STANDARD_DIM_TABLE;
        GameTable completedTab = new GameTable(dim);
        GameTable playerTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTimeCommand gameTimeCommand = new GameTimeCommand();

        completedTab.setValue(1, 2, Const.SEA);
        playerTab.setValue(1, 2, Const.SEA);
        try {
            TableController.shootShip(1, 2, completedTab, map,
                playerTab, gameTimeCommand);
            fail("Expected AlreadyHitException, but no exception was thrown");
        } catch (AlreadyHitException e) {
            assertEquals("\n--- La casella scelta è stata già colpita!"
                + " ---\n\n", e.getMessage(), "Error");
        }
    }

    /**
     * Test per colpire una casella contenente una nave.
     */
    @Test
    void testShootShipHitShipCell() {
        int dim = Const.STANDARD_DIM_TABLE;
        GameTable completedTab = new GameTable(dim);
        GameTable playerTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTimeCommand gameTimeCommand = new GameTimeCommand();

        completedTab.setValue(1, 2, Const.SHIP);
        try {
            TableController.shootShip(1, 2, completedTab, map,
                playerTab, gameTimeCommand);
        } catch (AlreadyHitException e) {
            fail("Unexpected AlreadyHitException");
        }
        assertEquals(Const.HIT, playerTab.getValue(1, 2), "Error");
    }

    /**
     * Test per colpire una casella contenente una nave già colpita.
     */
    @Test
    void testShootShipHitAlreadyHitShipCell() {
        int dim = Const.STANDARD_DIM_TABLE;
        GameTable completedTab = new GameTable(dim);
        GameTable playerTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTimeCommand gameTimeCommand = new GameTimeCommand();

        completedTab.setValue(1, 2, Const.SHIP);
        playerTab.setValue(1, 2, Const.HIT);
        try {
            TableController.shootShip(1, 2, completedTab, map,
                playerTab, gameTimeCommand);
            fail("Expected AlreadyHitException, but no exception was thrown");
        } catch (AlreadyHitException e) {
            assertEquals("\n--- La casella scelta è stata già colpita!"
                + " ---\n\n", e.getMessage(), "Error");
        }
    }

    /**
     * Test per colpire una casella contenente una nave affondata.
     */
    @Test
    void testShootShipHitAlreadyHitSunkenCell() {
        int dim = Const.STANDARD_DIM_TABLE;
        GameTable completedTab = new GameTable(dim);
        GameTable playerTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTimeCommand gameTimeCommand = new GameTimeCommand();

        completedTab.setValue(1, 2, Const.SHIP);
        playerTab.setValue(1, 2, Const.SUNK);
        try {
            TableController.shootShip(1, 2, completedTab, map,
                playerTab, gameTimeCommand);
            fail("Expected AlreadyHitException, but no exception was thrown");
        } catch (AlreadyHitException e) {
            assertEquals("\n--- La casella scelta è stata già colpita!"
                + " ---\n\n", e.getMessage(), "Error");
        }
    }

    /**
     * Test limite per colpire l'angolo in alto a sinistra della tabella.
     */
    @Test
    void testShootShipUpperLeftCorner() {
        int dim = Const.STANDARD_DIM_TABLE;
        int x = 1;  //Indice riga
        int y = 1;  //Indice colonna
        GameTable completedTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        GameTimeCommand gameTimeCommand = new GameTimeCommand();
        completedTab.setValue(x, y, Const.SEA);

        //Chiama il metodo shootShip
        try {
            TableController.shootShip(x, y, completedTab, map,
                playerTab, gameTimeCommand);
        } catch (AlreadyHitException e) {
            fail("Unexpected AlreadyHitException");
        }
         assertEquals(Const.SEA, playerTab.getValue(1, 1), "Error");
    }

    /**
     * Test limite per colpire l'angolo in alto a destra della tabella.
     */
    @Test
    void testShootShipUpperRightCorner() {
        int dim = Const.STANDARD_DIM_TABLE;
        int x = 1;  // Indice riga
        int y = dim - 2;  // Indice colonna della penultima colonna
        GameTable completedTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        GameTimeCommand gameTimeCommand = new GameTimeCommand();
        completedTab.setValue(x, y, Const.SEA);

        //Chiama il metodo shootShip
        try {
            TableController.shootShip(x, y, completedTab, map,
                playerTab, gameTimeCommand);
        } catch (AlreadyHitException e) {
            fail("Unexpected AlreadyHitException");
        }
        assertEquals(Const.SEA, playerTab.getValue(1, dim - 2), "Error");
    }

    /**
     * Test limite per colpire l'angolo in basso a sinistra della tabella.
     */
    @Test
    void testShootShipLowerLeftCorner() {
        int dim = Const.STANDARD_DIM_TABLE;
        int x = dim - 2;  // Indice riga della penultima riga
        int y = 1;  // Indice colonna
        GameTable completedTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        GameTimeCommand gameTimeCommand = new GameTimeCommand();
        completedTab.setValue(x, y, Const.SEA);

        //Chiama il metodo shootShip
        try {
            TableController.shootShip(x, y, completedTab, map,
                playerTab, gameTimeCommand);
        } catch (AlreadyHitException e) {
            fail("Unexpected AlreadyHitException");
        }
        assertEquals(Const.SEA, playerTab.getValue(dim - 2, 1), "Error");
    }

    /**
     * Test limite per colpire l'angolo in basso a destra della tabella.
     */
    @Test
    void testShootShipLowerRightCorner() {
        int dim = Const.STANDARD_DIM_TABLE;
        int x = dim - 2;  // Indice riga della penultima riga
        int y = dim - 2;  // Indice colonna della penultima colonna
        GameTable completedTab = new GameTable(dim);
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        GameTimeCommand gameTimeCommand = new GameTimeCommand();
        completedTab.setValue(x, y, Const.SEA);

        //Chiama il metodo shootShip
        try {
            TableController.shootShip(x, y, completedTab, map,
                playerTab, gameTimeCommand);
        } catch (AlreadyHitException e) {
            fail("Unexpected AlreadyHitException");
        }
        assertEquals(Const.SEA, playerTab.getValue(dim - 2, dim - 2), "Error");
    }

    /**
     * Test per una nave non affondata.
     */
    @Test
    void testSunkenShipNonSunkenShip() {
        int dim = Const.STANDARD_DIM_TABLE;
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        List<Integer> cords = new ArrayList<>();

        //Aggiunge una nave non affondata
        cords.add(1);
        cords.add(2);
        cords.add(1);
        map.setValues(2 + 2, cords);
        //Imposta le celle nella tabella con le celle colpite
        playerTab.setValue(1, 2, Const.HIT);
        playerTab.setValue(1, 2 + 1, Const.HIT);
        playerTab.setValue(1, 2 + 2, Const.SHIP);

        //Chiama il metodo sunkenShip
        boolean result = TableController.sunkenShip(map, playerTab);

        //Controlla che la nave non sia affondata
        assertFalse(result, "Error");
    }

    /**
     * Test per una nave affondata orizzontalmente.
     */
    @Test
    void testSunkenShipSunkenHorizontalShip() {
        int dim = Const.STANDARD_DIM_TABLE;
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        List<Integer> cords = new ArrayList<>();

        //Aggiunge una nave affondata
        cords.add(1);
        cords.add(2);
        cords.add(1);
        map.setValues(2 + 2, cords);

        //Imposta le celle nella tabella con le celle colpite
        playerTab.setValue(1, 2, Const.HIT);
        playerTab.setValue(1, 2 + 1, Const.HIT);
        playerTab.setValue(1, 2 + 2, Const.HIT);

        //Chiama il metodo sunkenShip
        boolean result = TableController.sunkenShip(map, playerTab);

        //Controlla che la nave sia affondata
        assertTrue(result, "Error");
    }

    /**
     * Test per le celle di una nave affondata orizzontalmente.
     */
    @Test
    void testSunkenShipSunkenHorizontalShipCells() {
        int dim = Const.STANDARD_DIM_TABLE;
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        List<Integer> cords = new ArrayList<>();

        //Aggiunge una nave affondata
        cords.add(1);
        cords.add(2);
        cords.add(1);
        map.setValues(2 + 2, cords);

        //Imposta le celle nella tabella con le celle colpite
        playerTab.setValue(1, 2, Const.HIT);
        playerTab.setValue(1, 2 + 1, Const.HIT);
        playerTab.setValue(1, 2 + 2, Const.HIT);

        //Chiama il metodo sunkenShip
        TableController.sunkenShip(map, playerTab);

        //Controlla che la nave sia stata affondata nella tabella
        for (int i = 0; i < Const.IST_INCROCIATORE; i++) {
            assertEquals(Const.SUNK, playerTab.getValue(1, 2 + i), "Error");
        }
    }

    /**
     * Test per una nave affondata verticalmente.
     */
    @Test
    void testSunkenShipSunkenVerticalShip() {
        int dim = Const.STANDARD_DIM_TABLE;
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        List<Integer> cords = new ArrayList<>();

        //Aggiunge una nave affondata
        cords.add(1);
        cords.add(2);
        cords.add(2);
        map.setValues(2 + 2, cords);

        //Imposta le celle nella tabella con le celle colpite
        playerTab.setValue(1, 2, Const.HIT);
        playerTab.setValue(2, 2, Const.HIT);
        playerTab.setValue(2 + 1, 2, Const.HIT);

        //Chiama il metodo sunkenShip
        boolean result = TableController.sunkenShip(map, playerTab);

        //Controlla che la nave sia affondata
        assertTrue(result, "Error");
    }

    /**
     * Test per le celle di una nave affondata verticalmente.
     */
    @Test
    void testSunkenShipSunkenVerticalShipCells() {
        int dim = Const.STANDARD_DIM_TABLE;
        ShipMap map = new ShipMap();
        GameTable playerTab = new GameTable(dim);
        List<Integer> cords = new ArrayList<>();

        //Aggiunge una nave affondata
        cords.add(1);
        cords.add(2);
        cords.add(2);
        map.setValues(2 + 2, cords);

        //Imposta le celle nella tabella con le celle colpite
        playerTab.setValue(1, 2, Const.HIT);
        playerTab.setValue(2, 2, Const.HIT);
        playerTab.setValue(2 + 1, 2, Const.HIT);

        //Chiama il metodo sunkenShip
        TableController.sunkenShip(map, playerTab);

        //Controlla che la nave sia stata affondata nella tabella
        for (int i = 0; i < Const.IST_INCROCIATORE; i++) {
            assertEquals(Const.SUNK, playerTab.getValue(1 + i, 2), "Error");
        }
    }
}
