package ar.com.miura.lc.swindows

import ar.com.miura.lc.swindows.sequence.Solution
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

/**
 * lengthOfLongestSubstring
 */
class LargestStringTestCase {

    @Test
    fun `should find largest sequence`() {
        var string = "PWWKEW"
        assertEquals(3, Solution().lengthOfLongestSubstring(string))
    }
}