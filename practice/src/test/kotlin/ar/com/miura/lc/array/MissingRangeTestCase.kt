package ar.com.miura.lc.array

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MissingRangeTestCase {
    @Test
    fun `should find missing ranges`() {
        var ints = intArrayOf(0,1,3,50,75);
        var lower = 0;
        var upper = 99;

        var strings = FindMissingRanges().findMissingRanges(ints, lower, upper)
        assertEquals(4, strings.size)
    }
}