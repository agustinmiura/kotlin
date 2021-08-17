package ar.com.miura.expert.graph

import ar.com.miura.structures.BellmanFordAlgorithm

class DetectArbitrage {
    fun detectArbitrage(exchangeRates: List<List<Double>>): Boolean {
        /**
         * Clone the graph and apply logarithm
         */
        var size = exchangeRates.size
        var changedGraph = MutableList<MutableList<Double>>(size, { mutableListOf<Double>() })
        for (i in 0..(size - 1)) {
            var changedRates: MutableList<Double> =
                exchangeRates.get(i).map { -1.0 * Math.log(it) } as MutableList<Double>
            changedGraph.set(i, changedRates)
        }
        return BellmanFordAlgorithm().containsNegativeCycle(changedGraph)
    }

}