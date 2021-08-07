package ar.com.miura.lc.firstbad

/* The isBadVersion API is defined in the parent class VersionControl.
      def isBadVersion(version: Int): Boolean = {} */
class Solution  {
    private fun firstBadVersion(n: Int) : Int {

        var badIndex = -1
        var left = 1
        var right = n
        var middle = left + (left-right)/2

        while(left<=right) {
            middle = left + (right-left)/2
            if (!isBadVersion(middle)) {
                left = middle+1
            } else {
                right = middle-1
            }
        }
        return left
    }

    private fun isBadVersion(middle: Int): Boolean {
        return false
    }

}