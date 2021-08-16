package ar.com.miura.lc.binary

/**
 * Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]

Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]

Input: nums = [], target = 0
Output: [-1,-1]
 */
class RangeSearch {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        if (nums.size == 1 && nums[0] == target) {
            return intArrayOf(0, 0)
        }
        if (nums.size == 2) {
            if (nums[0] == target) {
                return getRange(nums, 0, target)

            } else if (nums[1] == target) {
                return getRange(nums, 1, target)

            } else {
                return intArrayOf(-1, -1)
            }
        }


        var range = intArrayOf(-1, -1)

        var left = 0
        var right = nums.size - 1
        while (left < right) {
            var middle = (right - left) / 2 + left
            var middleValue = nums[middle]

            if (middleValue == target) {
                return getRange(nums, middle, target)

            } else if (middleValue < target) {
                left = middle + 1

            } else {
                right = middle - 1

            }
        }
        if (left >= 0 && left < nums.size && nums[left] == target) {
            return getRange(nums, left, target)

        } else if (right >= 0 && right < nums.size && nums[right] == target) {
            return getRange(nums, right, target)

        } else {
            return range

        }

    }

    private fun getRange(nums: IntArray, index: Int, target: Int): IntArray {
        var left = index;
        var right = index

        var max = nums.size - 1

        for (i in (right + 1)..max) {
            if (nums[i] == target) {
                right++
            } else {
                break
            }

        }

        for (i in (left - 1) downTo 0) {
            if (nums[i] == target) {
                left--
            }
        }

        return intArrayOf(left, right)
    }


}