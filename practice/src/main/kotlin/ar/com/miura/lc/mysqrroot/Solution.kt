package ar.com.miura.lc.mysqrroot
class Solution {
    fun mySqrt(x: Int): Int {

        var number = x

        var left = 1
        var right = number

        var middle = 1

        var doubleResult = 1.0
        var xLong = x.toLong()

        while(left<=right) {

            middle = left + (right-left)/2
            doubleResult = 1.0 * middle * middle

            if (doubleResult.toLong()==xLong) {
                return middle

            } else if ( doubleResult.toLong() > xLong ) {
                right = middle-1

            } else {
                left = middle+1
            }
        }

        return right

    }
}