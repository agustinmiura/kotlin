package ar.com.miura.lc.mypow

class Solution {
    fun myPow(x: Double, n: Int): Double {

        if (n==0) {
            return 1.0

        } else if (n>0) {
            return subPow(x,n)

        } else {

            var lowPart = subPow(x,Math.abs(n))
            return 1.0/lowPart

        }

    }

    private fun subPow(x:Double, n:Int):Double {
        var max = n-1
        var acum = 1.0
        for(i in 0..max) {
            acum *= x
        }
        return acum
    }

}