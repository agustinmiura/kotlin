package ar.com.miura.lc.sorting

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/110/sorting-and-searching/803/
 */
class MergedIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {


        var clonedIntervals = intervals.copyOf()
        clonedIntervals.sortBy{ it[0] }

        var merged = mutableListOf<IntArray>()

        for((i,v) in clonedIntervals.withIndex()) {

            if (merged.isEmpty() || v[0]>(merged.last()[1])) {
                merged.add(intArrayOf(v[0], v[1]))

            } else {
                merged.last()[1] = Math.max(merged.last()[1], v[1])

            }

        }

        return merged.toTypedArray()

    }
}