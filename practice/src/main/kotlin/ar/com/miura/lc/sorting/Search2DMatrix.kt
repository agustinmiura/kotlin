package ar.com.miura.lc.sorting

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/110/sorting-and-searching/806/
 */
class Search2DMatrix {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var row = 0
        var col = matrix.get(0).size -1

        while(col>=0 && row<matrix.size) {
            if (matrix[row][col]==target) {
                return true
            }
            if (matrix[row][col]>target) {
                col--
            } else {
                row++
            }
        }

        return false
    }
}
