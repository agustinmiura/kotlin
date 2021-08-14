package ar.com.miura.structure

import ar.com.miura.structures.TopologicalSort
import kotlin.test.Test
import kotlin.test.assertEquals

class TopologicalSortTestCase {

    @Test
    fun `should execute the topological sort`() {

        val jobs = mutableListOf<Int>()
        val deps = mutableListOf<List<Int>>()

        var jobValues = intArrayOf(1,2,3,4)
        for(job in jobValues) {
            jobs.add(job)
        }

        deps.add(mutableListOf(1,3))
        deps.add(mutableListOf(1,2))

        deps.add(mutableListOf(3,2))

        deps.add(mutableListOf(4,2))
        deps.add(mutableListOf(4,3))

        val orderdedNodes = (TopologicalSort().topologicalSort(jobs, deps))
        val expectedNodes = intArrayOf(4,1,3,2)
        for((i,v) in expectedNodes.withIndex()) {
            assertEquals(v, orderdedNodes[i])
        }

    }

}