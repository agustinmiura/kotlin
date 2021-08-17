package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/103/array-and-strings/777/
 */
class SetMatrixZeroes {
    fun setZeroes(matrix: Array<IntArray>): Unit {

        /*
          j------
        i ----
        */
        var rows = mutableSetOf<Int>()
        var cols = mutableSetOf<Int>()

        for (i in 0..(matrix.size - 1)) {
            var row = matrix[i]
            var rowSize = row.size
            for (j in 0..(rowSize - 1)) {
                if (matrix[i][j] == 0) {
                    rows.add(i)
                    cols.add(j)
                }
            }
        }

        for (row in rows) {
            clearRow(matrix, row)
        }

        for (col in cols) {
            clearCol(matrix, col)
        }

    }

    private fun clearRow(matrix: Array<IntArray>, row: Int) {
        var rowSelected = matrix[row]
        for (j in 0..(rowSelected.size - 1)) {
            matrix[row][j] = 0
        }
    }

    private fun clearCol(matrix: Array<IntArray>, col: Int) {
        var size = matrix.size
        for (i in 0..(size - 1)) {
            matrix[i][col] = 0
        }
    }
}