package ar.com.miura.lc.maxarray

class Solution {
    fun maxSubArray(nums: IntArray): Int {

        var max = nums[0]
        var size = nums.size - 1

        for(i in 1..(size)) {
            nums[i] = Math.max(nums[i], nums[i]+nums[i-1])
            max = Math.max(max, nums[i])
        }
        return max
    }
}