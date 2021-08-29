package ar.com.miura.lc.fractiontodecimal

import ar.com.miura.lc.math.FractionToDecimal
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class FractionToDecimalTestCase {

    @Test
    fun `should find number 0 divided by 5 `() {
        assertEquals("0.5", FractionToDecimal().fractionToDecimal(1, 2))
    }

    @Test
    fun `should find number 2 divided by 1 `() {
        assertEquals("2", FractionToDecimal().fractionToDecimal(2, 1))
    }

    @Test
    fun `should find number 2 divided by 3 `() {
        assertEquals("0.(6)", FractionToDecimal().fractionToDecimal(2, 3))
    }

    @Test
    fun `should find number 4 divided by 333 `() {
        assertEquals("0.(012)", FractionToDecimal().fractionToDecimal(4, 333))
    }

    @Test
    fun `should find number 1 divided by 5 `() {
        assertEquals("0.2", FractionToDecimal().fractionToDecimal(1, 5))
    }

}