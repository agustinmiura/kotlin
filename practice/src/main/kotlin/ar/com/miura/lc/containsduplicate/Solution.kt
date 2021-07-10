package ar.com.miura.lc.containsduplicate

class Solution {
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