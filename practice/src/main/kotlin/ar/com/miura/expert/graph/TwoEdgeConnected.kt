package ar.com.miura.expert.graph

class TwoEdgeConnected {

    private val NOT_ARRIVED = -1

    /**
     * Find if the graph is connected
     */
    fun twoEdgeConnectedGraph(edges: List<List<Int>>, start: Int = 0): Boolean {

        if (edges.size == 0) {
            return true
        }

        var arrivalTimes = IntArray(edges.size, { NOT_ARRIVED })

        if (getMinAmountArrivalTimeOfAncestors(start, -1, 0, arrivalTimes, edges) == NOT_ARRIVED) {
            return false
        }
        return areAllVerticesVisited(arrivalTimes)
    }

    private fun areAllVerticesVisited(arrivalTimes: IntArray): Boolean {
        var found = arrivalTimes.any { it == NOT_ARRIVED }
        return !found
    }

    /**
     *
     */
    private fun getMinAmountArrivalTimeOfAncestors(
        currentVertex: Int,
        parent: Int,
        currentTime: Int,
        arrivalTimes: IntArray,
        edges: List<List<Int>>
    ): Int {
        arrivalTimes[currentVertex] = currentTime

        var minArrivalTime = currentTime

        for (destination in edges[currentVertex]) {
            /**
             * The node hasn't been visited call the
             * function there
             */
            if (arrivalTimes[destination] == -1) {
                minArrivalTime = Math.min(
                    minArrivalTime, getMinAmountArrivalTimeOfAncestors(
                        destination,
                        currentVertex,
                        currentTime + 1,
                        arrivalTimes,
                        edges
                    )
                )
                /**
                 * Vertex has an already been discovered.
                 */
            } else if (destination != parent) {
                minArrivalTime = Math.min(minArrivalTime, arrivalTimes[destination])
            }
        }

        if (minArrivalTime == currentTime && parent != NOT_ARRIVED) {
            return -1
        }

        return minArrivalTime
    }

}