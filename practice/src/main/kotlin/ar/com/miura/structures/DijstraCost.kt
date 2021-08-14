package ar.com.miura.structures

import java.util.*

class DijstraCost {

    private val MAX_COST = 10000

    fun dijkstrasAlgorithm(start: Int, edges: List<List<List<Int>>>): List<Int> {

        var costs = IntArray(edges.size, {MAX_COST})
        costs[start] = 0

        val comparator = Comparator<IntArray> {i1:IntArray, i2:IntArray -> i1[1]-i2[1] }
        var pq: PriorityQueue<IntArray> = PriorityQueue<IntArray>(comparator)
        pq.add(intArrayOf(start,0))

        var visited = mutableSetOf<Int>()

        while(!pq.isEmpty()) {
            var pair = pq.poll()
            var vertex = pair[0]
            var cost = pair[1]

            /**
             * Only go if it hasn't been visited
             */
            if (!visited.contains(vertex)) {
                visited.add(vertex)

                var connectedVertex = edges.get(vertex)
                for(eachList in connectedVertex) {
                    var destination = eachList.get(0)
                    var adjacentCost = eachList.get(1)

                    var newCost = cost + adjacentCost
                    if (newCost<costs[destination]) {
                        costs[destination] = newCost
                        pq.add(intArrayOf(destination, newCost))
                    }
                }
            }
        }

        return costs.toList()
    }

}

