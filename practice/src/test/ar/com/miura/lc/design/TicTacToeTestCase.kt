package ar.com.miura.lc.design

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class TicTacToeTestCase {

    /**
     * ["TicTacToe","move","move","move","move","move","move","move"]
    [[3],[0,0,1],[0,2,2],[2,2,1],[1,1,2],[2,0,1],[1,0,2],[2,1,1]]
    Your answer
    [null,  0,      0,       0,     0,      1,      0,      1]
     */
    @Test
    fun `should play tic tac toe`() {

        var game = TicTacToe(3);

        /*
        * [0,0,1]
        **/
        var result = game.move(0,0,1);
        assertEquals(0, result);

        /**
         * [0,2,2]
         * 0
         */
        result = game.move(0,2,2);
        assertEquals(0, result);

        /**
         * [2,2,1]
         * 0
         */
        result = game.move(2,2,1);
        assertEquals(0, result);

        /**
         * [1,1,2]
         * 0
         */
        result = game.move(1,1,2);
        assertEquals(0, result);

        /**
         * [2,0,1]
         * 1
         */
        result = game.move(2,0,1);
        assertEquals(0, result);

        /**
         * [1,0,2]
         */
        result = game.move(1,0,2);
        assertEquals(0, result);

        /**
         * [2,1,1]
         */
        result = game.move(2,1,1);
        assertEquals(1, result);

    }

}