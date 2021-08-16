package ar.com.miura.lc.backtracking

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/109/backtracking/797/
 */
class WordSearch {
    fun exist(board: Array<CharArray>, word: String): Boolean {

        var rows = board.size
        var cols = board[0].size

        for (row in 0..(rows - 1)) {
            for (col in 0..(cols - 1)) {
                var firstChar = board[row][col]
                if (firstChar == word.get(0)) {
                    var find = backtrack(board, row, col, word, 0)
                    if (find) {
                        return true
                    }
                }
            }
        }
        return false

    }

    private fun backtrack(board: Array<CharArray>, row: Int, col: Int, word: String, index: Int): Boolean {

        if (index >= word.length) {
            return true
        }

        var rows = board.size
        var cols = board[0].size

        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return false
        }

        if (board[row][col] != word.get(index)) {
            return false
        }

        var originalChar = board[row][col]
        //mark as visited
        board[row][col] = '#'

        var movements = listOf<IntArray>(
            intArrayOf(1, 0),    //up
            intArrayOf(-1, 0),   //down
            intArrayOf(0, -1),   //left
            intArrayOf(0, 1)     //right
        )

        var find = false
        for (movement in movements) {

            var newI = row + movement[0]
            var newJ = col + movement[1]

            find = backtrack(board, newI, newJ, word, index + 1)
            if (find) {
                break
            }

        }
        board[row][col] = originalChar
        return find


    }
}