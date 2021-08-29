package ar.com.miura.lc.design

class TicTacToe (n: Int) {

    companion object {
        val ONE_PLAYER = 1;
        val TWO_PLAYER = 2;
        val EMPTY_CELL = -1;
        val NO_WINNER = 0;
    }

    /** Initialize your data structure here. */
    private lateinit var board:Array<IntArray>;

    init {
        board = Array<IntArray>(n, { IntArray(n, {-1}) });
    }

    /** Player {player} makes a move at ({row}, {col}).
    @param row The row of the board.
    @param col The column of the board.
    @param player The player, can be either 1 or 2.
    @return The current winning condition, can be either:
    0: No one wins.
    1: Player 1 wins.
    2: Player 2 wins. */
    fun move(row: Int, col: Int, player: Int): Int {

        board[row][col] = player;

        val size = board.size;
        var allEqual = true;
        /**
         * Check horizontal row
         */
        for(j in 0..(size-1)) {
            allEqual = allEqual && (board[row][j]==player);
            if (!allEqual) {
                break;
            }
        }
        /**
         * Check horizontal row
         */
        if (allEqual) {
            return player;
        }
        /**
         * Check vertical part
         */
        allEqual = true;
        for(i in 0..(size-1)) {
            allEqual = allEqual && (board[i][col]==player);
        }
        if (allEqual) {
            return player;
        }

        /**
         * Check the first diagonal diagonal
         */
        allEqual = true;
        for(i in 0..(size-1)) {
            allEqual = allEqual && (board[i][i]==player)
        }
        if (allEqual) {
            return player
        }

        /**
         * Check the other diagonal
         */
        var startingRow = 0;
        var startingCol = size-1;
        allEqual = true && (board[startingRow][startingCol]==player);
        for(j in 0..(size-2)) {
            startingRow++;
            startingCol--;
            allEqual = allEqual && (board[startingRow][startingCol]==player);
        }
        if (allEqual) {
            return player;
        }

        return NO_WINNER;
    }

}