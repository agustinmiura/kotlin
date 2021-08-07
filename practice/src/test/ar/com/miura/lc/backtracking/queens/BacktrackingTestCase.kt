package ar.com.miura.lc.backtracking.queens

import org.junit.jupiter.api.Test

class BacktrackingTestCase {
    @Test
    fun `should find solutions`() {
        val solutions = Solution().enumerate(4)
    }
}