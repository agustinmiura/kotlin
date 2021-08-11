package ar.com.miura.expert.graph

import java.util.*

class RemoveIslands {

    fun removeIslands(matrix: List<MutableList<Int>>): List<MutableList<Int>> {
        var rowQty = matrix.size
        var colQty = matrix.get(0).size

        var visited = MutableList<MutableList<Boolean>>(rowQty, { MutableList<Boolean>(colQty, {false})})

        /*
        Mark the border islands in the cloned matrix
        top border
        */
        for(j in 0..(colQty-1)) {
            dfs(matrix, 0,j, visited)
        }
        /*
        right border
        (0,3)
        (1,3)
        (2,3)
        */
        for(i in 0..(rowQty-1)) {
            dfs(matrix ,i ,colQty-1 ,visited)
        }
        /*
        bottom border
        (3,0),(3,1),(3,1)
        */
        for(j in 0..(colQty-1)) {
            dfs(matrix ,rowQty-1 ,j ,visited)
        }
        /*
        left border
        */
        for(i in 0..(rowQty-1)) {
            dfs(matrix, i, 0, visited)
        }

        for(i in 0..(rowQty-1)) {
            for(j in 0..(colQty-1)) {
                var value = matrix.get(i).get(j)
                if ( value!= 2) {
                    matrix.get(i).set(j,0)
                } else if (value==2) {
                    matrix.get(i).set(j,1)
                }
            }
        }

        return matrix
    }

    private fun dfs(matrix:List<MutableList<Int>>, i:Int, j:Int, visited:MutableList<MutableList<Boolean>>) {

        /*colQty
        Only explore cells not visited and with 1
        */
        var rowQty = matrix.size
        var colQty = matrix.get(0).size

        var canVisit = !visited[i][j] && (matrix.get(i).get(j)==1) && (i>=0 && i<rowQty) && (j>=0 && j<colQty)
        if (!canVisit) {
            return
        }

        /*
        Start dfs here
        */
        var stack = Stack<IntArray>()
        stack.push(intArrayOf(i,j))
        matrix.get(i).set(j, 2)

        while(!stack.isEmpty()) {

            var currentElement:IntArray = stack.pop()
            var currentI = currentElement[0]
            var currentJ = currentElement[1]

            if (!visited[currentI][currentJ]) {
                visited[currentI][currentJ] = true
                matrix.get(currentI).set(currentJ, 2)

                var adjacents = getAdjacents(matrix, currentI, currentJ, visited)
                for(eachAdjacent in adjacents) {
                    stack.push(intArrayOf(eachAdjacent[0], eachAdjacent[1]))
                }
            }
        }

        return
    }

    private fun getAdjacents(matrix:List<MutableList<Int>>, i:Int, j:Int, visited:MutableList<MutableList<Boolean>>):MutableList<IntArray> {

        var rowQty = matrix.size
        var colsQty = matrix.get(0).size

        var positions = mutableListOf<IntArray>()

        /*
        top
        */
        if (i>=1 && !visited[i-1][j] && matrix.get(i-1).get(j)==1) {
            positions.add(intArrayOf(i-1, j))
        }

        /*
        right
        */
        if (j<=(colsQty-2) && !visited[i][j+1] && matrix.get(i).get(j+1)==1) {
            positions.add(intArrayOf(i,j+1))
        }

        /*
        bottom
        */
        if (i<=(rowQty-2) && !visited[i+1][j] && matrix.get(i+1).get(j)==1) {
            positions.add(intArrayOf(i+1,j))
        }

        /*
        left
        */
        if ((j>=1) && !visited[i][j-1] && matrix.get(i).get(j-1)==1) {
            positions.add(intArrayOf(i,j-1))
        }

        return positions
    }

}