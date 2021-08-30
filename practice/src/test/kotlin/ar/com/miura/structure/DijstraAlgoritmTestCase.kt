package ar.com.miura.structure

import ar.com.miura.structures.DijstraCost
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DijstraAlgoritmTestCase {

    @Test
    public fun `should find the min cost`() {
        var edges: MutableList<MutableList<MutableList<Int>>> =
            MutableList<MutableList<MutableList<Int>>>(6, { mutableListOf() })

        /**
         * Fill the graph
         * to 1, cost 7
         */
        edges.get(0).add(mutableListOf(1, 7))

        /**
         * from 1 to 4,3
         */
        edges.get(1).add(mutableListOf(2, 6))
        edges.get(1).add(mutableListOf(4, 3))
        edges.get(1).add(mutableListOf(3, 20))

        /**
         * from 2 to 3
         */
        edges.get(2).add(mutableListOf(3, 14))

        /**
         * from 3 to 4
         */
        edges.get(3).add(mutableListOf(4, 2))

        val costs = (DijstraCost().dijkstrasAlgorithm(0, edges))
        val expectedCosts = intArrayOf(0, 7, 13, 27, 10, -1)

        println(" The costs are : ${costs} ")

        for (i in 0..(expectedCosts.size - 1)) {
            assertTrue(expectedCosts[i].equals(costs[i]))
        }
    }

}