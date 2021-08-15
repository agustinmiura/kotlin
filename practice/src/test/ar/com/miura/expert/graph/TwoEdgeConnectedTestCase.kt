package ar.com.miura.expert.graph

import org.junit.jupiter.api.Test

class TwoEdgeConnectedTestCase {

    @Test
    fun `should check condition`() {
        var edges = MutableList<MutableList<Int>>(6, { mutableListOf<Int>() })
        edges.set(0, mutableListOf(1,2,5))
        edges.set(1, mutableListOf(0,2))
        edges.set(2, mutableListOf(0,1,3))
        edges.set(3, mutableListOf(2,4,5))
        edges.set(4, mutableListOf(3,5))
        edges.set(5, mutableListOf(0,3,4))
        assert(TwoEdgeConnected().twoEdgeConnectedGraph(edges))
    }

    @Test
    fun `should find disconnected graph`() {
        var edges = MutableList<MutableList<Int>>(6, { mutableListOf<Int>() })
        edges.set(0, mutableListOf(1,2,5))
        edges.set(1, mutableListOf(0,2))
        edges.set(2, mutableListOf(0,1,3))
        edges.set(3, mutableListOf(2,4,5))
        edges.set(4, mutableListOf(3,5))
        edges.set(5, mutableListOf(3,4))
        assert(!TwoEdgeConnected().twoEdgeConnectedGraph(edges))
    }

}