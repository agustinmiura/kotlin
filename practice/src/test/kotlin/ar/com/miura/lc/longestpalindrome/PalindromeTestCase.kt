package ar.com.miura.lc.longestpalindrome

import ar.com.miura.lc.dp.LongestPalindrome
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class PalindromeTestCase {

    @Test
    fun `should find longest sequence`() {
        assertEquals(3, LongestPalindrome().longestPalindrome("babad"))
    }

    @Test
    fun `should find largest string`() {
        var largestString = LongestPalindrome().getString("babad")
        println(largestString)
    }
}