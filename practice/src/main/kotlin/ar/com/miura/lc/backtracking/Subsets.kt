package ar.com.miura.lc.backtracking

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/109/backtracking/796/
 */
class Subsets {
    fun subsets(nums: IntArray): List<List<Int>> {
        var sets = mutableListOf<MutableList<Int>>()
        backtrack(sets, mutableListOf<Int>(), 0, nums)
        return sets
    }

    private fun backtrack(sets:MutableList<MutableList<Int>>, temp:MutableList<Int>, p:Int, nums:IntArray) {

        if (temp.size>nums.size) {
            return
        }

        var aList = mutableListOf<Int>()
        for(e in temp) {
            aList.add(e)
        }
        sets.add(aList)

        var size = nums.size
        for(i in p..(size-1)) {
            temp.add(nums[i])
            backtrack(sets, temp, i+1, nums)
            temp.remove(nums[i])
        }

    }
}