package ar.com.miura.lc.longestpalindrome

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PalindromeTestCase {

    @Test
    fun `should find longest sequence`() {
        assertEquals(3, Solution().longestPalindrome("babad"))
    }

    @Test
    fun `should find largest string`() {
        var largestString = Solution().getString("babad")
        println(largestString)
    }
}