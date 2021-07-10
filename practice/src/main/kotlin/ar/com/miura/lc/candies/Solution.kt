package ar.com.miura.lc.candies

class Solution {
    fun distributeCandies(candyType: IntArray): Int {

        val size = candyType.size
        val maxQty = size/2

        var qtyToEat = 0

        val intSet:MutableSet<Int> = mutableSetOf()
        for((index,value) in candyType.withIndex()) {

            if (qtyToEat>=maxQty) {
                break
            }

            if (!intSet.contains(value)) {
                intSet.add(value)
                qtyToEat++
            }

        }
        return qtyToEat
    }
}