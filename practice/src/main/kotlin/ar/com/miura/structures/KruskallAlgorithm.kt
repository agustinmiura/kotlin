package ar.com.miura.structures

import ar.com.miura.structures.UnionFind
import java.util.*

/**
 * https://leetcode.com/explore/learn/card/graph/621/algorithms-to-construct-minimum-spanning-tree/3857/
 */
class KruskallAlgorithm {

    fun minCostConnectPoints(points: Array<IntArray>): Int {
        var size = points.size
        var comparator = Comparator<IntArray> { o1: IntArray, o2: IntArray -> (o1[2] - o2[2]) }
        var pq: PriorityQueue<IntArray> = PriorityQueue<IntArray>(comparator)

        var unionFind = UnionFind(size)

        for (i in 0..size - 1) {
            for (j in (i + 1)..size - 1) {
                var origin = points.get(i)
                var destination = points.get(j)
                var distance = getDistance(origin, destination)
                pq.add(intArrayOf(i, j, distance))
            }
        }

        var result = 0
        var vertexAdded = 0
        while ((!pq.isEmpty()) && vertexAdded < size) {

            var edge = pq.poll()
            var origin = edge[0]
            var destination = edge[1]
            var cost = edge[2]

            if (!unionFind.isConnected(origin, destination)) {
                unionFind.union(origin, destination)
                result += cost
                vertexAdded++
            }
        }

        return result
    }

    private fun getDistance(origin: IntArray, destination: IntArray): Int {
        return Math.abs(origin[0] - destination[0]) + Math.abs(origin[1] - destination[1])
    }

}

