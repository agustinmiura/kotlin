package ar.com.miura.lc.math.happynumber

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/113/math/815/
 */
class HappyNumber3 {
    fun isHappy(n: Int): Boolean {


        var number = n;

        var slow = number
        var fast = getCalc(getCalc(number))

        while(fast!=1 && fast!=slow) {
            slow = getCalc(slow)
            fast = getCalc(getCalc(fast))
        }

        return fast==1

    }

    fun getCalc(n:Int):Int {
        var digits:MutableList<Int> = extractDigits(n)
        return calcSum(digits)
    }

    fun calcSum(nums:MutableList<Int>):Int {
        return nums.map{it*it}.reduce{y, vars -> y+vars}
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