package ar.com.miura.expert.graph

import java.util.*;

class MinNumPasses {

    fun minimumPassesOfMatrix(matrix: MutableList<MutableList<Int>>): Int {
        var passes = convertNegative(matrix)
        return if (!containsNegative(matrix)) {
            passes - 1
        } else {
            -1
        }
    }

    private fun convertNegative(matrix: MutableList<MutableList<Int>>): Int {

        var nextPassQueue: Queue<IntArray> = getAllPositivePositions(matrix)

        var passes = 0
        while (!nextPassQueue.isEmpty()) {
            var currentPassQueue = nextPassQueue
            nextPassQueue = LinkedList<IntArray>()

            while (!currentPassQueue.isEmpty()) {
                var current: IntArray = currentPassQueue.poll()
                var currentRow = current[0]
                var currentCol = current[1]

                var adjacentPositions = getAdjacents(matrix, currentRow, currentCol)
                for (position in adjacentPositions) {
                    var row = position[0]
                    var col = position[1]
                    var value = matrix[row][col]
                    if (value < 0) {
                        matrix[row][col] = value * -1
                        nextPassQueue.offer(intArrayOf(row, col))
                    }
                }
            }

            passes++

        }

        return passes
    }

    private fun getAllPositivePositions(matrix: MutableList<MutableList<Int>>): Queue<IntArray> {
        var rowQty = matrix.size
        var colQty = matrix.get(0).size

        var queue: Queue<IntArray> = LinkedList<IntArray>()
        for (i in 0..(rowQty - 1)) {
            for (j in 0..(colQty - 1)) {
                var value = matrix.get(i).get(j)
                if (value > 0) {
                    queue.offer(intArrayOf(i, j))
                }
            }
        }
        return queue

    }

    private fun getAdjacents(
        matrix: MutableList<MutableList<Int>>,
        currentRow: Int,
        currentCol: Int
    ): MutableList<IntArray> {

        var rowQty = matrix.size
        var colQty = matrix.get(0).size

        var positions = mutableListOf<IntArray>()

        var i = currentRow
        var j = currentCol

        /*
        top
        */
        if (i - 1 >= 0) {
            positions.add(intArrayOf(i - 1, j))
        }
        /*
        right
        */
        if (j + 1 < colQty) {
            positions.add(intArrayOf(i, j + 1))
        }
        /*
        bottom
        */
        if (i + 1 < rowQty) {
            positions.add(intArrayOf(i + 1, j))
        }
        /*
        left
        */
        if (j - 1 >= 0) {
            positions.add(intArrayOf(i, j - 1))
        }
        return positions
    }

    private fun containsNegative(matrix: MutableList<MutableList<Int>>): Boolean {
        var rowQty = matrix.size
        var colQty = matrix.get(0).size
        for (i in 0..(rowQty - 1)) {
            for (j in 0..(colQty - 1)) {
                var value = matrix.get(i).get(j)
                if (value < 0) {
                    return true
                }
            }
        }
        return false
    }


}