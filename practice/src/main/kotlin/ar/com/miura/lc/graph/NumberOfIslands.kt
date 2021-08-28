package ar.com.miura.lc.graph

import java.util.*;

class NumberOfIslands {

    companion object {
        val VISITED = '2';
        val LAND = '1';
    }

    fun numIslands(grid: Array<CharArray>): Int {
        var rowQty = grid.size;
        var colQty = grid[0].size;

        var count = 0;
        for(i in 0..(rowQty-1)) {
            for(j in 0..(colQty-1)) {
                if (grid[i][j]==LAND) {
                    count++;
                    dfs(grid, i, j);
                }
            }
        }
        return count;
    }

    private fun dfs(grid: Array<CharArray>, currentI:Int, currentJ:Int) {

        var i = currentI;
        var j = currentJ;

        val stack = Stack<IntArray>();
        stack.push(intArrayOf(i,j));

        while(!stack.isEmpty()) {
            var position = stack.pop();
            i = position[0];
            j = position[1];

            /*
            Mark with a 2 as visited
            */
            grid[i][j] = VISITED;

            var adjacents = getAdjacents(grid, i, j);
            for(eachAdjacent in adjacents) {
                stack.push(eachAdjacent);
            }
        }
    }

    private fun getAdjacents(grid: Array<CharArray>, currentI:Int,currentJ:Int):MutableList<IntArray> {

        var rowQty = grid.size;
        var colQty = grid[0].size;

        var adjacents = mutableListOf<IntArray>();

        var i = currentI;
        var j = currentJ;

        /*
        Move up only if i>=1
        */
        if (i>=1 && grid[i-1][j]==LAND) {
            adjacents.add(intArrayOf(i-1,j));
        }
        /*
        Move down only if isn't the last one
        */
        if ( (i<=(rowQty-2)) && grid[i+1][j]==LAND ) {
            adjacents.add(intArrayOf(i+1, j));
        }
        /*
        Move left only if col >=1
        */
        if ( (j>=1) && (grid[i][j-1]==LAND) ) {
            adjacents.add(intArrayOf(i,j-1));
        }
        /*
        Move to the right only if col is less than
        size of the matrix
        */
        if ( (j+2<=colQty && (grid[i][j+1]==LAND)) ) {
            adjacents.add(intArrayOf(i,j+1));
        }

        return adjacents;

    }

}