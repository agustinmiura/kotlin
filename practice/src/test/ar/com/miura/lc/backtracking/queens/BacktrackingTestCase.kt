package ar.com.miura.lc.backtracking.queens

import ar.com.miura.lc.backtracking.Queens
import org.junit.jupiter.api.Test

class BacktrackingTestCase {
    @Test
    fun `should find solutions`() {
        val solutions = Queens().enumerate(4)
    }
}