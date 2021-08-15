package ar.com.miura.lc.sorting

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/110/sorting-and-searching/800/
 */
class KLargestElement {
    fun findKthLargest(nums: IntArray, k: Int): Int {
        val comparator = Comparator<Int>{int1,int2 -> int1-int2}
        val pq = PriorityQueue<Int>(nums.size ,{e1:Int,e2:Int -> e1-e2})
        for(v in nums) {
            pq.offer(v)
            if (pq.size>k) {
                pq.poll()
            }
        }
        return pq.poll()
    }
}