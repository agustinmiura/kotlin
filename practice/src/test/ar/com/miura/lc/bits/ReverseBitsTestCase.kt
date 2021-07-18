package ar.com.miura.lc.bits

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals


class ReverseBitsTestCase {

    @Test
    fun `should convert simple number`() {
        /**
         *
         */
        var number:Int = Integer.parseInt("00000010100101000001111010011100", 2)
        var reversed = ReverseBit().reverse(number)
        assertEquals("111001011110000010100101000000", Integer.toBinaryString(reversed))
    }
}