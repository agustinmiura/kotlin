package ar.com.miura.lc.dp

class LongestSequence {
    fun lengthOfLIS(nums: IntArray): Int {
        var size = nums.size
        var dp = IntArray(size)
        dp[0] = 1

        var maxSize = 0

        var max = nums.size - 1
        for (i in 1..max) {
            var maxValue = 0

            var maxJ = i - 1
            for (j in 0..maxJ) {
                if (nums[i] > nums[j]) {
                    maxValue = Math.max(maxValue, dp[j])
                }
            }
            dp[i] = maxValue + 1
            maxSize = Math.max(maxSize, dp[i])
        }
        return maxSize
    }
}