package ar.com.miura.structure

import ar.com.miura.structures.KruskallAlgorithm
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class KruskallAlgorithmTestCase {

    @Test
    fun `should find optimun cost`() {
        var points: Array<IntArray> = Array<IntArray>(5, {intArrayOf()})
        points[0] = intArrayOf(0,0)
        points[1] = intArrayOf(2,2)
        points[2] = intArrayOf(3,10)
        points[3] = intArrayOf(5,2)
        points[4] = intArrayOf(7,0)
        var distance = KruskallAlgorithm().minCostConnectPoints(points)
        assertEquals(20, distance)
    }


}