package ar.com.miura.lc.others

class NearestPoint {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {

        var minDistance = Int.MAX_VALUE
        var minIndex = -1
        for ((index, value) in points.withIndex()) {

            /*
            check if the point is the same
            */
            val samePoint = (x == value[0]) || (y == value[1])
            if (samePoint) {
                val distance = getDistance(x, y, value[0], value[1])
                if (distance < minDistance) {
                    minDistance = distance
                    minIndex = index
                }
            }

        }
        return minIndex

    }

    private fun getDistance(x: Int, y: Int, x1: Int, y1: Int): Int {
        return Math.abs(x - x1) + Math.abs(y - y1)
    }

}