package it.uniba.app.FloydGame.UserExceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test per la classe GameDurationNotSetException.
 */
class GameDurationNotSetExceptionTest {
    /**
     * Test per il metodo getMessage
     * della classe GameDurationNotSetException.
     */
    @Test
    void testGameDurationNotSetException() {
        GameDurationNotSetException exception =
            Assertions.assertThrows(GameDurationNotSetException.
            class, () -> {
                throw new GameDurationNotSetException();
            });
        String expectedMessage = "\n--- Comando non valido: "
            + "'/tempo' deve essere succeduto da un numero! ---\n\n";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
