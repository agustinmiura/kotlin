package ar.com.miura.lc.array

import java.util.*

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
 */
class RemoveDuplicates {
    fun removeDuplicates(nums: IntArray): Int {

        var sortedSet: SortedSet<Int> = TreeSet<Int>();
        for((i,v) in nums.withIndex()) {
            sortedSet.add(v);
        }
        var index = -1;
        for(e in sortedSet) {
            index++;
            nums[index]=e;
        }
        return index+1;
    }
}