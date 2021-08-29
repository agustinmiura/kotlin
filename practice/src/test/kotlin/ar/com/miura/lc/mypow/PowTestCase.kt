package ar.com.miura.lc.mypow

import ar.com.miura.lc.math.Pow
import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class PowTestCase {

    @Test
    fun `should test max`() {
        assertNotNull(Pow().myPow(1.0, Int.MAX_VALUE))
    }
}