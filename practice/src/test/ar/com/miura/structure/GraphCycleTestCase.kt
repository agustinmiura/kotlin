package ar.com.miura.structure

import ar.com.miura.structures.GraphCycleDetection
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class GraphCycleTestCase {

    /**
     * [1,3]            ->0
     * [2,3,4]          ->1
     * [0]              ->2
     * []               ->3
     * [2,5]            ->4
     * []               ->5
     */
    @Test
    fun `should find cycle in graph`() {

        var size = 6
        var edges: MutableList<MutableList<Int>> = MutableList<MutableList<Int>>(6, { mutableListOf<Int>()})

        edges.get(0).add(1)
        edges.get(0).add(3)

        edges.get(1).add(2)
        edges.get(1).add(3)
        edges.get(1).add(4)

        edges.get(2).add(0)

        edges.get(4).add(2)
        edges.get(4).add(5)

        assertEquals(true, GraphCycleDetection().cycleInGraph(edges))

    }

}