package ar.com.miura.lc.math

import java.math.BigInteger

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/113/math/816/
 */
class FactorialTrailing {
    fun trailingZeroes(n: Int): Int {
        var factorial = BigInteger.ONE
        for(i in 2..n) {
            factorial = factorial.multiply(BigInteger.valueOf(i.toLong()))
        }

        var zeroCount = 0
        while(factorial.mod(BigInteger.TEN).equals(BigInteger.ZERO)) {
            factorial = factorial.divide(BigInteger.TEN)
            zeroCount++
        }

        return zeroCount
    }
}