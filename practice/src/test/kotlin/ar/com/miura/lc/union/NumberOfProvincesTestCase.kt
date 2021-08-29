package ar.com.miura.lc.union

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


/**
 *
 */
class NumberOfProvincesTestCase {
    @Test
    fun `should find number of provinces`() {
        var provinces: Array<IntArray> = Array<IntArray>(4, { IntArray(4) })
        provinces[0] = intArrayOf(1, 1, 0, 0)
        provinces[1] = intArrayOf(1, 1, 0, 1)
        provinces[2] = intArrayOf(0, 0, 1, 0)
        provinces[3] = intArrayOf(0, 1, 0, 1)
        assertEquals(NumberProvinces().findCircleNum(provinces), 2)
    }

}