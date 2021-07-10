package ar.com.miura.lc.rimage
class Solution {
    fun rotate(matrix: Array<IntArray>): Unit {

        val rows = matrix.size
        val cols = matrix.get(0).size
        val newMatrix = Array(rows) { IntArray(cols)}

        var i =0
        while(i<rows) {
            var j = 0
            while(j<cols) {
                var value = matrix.get(i).get(j)
                val intArray = newMatrix.get(i)
                intArray[j]=value
                j++
            }
            i++
        }

        var delta = rows-1
        for(i in 0..(cols-1)) {
            for(j in 0..(rows-1)) {
                matrix[i][j] = newMatrix[j][i]
            }

        }

        for(j in 0..(rows-1)) {
            var start=0
            var end=cols-1

            while(start<end) {

                var temp=matrix[j][end]

                matrix[j][end]=matrix[j][start]
                matrix[j][start]=temp

                start++
                end--
            }
        }
    }
}