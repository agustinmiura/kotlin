package ar.com.miura.lc.longestsubsequence

import ar.com.miura.lc.longestsequence.SolutionMemoization
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class MemoizationTestCase {

    @Test
    fun `should find the solution`() {
        var nums = intArrayOf(10,9,2,5,3,7,101,18)
        assertEquals(4, SolutionMemoization().lengthOfLIS(nums))
    }

}