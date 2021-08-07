package ar.com.miura.lc.sumtwointegers

class Solution {
    fun getSum(a: Int, b: Int): Int {
        var x = Math.abs(a)
        var y = Math.abs(b)
        if (y>x) {
            return getSum(b,a)
        }
        /**
         *
         */
        var result:Int = 0
        if (a*b>=0) {
            result = bitAdd(x,y)
        } else {
            result = bitSubstraction(x,y)
        }
        return result
    }

    /**
     * Add numbers with bit add
     */
    private fun bitAdd(x:Int, y:Int):Int {

        var yValue = y
        var xValue = x

        while(yValue!=0) {
            var answer = xValue xor yValue
            var carry = xValue and yValue shl 1
            xValue = answer
            yValue = carry
        }

        return xValue
    }

    /**
     *
     */
    private fun bitSubstraction(x:Int, y:Int):Int {
       return 0
    }



    /**
     *
     */
    private fun getBit(number:Int, position:Int):Boolean {
        return (number and (1 shl position) !=0)
    }




}