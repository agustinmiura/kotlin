package ar.com.miura.lc.fractionaltodecimal


class Solution {
    fun fractionToDecimal(numerator: Int, denominator: Int): String {
        if (numerator === 0) {
            return "0"
        }
        val fraction = StringBuilder()
        if ((numerator < 0) xor (denominator < 0)) {
            fraction.append("-")
        }
        val dividend: Long = Math.abs(numerator.toLong())
        val divisor: Long = Math.abs(denominator.toLong())
        fraction.append((dividend / divisor).toString())
        var remainder = dividend % divisor
        if (remainder == 0L) {
            return fraction.toString()
        }
        fraction.append(".")
        val map: MutableMap<Long, Int> = HashMap()
        while (remainder != 0L) {
            if (map.containsKey(remainder)) {
                fraction.insert(map[remainder]!!, "(")
                fraction.append(")")
                break
            }
            map[remainder] = fraction.length
            remainder *= 10
            fraction.append((remainder / divisor).toString())
            remainder %= divisor
        }
        return fraction.toString()
    }
}