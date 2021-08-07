package ar.com.miura.lc.intdivide

import ar.com.miura.lc.divide.BestSolution
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class DivideTestCase {

    @Test
    fun `should divide 10 by 3`() {
        var dividend = 10
        var divisor = 3
        assertEquals(3, BestSolution().divide(10,3))
    }
}