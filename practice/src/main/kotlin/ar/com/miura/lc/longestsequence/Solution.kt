package ar.com.miura.lc.longestsequence

class Solution {
    fun lengthOfLIS(nums: IntArray): Int {
<<<<<<< HEAD
        var size = nums.size
        var dp = IntArray(size)
        dp[0] = 1

        var maxSize = 0

        var max = nums.size-1
        for(i in 1..max) {
            var maxValue = 0

            var maxJ = i-1
            for(j in 0..maxJ) {
                if (nums[i]>nums[j]) {
                    maxValue = Math.max(maxValue, dp[j])
                }
            }
            dp[i] = maxValue + 1
            maxSize = Math.max(maxSize, dp[i])
        }
        return maxSize
=======
        return recursiveSequence(nums)
    }
    private fun recursiveSequence(nums:IntArray, index:Int):Int {
        if (index<0) {
            return 0
        }
        if (index==0) {
            return 1
        }
        if (nums[index]>nums[index-1]) {
            return 1 + recursiveSequence(nums,index-1)
        } else {
            return recursiveSequence(nums,index-1)
        }
>>>>>>> c629737 (Added solution)
    }
}