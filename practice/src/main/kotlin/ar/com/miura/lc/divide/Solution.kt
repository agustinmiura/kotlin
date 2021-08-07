package ar.com.miura.lc.divide

class BestSolution {

    fun divide(dividend: Int, divisor: Int): Int {

        var sign = 1
        if ( (dividend>0 && divisor<0) || (dividend<0 && divisor>0 ) ) {
            sign = -1
        }

        var dividendLong:Long = Math.abs(dividend.toLong())
        var divisorLong:Long = Math.abs(divisor.toLong())

        if (divisorLong==0.toLong()) { return Integer.MAX_VALUE }
        if ( (dividendLong==0.toLong()) || (dividendLong<divisorLong) ) { return 0 }

        var result:Long = divideExp(dividendLong, divisorLong)
        if (result > Integer.MAX_VALUE.toInt()) {
            result = if (sign == 1) { Int.MAX_VALUE.toLong() } else { Int.MIN_VALUE.toLong() }

        } else {
            result.toInt() * sign

        }
        return result.toInt()
    }

    private fun divideExp(dividend:Long, divisor:Long):Long {

        if (dividend<divisor) {
            return 0.toLong()
        }

        var sum:Long = divisor
        var multiple:Long = 1.toLong()
        while( (sum+sum) <= dividend ) {
            sum += sum
            multiple += multiple
        }
        return multiple + divideExp(dividend-sum, divisor)

    }

}