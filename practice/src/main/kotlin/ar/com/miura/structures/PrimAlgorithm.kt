package ar.com.miura.structures

import java.util.*
import kotlin.Comparator

/**
The array is :0 , 0
The array is :2 , 2
The array is :3 , 10
The array is :5 , 2
The array is :7 , 0
 */
class PrimAlgorithm {

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        var size = points.size
        var comparator = Comparator<IntArray> { o1: IntArray, o2: IntArray -> (o1[2] - o2[2]) }
        var pq: PriorityQueue<IntArray> = PriorityQueue<IntArray>(comparator)
        var visited = mutableSetOf<Int>()
        var result = 0;

        /**
         * Start vertex is zero
         */
        var startNextNodes: IntArray = points[0]
        for (j in 1..(size - 1)) {
            var origin: IntArray = points[0]
            var destination: IntArray = points[j]
            var cost = getDistance(origin, destination)
            pq.offer(intArrayOf(0, j, cost))
        }
        visited.add(0);

        var vertexAdded = 0;
        while( !pq.isEmpty() && vertexAdded<size) {
            var edge = pq.poll();
            var origin = edge[0];
            var destination = edge[1];
            var cost = edge[2];

            if (!visited.contains(destination)) {
                visited.add(destination);
                result += cost;
                /*
                * Add to the pq all the others adjacent to the new one
                * */
                for(j in 0..(size-1)) {
                    if (!visited.contains(j)) {

                        /**
                         * Going from destination_point to j_point
                         *
                         */
                        var newOrigin = points[destination];
                        var newDestination = points[j];
                        var cost = getDistance(newOrigin, newDestination);
                        pq.offer(intArrayOf(destination, j, cost));
                    }
                }
                vertexAdded++;
            }
        }
        return result;
    }

    private fun getDistance(origin: IntArray, destination: IntArray): Int {
        return Math.abs(origin[0] - destination[0]) + Math.abs(origin[1] - destination[1])
    }
}