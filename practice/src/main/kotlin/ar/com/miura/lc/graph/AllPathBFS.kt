package ar.com.miura.lc.graph

import java.util.*

class AllPathBFS {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        var paths = mutableListOf<MutableList<Int>>()
        var queue: Queue<MutableList<Int>> = LinkedList<MutableList<Int>>()
        queue.offer(mutableListOf<Int>(0))

        while(!queue.isEmpty()) {

            var path = queue.poll()
            var lastNode = path.get(path.size-1)
            if (lastNode==graph.size-1) {
                paths.add(path)
            } else {

                var nextNodes = graph.get(lastNode)
                for(node in nextNodes) {
                    var newPath = path.toMutableList()
                    newPath.add(node)
                    queue.offer(newPath)
                }
            }
        }

        return paths
    }
}