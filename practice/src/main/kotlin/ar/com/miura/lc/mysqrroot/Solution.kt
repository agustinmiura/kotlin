package ar.com.miura.lc.mysqrroot

class Solution {
    fun mySqrt(x: Int): Int {

        var number = x

        var left = 1
        var right = number

        var middle = 1

        while(left<=right) {
            middle = left + (right-left)/2
            var result = middle * middle
            if (result==x) {
                return middle
            } else if (result>x) {
                right = middle-1
            } else {
                left = middle+1
            }
        }

        return right

    }
}