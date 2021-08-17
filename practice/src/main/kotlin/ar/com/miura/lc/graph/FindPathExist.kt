package ar.com.miura.lc.graph

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/graph/620/breadth-first-search-in-graph/3894/
 */
class FindPathExist {
    fun validPath(n: Int, edges: Array<IntArray>, start: Int, end: Int): Boolean {
        var graph = mutableMapOf<Int, MutableList<Int>>()

        /**
         * create the graph adjacent list
         **/
        for ((i, array) in edges.withIndex()) {
            var origin = array.get(0);
            var destination = array.get(1);

            var nextNodes = graph.getOrDefault(origin, mutableListOf<Int>())
            nextNodes.add(destination);
            graph.put(origin, nextNodes);

            nextNodes = graph.getOrDefault(destination, mutableListOf<Int>());
            nextNodes.add(origin)
            graph.put(destination, nextNodes);


        }

        var queue: Queue<Int> = LinkedList<Int>();
        var visited = mutableListOf<Int>();

        queue.offer(start);

        while (!queue.isEmpty()) {

            var node = queue.poll();

            if (!visited.contains(node)) {
                visited.add(node);

                if (node == end) {
                    return true;
                }

                var nextNodes = graph.getOrDefault(node, mutableListOf<Int>());
                for (eachNext in nextNodes) {
                    queue.offer(eachNext);
                }
            }
        }
        return false;

    }
}