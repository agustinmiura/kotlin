package ar.com.miura.structure

import ar.com.miura.structures.BellmanFordAlgorithm
import org.junit.jupiter.api.Test

class BellmanFordTestCase {

    /**
     *
     */
    @Test
    fun `shouldDetectNegativeCycle`() {
        var graph = MutableList<MutableList<Double>>(3, { mutableListOf<Double>() })
        graph.set(0, mutableListOf<Double>(1.0, -2.0, -6.0))
        graph.set(1, mutableListOf<Double>(1.0, 1.0, 4.0))
        graph.set(2, mutableListOf<Double>(3.0, 3.0, 1.0))
        var containsCycle = BellmanFordAlgorithm().containsNegativeCycle(graph)
        assert(containsCycle)
    }

}