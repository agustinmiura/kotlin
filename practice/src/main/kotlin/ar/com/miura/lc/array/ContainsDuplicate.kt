package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/578/
 */
class ContainsDuplicate {
    fun containsDuplicate(nums: IntArray): Boolean {

        val intSet:MutableSet<Int> = mutableSetOf()

        for((index,value) in nums.withIndex()) {

            if (!intSet.contains(value)) {
                intSet.add(value)
            } else {
                return true
            }
        }
        return false
    }
}