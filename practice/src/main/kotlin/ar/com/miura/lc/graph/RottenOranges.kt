package ar.com.miura.lc.graph

import java.util.LinkedList
import java.util.Queue

class RottenOranges {
    fun orangesRotting(grid: Array<IntArray>): Int {

        var freshOranges = 0;
        var queue:Queue<IntArray> = LinkedList<IntArray>();

        var rowQty = grid.size;
        var colQty = grid[0].size;

        for(i in 0..rowQty-1) {
            for(j in 0..colQty-1) {
                if (grid[i][j]==2) {
                    queue.add(intArrayOf(i,j));

                } else if (grid[i][j]==1) {
                    freshOranges++;

                }
            }
        }

        if (freshOranges==0) {
            return 0;
        }

        var iterations = 0;

        while(!queue.isEmpty()) {

            iterations++;

            var size = queue.size;

            for(i in 0..size-1) {
                var pair:IntArray = queue.poll();
                var row = pair[0];
                var col = pair[1];
                var adjacents = getAdjacents(grid, row, col);

                for(adjacent in adjacents) {
                    queue.add(adjacent);
                    grid[adjacent[0]][adjacent[1]] = 2;
                    freshOranges--;
                }


            }

        }


        return if (freshOranges==0) {
            iterations-1;
        } else {
            -1;
        }
    }

    private fun getAdjacents(grid: Array<IntArray>, currentRow:Int, currentCol:Int):List<IntArray> {

        var adjacents = mutableListOf<IntArray>();

        var rowQty = grid.size;
        var colQty = grid[0].size;

        var i = currentRow;
        var j = currentCol;

        /*
        up
        */
        if (i>=1 && grid[i-1][j]==1) {
            adjacents.add(intArrayOf(i-1,j));
        }


        /*
        down
        */
        if (i+1<rowQty && grid[i+1][j]==1) {
            adjacents.add(intArrayOf(i+1,j));
        }

        /*
        left
        */
        if (j-1>=0 && grid[i][j-1]==1) {
            adjacents.add(intArrayOf(i,j-1));
        }


        /*
        right
        */
        if (j+1<colQty && grid[i][j+1]==1) {
            adjacents.add(intArrayOf(i,j+1));
        }



        return adjacents;

    }
}