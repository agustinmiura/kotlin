package ar.com.miura.expert.graph

import org.junit.jupiter.api.Test

class DetectArbitrageTestCase {

    @Test
    fun `should detect arbitrage`() {
        var graph = MutableList<MutableList<Double>>(3, {mutableListOf<Double>()})
        graph.set(0, mutableListOf<Double>(-1.0, 0.8631, 0.5903))
        graph.set(1, mutableListOf<Double>(1.1586, 1.0, 0.6849))
        graph.set(2, mutableListOf<Double>(1.6939, 1.46, 1.0))
        assert(DetectArbitrage().detectArbitrage(graph))
    }
}