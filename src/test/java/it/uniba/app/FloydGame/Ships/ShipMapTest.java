package it.uniba.app.FloydGame.Ships;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class ShipMapTest {
    /**
     * Verifica che la x venga scritta nella nave in posizione 1.
     */
    @Test
    void testSetXValues() {
        ShipMap shipMap = new ShipMap();
        List<Integer> cords = Arrays.asList(1, 2, 1);
        shipMap.setValues(1, cords);

        assertEquals(cords.get(0), shipMap.getShip(1).getX(), "Error");
    }

    /**
     * Verifica che la y venga scritta nella nave in posizione 1.
     */
    @Test
    void testSetYValues() {
        ShipMap shipMap = new ShipMap();
        List<Integer> cords = Arrays.asList(1, 2, 1);
        shipMap.setValues(1, cords);

        assertEquals(cords.get(1), shipMap.getShip(1).getY(), "Error");
    }

    /**
     * Verifica che la direzione venga scritta nella nave in posizione 1.
     */
    @Test
    void testSetDirectionValues() {
        ShipMap shipMap = new ShipMap();
        List<Integer> cords = Arrays.asList(1, 2, 1);
        shipMap.setValues(1, cords);

        assertEquals(cords.get(2), shipMap.getShip(1).getDirection(), "Error");
    }

    /**
     * Verifica che il metodo espella una NullPointerException in caso
     * venga inserita una key non valida.
     */
    @Test
    void testSetValuesWithInvalidKey() {
        ShipMap shipMap = new ShipMap();
        List<Integer> cords = Arrays.asList(1, 1, 2);

        assertThrows(NullPointerException.class, () -> {
            shipMap.setValues(0, cords); }, "Error");
    }
}
