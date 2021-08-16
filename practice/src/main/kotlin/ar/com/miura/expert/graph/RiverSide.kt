package ar.com.miura.expert.graph

import java.util.*

class RiverSizes {

    fun riverSizes(matrix: List<List<Int>>): List<Int> {
        var riverSizes = mutableListOf<Int>()

        var rows = matrix.size
        var cols = matrix.get(0).size
        var visited: Array<Array<Boolean>> = Array<Array<Boolean>>(rows, { Array<Boolean>(cols, { false }) })
        for (i in 0..(rows - 1)) {
            for (j in 0..(cols - 1)) {
                if (!visited[i][j]) {
                    dfs(matrix, i, j, visited, riverSizes)
                }
            }
        }
        return riverSizes
    }

    private fun dfs(matrix: List<List<Int>>, i: Int, j: Int, visited: Array<Array<Boolean>>, rivers: MutableList<Int>) {

        //println(" i,j ${i},${j} ")

        var currentSize = 0
        var stack: Stack<IntArray> = Stack<IntArray>()
        stack.push(intArrayOf(i, j))

        while (!stack.isEmpty()) {
            var currentNode = stack.pop()
            var tempI = currentNode[0]
            var tempJ = currentNode[1]
            /*
            Visited avoid the node
            */
            if (visited[tempI][tempJ]) {
                continue
            }
            /*
            Mark as visited
            */
            visited[tempI][tempJ] = true
            /*
            continue
            */
            if (matrix.get(tempI).get(tempJ) == 0) {
                continue
            }
            /*
            it is one
            */
            currentSize++
            var unvisited: MutableList<IntArray> = getUnvisited(matrix, tempI, tempJ, visited)
            for (pair in unvisited) {
                stack.push(pair)
            }
        }

        if (currentSize >= 1) {
            rivers.add(currentSize)
        }
    }

    private fun getUnvisited(
        matrix: List<List<Int>>,
        i: Int,
        j: Int,
        visited: Array<Array<Boolean>>
    ): MutableList<IntArray> {
        var unvisited = mutableListOf<IntArray>()

        var rowQty = matrix.size
        var colQty = matrix.get(i).size

        /*
        up one tile
        */
        if (i >= 1 && !(visited[i - 1][j])) {
            unvisited.add(intArrayOf(i - 1, j))
        }

        /*
        Move to the left
        */
        if ((j > 0) && (!visited[i][j - 1])) {
            unvisited.add(intArrayOf(i, j - 1))
        }

        /*
        Move down
        */
        if (i <= (rowQty - 2) && (!visited[i + 1][j])) {
            unvisited.add(intArrayOf(i + 1, j))
        }

        /*
        Move right
        */
        if ((j <= (colQty - 2)) && (!visited[i][j + 1])) {
            unvisited.add(intArrayOf(i, j + 1))
        }

        return unvisited
    }
}