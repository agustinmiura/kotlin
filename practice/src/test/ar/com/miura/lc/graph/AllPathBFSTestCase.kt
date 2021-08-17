package ar.com.miura.lc.graph

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class AllPathBFSTestCase {

    @Test
    fun `should get all paths`() {
        var graph = Array<IntArray>(4, { intArrayOf() })
        graph[0] = intArrayOf(1, 2)
        graph[1] = intArrayOf(3)
        graph[2] = intArrayOf(3)
        graph[3] = intArrayOf()
        var paths = AllPathBFS().allPathsSourceTarget(graph)
        assertEquals(2, paths.size)
    }
}