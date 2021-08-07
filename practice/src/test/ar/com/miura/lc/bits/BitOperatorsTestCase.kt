package ar.com.miura.lc.bits

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

}