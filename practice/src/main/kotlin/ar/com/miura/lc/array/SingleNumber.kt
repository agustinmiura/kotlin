package ar.com.miura.lc.array

/**
 * https://leetcode.com/problems/single-number/
 */
class SingleNumber {
    fun singleNumber(nums: IntArray): Int {

        val numberMap:MutableMap<Int,Int> = mutableMapOf()

        for((index,value) in nums.withIndex()) {

            var qty = numberMap.getOrDefault(value,0)
            qty++
            numberMap.put(value,qty)
        }
        for((key,value) in numberMap) {
            if (value==1) {
                return key
            }
        }

        return -1
    }
}