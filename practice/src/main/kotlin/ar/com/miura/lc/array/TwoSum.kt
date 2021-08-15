package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 */
class TwoSum {

    fun twoSum(nums: IntArray, target: Int): IntArray {

        val ints:MutableMap<Int,Int> = mutableMapOf()

        for((i,v) in nums.withIndex()) {
            val remainder = target-v
            ints.put(v, remainder)
        }

        val max = nums.size
        var first=-1
        var second = -1
        for((i,v) in nums.withIndex()) {
            first = i
            val toFind = ints.get(v)
            var j = i+1
            while(j<max) {
                if (nums[j]==toFind) {
                    return intArrayOf(first,j)
                }
                j++
            }
        }
        return intArrayOf()
    }

}