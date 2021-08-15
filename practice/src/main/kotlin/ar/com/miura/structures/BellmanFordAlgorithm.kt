package ar.com.miura.structures

class BellmanFordAlgorithm {

    private val MAX_DISTANCE = 1000.0

    /**
     *
     */
    fun containsNegativeCycle(graph: List<List<Double>>, start:Int = 0): Boolean {

        var size = graph.size
        var distances = DoubleArray(size, {MAX_DISTANCE})
        distances[start] = 0.0

        for(i in 0..(size-1)) {
            var updated = relaxEdgedAndUpdateDistance(size, graph, distances)
            if (!updated) {
                return false
            }
        }
        var updated = relaxEdgedAndUpdateDistance(size, graph, distances)
        return updated
    }

    private fun relaxEdgedAndUpdateDistance(
        size: Int,
        graph: List<List<Double>>,
        distances: DoubleArray
    ): Boolean {
        var updated = false
        for (source in 0..(size - 1)) {
            var edges = graph.get(source)
            var destination = -1
            for (eachEdge in edges) {
                destination++
                var cost: Double = eachEdge
                var newDistance = distances[source] + cost
                if (newDistance < distances[destination]) {
                    updated = true
                    distances[destination] = newDistance
                }
            }
        }
        return updated
    }
}