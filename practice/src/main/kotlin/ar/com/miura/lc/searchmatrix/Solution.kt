package ar.com.miura.lc.searchmatrix
class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {

        var row:IntArray = matrix.get(0)
        var cols = row.size
        var rows = matrix.size

        var left = 0
        var right = (rows*cols) - 1

        while(left<=right) {

            var middlePoint = left + (right-left)/2
            var middleElement = matrix[middlePoint/cols][middlePoint%cols]

            if (middleElement==target) {
                return true

            } else if (target>middleElement) {
                left = middlePoint + 1

            } else {
                right = middlePoint -1

            }
        }

        return false
    }
}