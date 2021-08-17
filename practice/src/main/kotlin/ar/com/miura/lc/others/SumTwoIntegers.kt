package ar.com.miura.lc.others

class SumTwoIntegers {
    fun getSum(a: Int, b: Int): Int {
        var x = Math.abs(a)
        var y = Math.abs(b)
        if (y > x) {
            return getSum(b, a)
        }
        /**
         *
         */
        var result: Int = 0
        if (a * b >= 0) {
            result = bitAdd(x, y)
        } else {
            result = bitSubstraction(x, y)
        }
        return result
    }

    /**
     * Add numbers with bit add
     */
    private fun bitAdd(x: Int, y: Int): Int {

        var yValue = y
        var xValue = x

        while (yValue != 0) {
            var answer = xValue xor yValue
            var carry = xValue and yValue shl 1
            xValue = answer
            yValue = carry
        }

        return xValue
    }

    /**
     * Binary difference
     */
    private fun bitSubstraction(x: Int, y: Int): Int {

        var yValue = Math.abs(y)
        var xValue = Math.abs(x)

        while (yValue != 0) {
            var result = xValue xor yValue
            var borrow = (xValue.inv() and yValue) shl 1
            xValue = result
            yValue = borrow
        }
        return xValue
    }

}