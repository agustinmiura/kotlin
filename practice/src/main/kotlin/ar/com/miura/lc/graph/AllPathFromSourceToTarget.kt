package ar.com.miura.lc.graph

/**
 * https://leetcode.com/explore/learn/card/graph/619/depth-first-search-in-graph/3850/
 */
class AllPathFromSourceToTarget {
    fun allPathsSourceTarget(graph: Array<IntArray>): List<List<Int>> {
        var paths = mutableListOf<MutableList<Int>>()
        dfs(graph, 0, mutableListOf<Int>(), paths)
        return paths
    }

    private fun dfs(graph: Array<IntArray>, node:Int, path:MutableList<Int>, paths: MutableList<MutableList<Int>>) {
        path.add(node)
        if (node==graph.size-1) {
            paths.add(path.toMutableList())
            return
        }
        var nextNodes = graph.get(node)
        for(eachNext in nextNodes) {
            dfs(graph, eachNext, path, paths)
            path.removeAt(path.size-1)
        }
    }

}