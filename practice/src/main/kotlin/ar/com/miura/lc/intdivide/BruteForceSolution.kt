package ar.com.miura.lc.intdivide

class BruteForceSolution {

    fun divide(dividend: Int, divisor: Int): Int {


        if (dividend==Int.MIN_VALUE && divisor == -1) {
            return Int.MAX_VALUE
        }

        var result = 0

        var dividendNumber = Math.abs(dividend*1.0)
        var divisorNumber = Math.abs(divisor*1.0)

        while(dividendNumber>=divisorNumber) {
            dividendNumber -= divisorNumber
            result++
        }

        return withSign(result, dividend, divisor)
    }

    private fun withSign(result: Int, dividend:Int, divisor:Int): Int {
        if ( (dividend>0&&divisor>0) || (dividend<0&&divisor<0)) {
            return result
        } else {
            return result * -1
        }
    }
}