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
        return recursivePow(x,n)
    }

    private fun recursivePow(x:Double, n:Int):Double {
        if (n==0) {
            return 1.0
        } else {
            var temp = recursivePow(x,n/2)
            if (n%2==0) {
                return temp * temp
            } else {
                return temp * temp * x
            }
        }
    }
}