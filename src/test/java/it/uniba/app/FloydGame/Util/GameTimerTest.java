package it.uniba.app.FloydGame.Util;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

/**
 * Test per la classe GameTimer.
 */
class GameTimerTest {
    private static final int GAME_DURATION_TEN = 10;
    private static final int GAME_DURATION_THREE = 3;
    private static final int GAME_DURATION_FIVE = 5;
    private static final int GAME_DURATION_SEVEN = 7;
    private static final int GAME_DURATION_ZERO = 0;
    /**
     * Test per il metodo getElapsedTime
     * della classe GameTimer
     * con tempo trascorso pari a 0
     * e durata del gioco pari a 10.
     */
    @Test
    void testGetElapsedTime() {
        GameTimer timer = new GameTimer(GAME_DURATION_TEN);
        Assertions.assertEquals(GAME_DURATION_ZERO, timer.getElapsedTime());
    }

    /**
     * Test per il metodo incrementElapsedTime
     * della classe GameTimer
     * con tempo trascorso pari a 3
     * e durata del gioco pari a 10.
     */
    @Test
    void testIncrementElapsedTime() {
        GameTimer timer = new GameTimer(GAME_DURATION_TEN);
        timer.incrementElapsedTime();
        timer.incrementElapsedTime();
        timer.incrementElapsedTime();
        Assertions.assertEquals(GAME_DURATION_THREE, timer.getElapsedTime());
    }

    /**
     * Test per il metodo getRemainingTime
     * della classe GameTimer
     * con tempo trascorso pari a 5
     * e durata del gioco pari a 10.
     */
    @Test
    void testSetRemainingTime() {
        GameTimer timer = new GameTimer(GAME_DURATION_TEN);
        timer.setRemainingTime(GAME_DURATION_FIVE);
        Assertions.assertEquals(GAME_DURATION_FIVE, timer.getElapsedTime());
    }

    /**
     * Test per il metodo setElapsedTime
     * della classe GameTimer
     * con tempo trascorso pari a 7
     * e durata del gioco pari a 10.
     */
    @Test
    void testSetElapsedTime() {
        GameTimer timer = new GameTimer(GAME_DURATION_TEN);
        timer.setElapsedTime(GAME_DURATION_SEVEN);
        Assertions.assertEquals(GAME_DURATION_SEVEN, timer.getElapsedTime());
    }

    /**
     * Test per il metodo getRemainingTime
     * della classe GameTimer
     * con tempo trascorso pari a 7
     * e durata del gioco pari a 10.
     */
    @Test
    void testGetRemainingTimeWithNonZeroDuration() {
        GameTimer timer = new GameTimer(GAME_DURATION_TEN);
        timer.incrementElapsedTime();
        timer.incrementElapsedTime();
        timer.incrementElapsedTime();
        Assertions.assertEquals(GAME_DURATION_SEVEN, timer.getRemainingTime());
    }

    /**
     * Test per il metodo getRemainingTime
     * della classe GameTimer
     * con tempo trascorso pari a 0
     * e durata del gioco pari a 0.
     */
    @Test
    void testGetRemainingTimeWithZeroDuration() {
        GameTimer timer = new GameTimer(GAME_DURATION_ZERO);
        Assertions.assertEquals(-1, timer.getRemainingTime());
    }

    /**
     * Test per il metodo getRemainingTime
     * della classe GameTimer
     * con tempo trascorso pari a 0
     * e durata del gioco pari a 10.
     */
    @Test
    void testReset() {
        GameTimer timer = new GameTimer(GAME_DURATION_TEN);
        timer.incrementElapsedTime();
        timer.incrementElapsedTime();
        timer.incrementElapsedTime();
        timer.reset();
        Assertions.assertEquals(GAME_DURATION_ZERO, timer.getElapsedTime());
    }
}
