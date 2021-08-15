package ar.com.miura.lc.bits

import ar.com.miura.lc.others.SumTwoIntegers
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class BitOperatorsTestCase {

    @Test
    fun `should xor bits`() {
        assertEquals(1, 1 xor 0)
        assertEquals(1, 0 xor 1)
        assertEquals(0, 1 xor 1)
        assertEquals(0, 1 xor 1)
    }

    @Test
    fun `should get carry`() {
        assertEquals(0, 1 and 0)
        assertEquals(0, 0 and 1)
        assertEquals(0, 0 and 0)
        assertEquals(1, 1 and 1)
    }

    @Test
    fun `should add numbers with bit add`() {
        assertEquals(4, SumTwoIntegers().getSum(1,3))
    }

}