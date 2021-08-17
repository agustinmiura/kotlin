package ar.com.miura.lc.math.happynumber

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/113/math/815/
 */
class HappyNumber1 {
    fun isHappy(n: Int): Boolean {

        var beforeValue = Int.MAX_VALUE
        var rounds = 100
        var number = n
        var digits = mutableListOf<Int>()

        while (rounds >= 0 && number != 1) {
            digits = extractDigits(number)
            number = digits.map { it * it }.reduce { y, vars -> y + vars }
            rounds--
        }

        return (number == 1)
    }

    fun extractDigits(n: Int): MutableList<Int> {

        var digits = mutableListOf<Int>()

        var div = n
        var remainder = n
        while (div >= 10) {
            remainder = div % 10
            div = div / 10
            digits.add(remainder)
        }
        digits.add(div)

        return digits
    }
}