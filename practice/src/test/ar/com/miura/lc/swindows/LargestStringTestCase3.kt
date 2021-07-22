package ar.com.miura.lc.swindows

import ar.com.miura.lc.swindows.sequence3.Solution
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class LargestStringTestCase3 {

    @Test
    fun `shouldFindLength`() {
        assertEquals(3, Solution().lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun `shouldFindLengthInRepeated`() {
        assertEquals(1, Solution().lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun `should find a sequence`() {
        assertEquals(3, Solution().lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun `empty`() {
        assertEquals(0, Solution().lengthOfLongestSubstring(""))
    }

}