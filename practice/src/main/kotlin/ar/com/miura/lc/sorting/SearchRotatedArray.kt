package ar.com.miura.lc.sorting

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/110/sorting-and-searching/804/
 */
class SearchRotatedArray {
    fun search(nums: IntArray, target: Int): Int {

        if (nums.size == 0 && nums[0] == target) {
            return 0
        } else if (nums.size == 0 && nums[0] != target) {
            return -1
        }

        var left = 0
        var right = nums.size - 1
        while (left < right) {
            var midpoint = left + (right - left) / 2
            if (nums[midpoint] > nums[right]) {
                left = midpoint + 1
            } else {
                right = midpoint
            }
        }

        var start = left
        left = 0
        right = nums.size - 1

        if (target >= nums[start] && target <= nums[right]) {
            left = start
        } else {
            right = start
        }

        while (left <= right) {
            var midpoint = left + (right - left) / 2
            if (nums[midpoint] == target) {
                return midpoint

            } else if (nums[midpoint] < target) {
                left = midpoint + 1

            } else {
                right = midpoint - 1

            }
        }
        return -1
    }
}