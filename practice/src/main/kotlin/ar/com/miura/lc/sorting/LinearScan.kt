package ar.com.miura.lc.sorting

/**
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 5
 * Explanation: Your function can return either index number 1 where the peak element is 2, or index number 5 where the peak element is 6.
 */
class LinearScan {
    fun findPeakElement(nums: IntArray): Int {

        if (nums.size==1) {
            return 0
        }

        /*
        from left to right
        */
        var max = nums.size/2

        var current = -1
        var next = -1
        var index = 0

        var before = Int.MIN_VALUE
        while(index<max) {



            current = nums[index]
            if (current>before && current>nums[index+1]) {
                return index

            } else {
                before = current
            }
            index++
        }

        var size = nums.size
        next = Integer.MIN_VALUE
        for(i in (size-1) downTo max) {
            current = nums[i]
            if (current > next && current > nums[i-1]) {
                return i

            } else {
                next = current

            }
        }

        return -1
    }
}