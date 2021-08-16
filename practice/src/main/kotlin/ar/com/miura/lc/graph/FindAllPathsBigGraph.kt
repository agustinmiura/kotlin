package ar.com.miura.lc.graph

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/graph/619/depth-first-search-in-graph/3893/
 */
class FindAllPathsBigGraph {
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

            if (graph.getOrDefault(start, mutableListOf<Int>()).contains(end)) {
                return true;
            }


        }

        var stack: Stack<Int> = Stack<Int>();
        var visited = mutableListOf<Int>();

        stack.push(start);

        while (!stack.isEmpty()) {

            var node = stack.pop();

            if (!visited.contains(node)) {
                visited.add(node);

                if (node == end) {
                    return true;
                }

                var nextNodes = graph.getOrDefault(node, mutableListOf<Int>());
                for (eachNext in nextNodes) {
                    stack.push(eachNext);
                }
            }
        }
        return false;

    }
}