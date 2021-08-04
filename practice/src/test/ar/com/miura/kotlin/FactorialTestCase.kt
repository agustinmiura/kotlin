package ar.com.miura.kotlin

import java.math.BigInteger

class FactorialTestCase {
}

class Solution {
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