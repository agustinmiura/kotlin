package ar.com.miura.lc.singlenumber

class Solution {
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