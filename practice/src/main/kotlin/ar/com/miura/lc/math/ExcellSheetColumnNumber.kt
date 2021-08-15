package ar.com.miura.lc.math

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/113/math/817/
 */
class ExcellSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {

        var letterToDigit:Map<Char,Int> = mapOf(
            'A' to 1,
            'B' to 2,
            'C' to 3,
            'D' to 4,
            'E' to 5,
            'F' to 6,
            'G' to 7,
            'H' to 8,
            'I' to 9,
            'J' to 10,
            'K' to 11,
            'L' to 12,
            'M' to 13,
            'N' to 14,
            'O' to 15,
            'P' to 16,
            'Q' to 17,
            'R' to 18,
            'S' to 19,
            'T' to 20,
            'U' to 21,
            'V' to 22,
            'W' to 23,
            'X' to 24,
            'Y' to 25,
            'Z' to 26
        )

        var base = 26.0
        var lastIndex = columnTitle.length-1

        var number = 0.0
        var pow = 0
        while(lastIndex>=0) {
            var character = columnTitle.get(lastIndex)
            number += Math.pow(base, pow*1.0)*(letterToDigit.getOrDefault(character,0))
            pow++
            lastIndex--
        }

        return number.toInt()
    }
}