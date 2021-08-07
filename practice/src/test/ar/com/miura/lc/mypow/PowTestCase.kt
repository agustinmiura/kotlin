package ar.com.miura.lc.mypow

import org.junit.jupiter.api.Test
import kotlin.test.assertNotNull

class PowTestCase {

    @Test
    fun `should test max`() {
        assertNotNull(Solution().myPow(1.0, Int.MAX_VALUE))
    }
}