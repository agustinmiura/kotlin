package ar.com.miura.expert.graph

import java.util.*

class Bfs {
}

class BfsNode(name: String) {
    val name: String = name
    val children = mutableListOf<BfsNode>()

    fun breadthFirstSearch(): List<String> {
        return bfs()
    }

    private fun bfs():List<String> {

        var bfsResult = mutableListOf<String>()

        var queue:Queue<BfsNode> = LinkedList<BfsNode>()
        queue.add(this)
        var visited = mutableSetOf<String>()

        while(!queue.isEmpty()) {
            var currentNode = queue.poll()
            var number = currentNode.name
            if (!visited.contains(number)) {
                visited.add(number)
                bfsResult.add(number)
                for(adjacent in currentNode.children) {
                    queue.offer(adjacent)
                }
            }
        }
        return bfsResult

    }
}