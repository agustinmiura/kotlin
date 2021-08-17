package ar.com.miura.lc.strings

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/879/
 */
class ReverseString {


    private val MAX_VALUE = Int.MAX_VALUE
    private val MIN_VALUE = Int.MIN_VALUE

    fun reverse(x: Int): Int {

        var isNegative = (x < 0)
        var absValue = Math.abs(x)

        var digitList = mutableListOf<Int>()
        var number = absValue
        var digit = -1

        while (number >= 10) {
            digit = number % 10
            number /= 10
            digitList.add(digit)
        }
        digitList.add(number)

        var reversedNumber: Double = 0.0
        var pow = digitList.size
        pow--
        for (eachDigit in digitList) {
            reversedNumber += (eachDigit * Math.pow(10.0, pow * 1.0))
            pow--
        }

        reversedNumber = if (isNegative) {
            reversedNumber * -1
        } else {
            reversedNumber
        }
        reversedNumber = if ((reversedNumber > MAX_VALUE) || (reversedNumber < MIN_VALUE)) {
            0.0
        } else {
            reversedNumber
        }
        return reversedNumber.toInt()
    }
}