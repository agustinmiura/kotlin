package ar.com.miura.kotlin

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ExtractDigitsTestCase {

    @Test
    fun `should extract digits`() {
        assertTrue(extractDigits(100).size==3)
    }

    fun extractDigits(n:Int):MutableList<Int> {

        var digits = mutableListOf<Int>()

        var div = n
        var remainder = n
        while(div>=10) {
            remainder = div % 10
            div = div/10
            digits.add(remainder)
        }
        digits.add(div)

        return digits
    }

}