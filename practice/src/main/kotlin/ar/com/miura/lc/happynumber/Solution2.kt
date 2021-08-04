package ar.com.miura.lc.happynumber

class Solution2 {
    fun isHappy(n: Int): Boolean {

        var digits = mutableListOf<Int>()

        var numberMap = mutableMapOf<Int,Int>()

        var number = n

        while(number!=1 && !numberMap.contains(number)) {

            numberMap.put(number,number)
            number = calcSum(extractDigits(number))

        }

        return number==1

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