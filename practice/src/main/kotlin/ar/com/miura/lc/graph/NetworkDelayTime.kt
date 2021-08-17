package ar.com.miura.lc.graph

import java.util.*
import kotlin.Comparator

/**
 * https://leetcode.com/explore/learn/card/graph/622/single-source-shortest-path-algorithm/3863/
 */
class NetworkDelayTime {

    private val MAX_DISTANCE = 101

    fun networkDelayTime(times: Array<IntArray>, n: Int, k: Int): Int {

        /*
        intialize distances array
        */
        var distances:IntArray = IntArray(n+1, {MAX_DISTANCE});
        distances[0]=0;
        distances[k]=0;

        /*
        adjacent list
        vertex -> array[destination,cost];
        build the graph here
        */
        var graph = mutableMapOf<Int, MutableList<IntArray>>();

        for((i,array) in times.withIndex()) {
            var origin = array[0];
            var destination = array[1];
            var cost = array[2];

            var adjacentList = graph.getOrDefault(origin, mutableListOf<IntArray>());
            adjacentList.add(intArrayOf(destination, cost));
            graph.put(origin, adjacentList);
        }

        /*
        pq for Dijstra algorithm
        */
        var comparator = Comparator<IntArray>{v0:IntArray, v1:IntArray -> v0[1]-v1[1]};
        var pq: PriorityQueue<IntArray> = PriorityQueue<IntArray>(comparator);
        pq.offer(intArrayOf(k, 0));

        var visited = mutableSetOf<Int>();
        //visited.add(k);

        while(!pq.isEmpty()) {

            var vertex = pq.poll();
            var destination = vertex[0];
            var cost = vertex[1];

            if (!visited.contains(destination)) {
                visited.add(destination);

                var adjacents = graph.getOrDefault(destination, mutableListOf<IntArray>());
                for(eachAdjacent in adjacents) {
                    /*
                    *       destination(cost)  --->  eachAdjacent()  ;
                    *       eachAdjacent()                           ;
                    *
                    */
                    var adjacentDestination = eachAdjacent[0];
                    var adjacentCost = eachAdjacent[1];

                    var newCost = cost + adjacentCost;

                    if (newCost<distances[adjacentDestination]) {
                        distances[adjacentDestination] = newCost;
                        pq.offer(intArrayOf(adjacentDestination, newCost));
                    }
                }
            }
        }

        var max = Int.MIN_VALUE;
        var findInf = false;
        for((i,v) in distances.withIndex()) {
            max = Math.max(max, v);
            findInf = v==MAX_DISTANCE;
            if (findInf) {
                break;
            }
        }

        if (findInf) {
            return -1;
        } else {
            return max;
        }

    }
}