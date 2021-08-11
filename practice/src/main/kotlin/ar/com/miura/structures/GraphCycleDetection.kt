package ar.com.miura.structures

/**
 * Use colour painting of the graph to find
 * the cycle inside of it
 */
class GraphCycleDetection {

    val WHITE = 0
    val GREY = 1
    val BLACK = 2

    fun cycleInGraph(edges: List<List<Int>>): Boolean {

        var nodeQty = edges.size

        var visited = mutableSetOf<Int>()
        var colors = IntArray(nodeQty, {0})

        for(node in 0..(nodeQty-1)) {
            if (colors[node]==WHITE) {
                var containsCycle = containsCycle(edges, node, visited, colors)
                if (containsCycle) {
                    return true
                }
            }
        }
        return false
    }

    private fun containsCycle(edges: List<List<Int>>, node:Int, visited:MutableSet<Int>, colors:IntArray):Boolean {

        /**
        Mark node as visited
        and color GREY
         **/
        visited.add(node)
        colors[node] = GREY

        var adjacentList = edges.get(node)
        for(eachNear in adjacentList) {
            if (colors[eachNear]==GREY) {
                return true

            } else if (colors[eachNear]==BLACK) {
                continue

            } else {
                var result = containsCycle(edges, eachNear, visited, colors)
                if (result) {
                    return true
                }
            }

        }
        colors[node] = BLACK
        return false
    }
}