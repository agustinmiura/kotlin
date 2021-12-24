package ar.com.miura.lc.array

class RotateArray {

    fun search(nums: IntArray, target: Int): Int {

        if (nums.size == 0 && nums[0] == target) {
            return 0
        } else if (nums.size == 0 && nums[0] != target) {
            return -1
        }

        /*
        * Find the pivot of the array to know where to search
        *
        * 4, 5, 6, 7, 0, 1, 2 => return 0
        * 7, 0, 1, 2, 3, 5, 6 => rturns 0
        * */
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