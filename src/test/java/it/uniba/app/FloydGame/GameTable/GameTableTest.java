package it.uniba.app.FloydGame.GameTable;

import it.uniba.app.FloydGame.Controller.Const;
import it.uniba.app.FloydGame.Ships.ShipMap;
import it.uniba.app.FloydGame.UserExceptions.NullTableException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class GameTableTest {

    /**
     * Test con dimensione standard.
     * Confronta dim e righe.
     */
    @Test
    void testGameTableWithStandardDimension() {
        int dim = Const.STANDARD_DIM_TABLE;
        GameTable gameTable = new GameTable(dim);
        assertEquals(dim, gameTable.getRows(), "Error");
    }

    /**
     * Test con dimensione large.
     * Confronta dim e colonne.
     */
    @Test
    void testGameTableWithLargeDimension() {
        int dim = Const.LARGE_DIM_TABLE;
        GameTable gameTable = new GameTable(dim);
        assertEquals(dim, gameTable.getColumns(), "Error");
    }

    /**
     * Test con dimensione extralarge.
     * Confronta dim e righe.
     */
    @Test
    void testGameTableWithExtraLargeDimension() {
        int dim = Const.EXTRA_LARGE_DIM_TABLE;
        GameTable gameTable = new GameTable(dim);
        assertEquals(dim, gameTable.getRows(), "Error");
    }

    /**
     * Test con dimensione extralarge.
     * Confronta dim e colonne.
     */
    @Test
    void testGameTableWithZeroDimension() {
        int dim = 0;
        GameTable gameTable = new GameTable(dim);
        assertEquals(dim, gameTable.getColumns(), "Error");
    }

    /**
     * Verifica che isNull espella un eccezione
     * passando in input una tabella null.
     */
    @Test
    void testNullTablePassed() {
        GameTable gameTable = null;
        assertThrows(NullTableException.class,
            () -> GameTable.isNull(gameTable), "Error");
    }

    /**
     * Verifica che isNull non espella un eccezione
     * passando in input una tabella creata.
     */
    @Test
    void testNullTableIsNotPassed() {
        GameTable gameTable = new GameTable(Const.STANDARD_DIM_TABLE);
        assertDoesNotThrow(() -> GameTable.isNull(gameTable), "Error");
    }

    /**
     * Verifica il riempimento con una dimensione standard.
     */
    @Test
    void testSetTableStandardDimensions() {
        GameTable gameTable = new GameTable(Const.STANDARD_DIM_TABLE);
        gameTable.setGameTable();

        /*
         * Verifica i valori all'interno del perimetro.
         */
        for (int i = 1; i < gameTable.getRows() - 1; i++) {
            for (int j = 1; j < gameTable.getColumns() - 1; j++) {
                assertEquals(Const.VOID, gameTable.getValue(i, j), "Error");
            }
        }
    }

    /**
     * Verifica che i bordi sulla riga
     * vengano impostati con una dimensione large.
     */
    @Test
    void testSetTableLargeDimensions() {
        GameTable gameTable = new GameTable(Const.LARGE_DIM_TABLE);
        gameTable.setGameTable();

        /*
         * Verifica i valori sulla riga 0.
         */
        for (int i = 0; i < gameTable.getColumns(); i++) {
            assertEquals(Const.BOUND, gameTable.getValue(0, i), "Error");
        }
    }

    /**
     * Verifica che i bordi sulla colonna
     * vengano impostati con una dimensione extralarge.
     */
    @Test
    void testSetTableExtraLargeDimensions() {
        GameTable gameTable = new GameTable(Const.EXTRA_LARGE_DIM_TABLE);
        gameTable.setGameTable();

        /*
         * Verifica i valori sulla colonna 0.
         */
        for (int i = 0; i < gameTable.getRows(); i++) {
            assertEquals(Const.BOUND, gameTable.getValue(i, 0), "Error");
        }
    }

    /**
     * Verifica che la shipMap restituita abbia gli stessi valori
     * della ShipMap restituita dalla funzione.
     */
    @Test
    void testShipMapSetTableLargeDimensions() {
        GameTable gameTable = new GameTable(Const.LARGE_DIM_TABLE);
        gameTable.setGameTable();
        ShipMap s = new ShipMap();
        ShipMap t;

        t = gameTable.setGameTable(s);
        assertEquals(s, t, "Error");
    }

    /**
     * Verifica che setGameTable(s) posizioni i bordi
     * sulla riga n della tabella.
     */
    @Test
    void testShipMapSetTableStandardDimensions() {
        GameTable gameTable = new GameTable(Const.STANDARD_DIM_TABLE);
        ShipMap s = new ShipMap();
        gameTable.setGameTable(s);
        int pos = gameTable.getColumns() - 1;

        /*
         * Verifica i valori sulla riga n.
         */
        for (int i = 0; i < gameTable.getColumns(); i++) {
            assertEquals(Const.BOUND, gameTable.getValue(pos, i), "Error");
        }
    }

    /**
     * Verifica che setGameTable(s) posizioni i bordi
     * sulla colonna n della tabella.
     */
    @Test
    void testShipMapSetTableExtraLargeDimensions() {
        GameTable gameTable = new GameTable(Const.EXTRA_LARGE_DIM_TABLE);
        ShipMap s = new ShipMap();
        gameTable.setGameTable(s);
        int pos = gameTable.getRows() - 1;

        /*
         * Verifica i valori sulla colonna n.
         */
        for (int i = 0; i < gameTable.getRows(); i++) {
            assertEquals(Const.BOUND, gameTable.getValue(i, pos), "Error");
        }
    }

    /**
     * Verifica che setGameTable(s) imposti la flag delle navi.
     */
    @Test
    void testAreShipsSetStandardDim() {
        GameTable gameTable = new GameTable(Const.STANDARD_DIM_TABLE);
        ShipMap s = new ShipMap();
        s = gameTable.setGameTable(s);

        for (int i = 1; i <= s.getMapSize(); i++) {
            assertEquals(true, s.getShip(i).getStatus(), "Error");
        }
    }

    /**
     * Verifica che setGameTable(s) imposti le istanze delle navi.
     */
    @Test
    void testAreInstanceSetStandardDim() {
        GameTable gameTable = new GameTable(Const.STANDARD_DIM_TABLE);
        ShipMap s = new ShipMap();
        s = gameTable.setGameTable(s);

        for (int i = 0; i < s.getListSize(); i++) {
            assertEquals(i + 1, s.getInstance(i), "Error");
        }
    }
}
