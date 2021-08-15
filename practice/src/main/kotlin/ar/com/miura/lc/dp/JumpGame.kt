package ar.com.miura.lc.dp

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/111/dynamic-programming/807/
 */
class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        var max = nums.size-1
        var dist = 0
        for(i in 0..max) {
            dist = Math.max(dist, nums[i])
            if (dist==0&&i!=max) {
                return false
            } else {
                dist--
            }
        }
        return true
    }
}