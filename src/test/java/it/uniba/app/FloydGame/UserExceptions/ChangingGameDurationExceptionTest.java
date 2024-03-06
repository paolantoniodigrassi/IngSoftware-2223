package it.uniba.app.FloydGame.UserExceptions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test per la classe ChangingGameDurationException.
 */
class ChangingGameDurationExceptionTest {
    /**
     * Test per il metodo getMessage
     * della classe ChangingGameDurationException.
     */
    @Test
    void testChangingGameDurationException() {
        ChangingGameDurationException exception =
            Assertions.assertThrows(ChangingGameDurationException.class, () -> {
                throw new ChangingGameDurationException();
            });

        String expectedMessage = "\nImpossibile cambiare il tempo "
            + "di gioco durante il gioco in corso.\n\n";
        String actualMessage = exception.getMessage();

        Assertions.assertEquals(expectedMessage, actualMessage);
    }
}
