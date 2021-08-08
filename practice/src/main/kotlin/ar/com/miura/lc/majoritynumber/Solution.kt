package ar.com.miura.lc.majoritynumber

class Solution {
    fun majorityElement(nums: IntArray): Int {
        var map = mutableMapOf<Int,Int>()
        var toFind = nums.size/2
        for((i,v) in nums.withIndex()) {

            var qty = map.getOrDefault(v, 0)
            qty++
            map.put(v, qty)
            if (qty>toFind) {
                return v
            }
        }
        return -1
    }
}