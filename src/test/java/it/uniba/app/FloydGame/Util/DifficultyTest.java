package it.uniba.app.FloydGame.Util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

 class DifficultyTest {

    /**
     * Test con difficoltà "Facile" che controlla il livello di difficoltà.
     */
    @Test
    void testSetDifficultyFacile() {
        final String levelDiff = "/facile";

        Difficulty.setDifficulty(levelDiff, null);

        assertEquals("Facile", Difficulty.getLevel(), "Error");
    }

    /**
     * Test con difficoltà "Facile" e tentativi massimi personalizzati
     * che controlla il numero di errori massimi.
     */
    @Test
    void testSetDifficultyFacileWithMaxAttempts() {
        final String levelDiff = "/facile";
        final Integer userMaxAttempts = 60;

        Difficulty.setDifficulty(levelDiff, userMaxAttempts);

        assertEquals(userMaxAttempts, Difficulty.getMaxMistakes(), "Error");
    }

    /**
     * Test con difficoltà "Medio" che controlla il livello di difficoltà.
     */
    @Test
    void testSetDifficultyMedio() {
        final String levelDiff = "/medio";

        Difficulty.setDifficulty(levelDiff, null);

        assertEquals("Medio", Difficulty.getLevel(), "Error");
    }

    /**
     * Test con difficoltà "Medio" e tentativi massimi personalizzati
     * che controlla il numero di errori massimi.
     */
    @Test
    void testSetDifficultyMedioWithMaxAttempts() {
        final String levelDiff = "/medio";
        final Integer userMaxAttempts = 25;

        Difficulty.setDifficulty(levelDiff, userMaxAttempts);

        assertEquals(userMaxAttempts, Difficulty.getMaxMistakes(), "Error");
    }

    /**
     * Test con difficoltà "Difficile" che controlla il livello di difficoltà.
     */
    @Test
    void testSetDifficultyDifficile() {
        final String levelDiff = "/difficile";

        Difficulty.setDifficulty(levelDiff, null);

        assertEquals("Difficile", Difficulty.getLevel(), "Error");
    }

    /**
     * Test con difficoltà "Difficile" e tentativi massimi personalizzati
     * che controlla il numero di errori massimi.
     */
    @Test
    void testSetDifficultyDifficileWithMaxAttempts() {
        final String levelDiff = "/difficile";
        final Integer userMaxAttempts = 5;

        Difficulty.setDifficulty(levelDiff, userMaxAttempts);

        assertEquals(userMaxAttempts, Difficulty.getMaxMistakes(), "Error");
    }

    /**
     * Test con difficoltà "Personalizzato" e tentativi massimi personalizzati
     * che controlla il livello di difficoltà.
     */
    @Test
    void testSetDifficultyPersonalizzato() {
        final String levelDiff = "/tentativi";
        final Integer userMaxAttempts = 35;

        Difficulty.setDifficulty(levelDiff, userMaxAttempts);

        assertEquals("Personalizzato", Difficulty.getLevel(), "Error");
    }

    /**
     * Test con difficoltà "Personalizzato" e tentativi massimi personalizzati
     * che controlla il numero di errori massimi.
     */
    @Test
    void testSetDifficultyPersonalizzatoWithMaxAttempts() {
        final String levelDiff = "/tentativi";
        final Integer userMaxAttempts = 65;

        Difficulty.setDifficulty(levelDiff, userMaxAttempts);

        assertEquals(userMaxAttempts, Difficulty.getMaxMistakes(), "Error");
    }
}
