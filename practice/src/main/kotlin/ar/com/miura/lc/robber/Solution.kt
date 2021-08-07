package ar.com.miura.lc.robber

class Solution {
    fun rob(nums: IntArray): Int {

        if (nums.size==1) {
            return nums[0]

        } else if (nums.size==2) {
            return Math.max(nums[0], nums[1])

        } else {

            var dp:IntArray = IntArray(nums.size)
            dp[0] = nums[0]
            dp[1] = Math.max(nums[0], nums[1])

            for(i in 2..(nums.size-1)) {
                var leapMax = nums[i]+dp[i-2]
                var beforeMax = dp[i-1]
                dp[i] = Math.max(leapMax, beforeMax)

            }

            return dp[nums.size-1]

        }
    }
}