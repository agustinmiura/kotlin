package ar.com.miura.lc.sorting

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/110/sorting-and-searching/801/
 */
class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {

        var left = 0
        var right = nums.size - 1

        while(left<right) {
            var middle = ((right - left)/2)+left

            var middleValue = getValue(nums,middle)
            var nextValue = getValue(nums, middle+1)
            var beforeValue = getValue(nums, middle-1)


            if (middleValue>nextValue && middleValue>beforeValue) {
                return middle
            }

            if (nextValue > middleValue) {
                left = middle+1

            } else {
                right = middle
            }

        }

        return right
    }

    private fun getValue(nums: IntArray, index:Int):Int {
        if (index==-1 || index==nums.size) {
            return Int.MIN_VALUE
        } else {
            return nums[index]
        }
    }
}