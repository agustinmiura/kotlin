package ar.com.miura.lc.graph

import java.util.LinkedList
import java.util.PriorityQueue
import java.util.Queue

/**
 * https://leetcode.com/problems/cut-off-trees-for-golf-event/
 */
class CutTree {
    fun cutOffTree(forest: List<List<Int>>): Int {

        val comparator:Comparator<List<Int>> = Comparator<List<Int>>{l0,l1 -> l0[2]-l1[2]};
        val pq:PriorityQueue<List<Int>> = PriorityQueue<List<Int>>(comparator);

        val m = forest.size;
        val n = forest[0].size;
        for(i in 0..(m-1)) {
            for(j in 0..(n-1)) {
                val list = listOf<Int>(i,j,forest.get(i).get(j));
                pq.add(list)
            }
        }

        val start = intArrayOf(-1,-1);
        var sum = 0;
        while(!pq.isEmpty()) {
            var tree:List<Int> = pq.poll();
            var step = minStep(start, tree, forest);
            if (step<=-1) {
                return -1;
            }
            sum += step;
            start[0] = tree[0];
            start[1] = tree[1];
        }

        return sum;

    }

    private fun minStep(start:IntArray, destination:List<Int>, forest:List<List<Int>>):Int {

        var n = forest.size;
        var m = forest[0].size;

        var step = 0;

        var queue: Queue<IntArray> = LinkedList<IntArray>();

        while(!queue.isEmpty()) {
            var size = queue.size;
            for(i in 0..(size-1)) {
                var current = queue.poll();
                if (current[0]==destination.get(0) && current[1]==destination.get(1)) {
                    return step;
                }
                var adjacents = getAdjacents(current, forest);
                for(adjacent in adjacents) {
                    queue.add(adjacent);
                }
            }
            step++;
        }

        return -1;
    }

    private fun getAdjacents(current:IntArray, forest: List<List<Int>>):List<IntArray> {

        var n = forest.size;
        var m = forest[0].size;

        var i = current[0];
        var j = current[1];

        var visited = Array(n){BooleanArray(m){false}}
        visited[i][j] = true;

        var movements = mutableListOf<IntArray>();

        /*
        right
        */
        if ( (j+1)<m && (!visited[i][j+1]) && forest.get(i).get(j)!=0 ) {
            movements.add(intArrayOf(i,j+1));
        }

        /*
        down
        */
        if ( (i+1<n) && (!visited[i+1][j]) && forest.get(i+1).get(j)!=0 ) {
            movements.add(intArrayOf(i+1,j));
        }

        /*
        left
        */
        if ( (j-1>=0) && (!visited[i][j-1]) && forest.get(i).get(j-1)!=0 ) {
            movements.add(intArrayOf(i,j-1));
        }

        /*
        top
        */
        if ( (i-1>=0) && (!visited[i-1][j]) && (forest.get(i-1).get(j)!=0))  {
            movements.add(intArrayOf(i-1,j));
        }


        return movements.toList();
    }
}