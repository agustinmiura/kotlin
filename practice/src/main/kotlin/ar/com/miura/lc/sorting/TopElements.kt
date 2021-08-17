package ar.com.miura.lc.sorting

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/110/sorting-and-searching/799/
 */
class TopElements {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {

        val map = mutableMapOf<Int, Int>()
        for ((i, v) in nums.withIndex()) {
            var count = map.getOrDefault(v, 0)
            count++
            map.put(v, count)
        }

        var pairList = mutableListOf<IntArray>()
        for ((i, v) in map) {
            pairList.add(intArrayOf(i, v))
        }

        pairList.sortBy { -1 * it[1] }


        var rankingArray = IntArray(k) { index -> Int.MIN_VALUE }
        for (i in 0..(k - 1)) {
            rankingArray[i] = pairList.get(i)[0]
        }

        return rankingArray
    }
}