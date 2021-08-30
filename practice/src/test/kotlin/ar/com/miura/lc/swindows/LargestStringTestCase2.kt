package ar.com.miura.lc.swindows

import ar.com.miura.lc.swindows.sequence2.Solution
import org.junit.jupiter.api.Test
import kotlin.test.assertTrue

class LargestStringTestCase2 {

    @Test
    fun `should work with common example`() {
        val content = "abcabcbb"
        assertTrue(Solution().lengthOfLongestSubstring(content) == 3)
    }

    @Test
    fun `should fail with common example`() {
        val content = "pwwkew"
        assertTrue(Solution().lengthOfLongestSubstring(content) == 4)
    }

}