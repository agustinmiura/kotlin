package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/103/array-and-strings/776/
 */
class TripleSum {
    private val SUM:Int = 0

    fun threeSum(nums: IntArray): List<List<Int>> {

        var tripletSet = mutableSetOf<String>()

        var triplets = mutableListOf<List<Int>>()

        var sortedArray:IntArray = nums.sortedArray()
        var max = sortedArray.size-1

        var lastIndex = sortedArray.size-2

        for(i in 0..lastIndex) {
            var v = sortedArray[i]

            var remainder = 0-v

            var jStart = i+1
            var k = max
            var sum = v
            var j = i+1

            while(j<k) {

                if (sum+sortedArray[j]+sortedArray[k]==SUM) {

                    var key = "${sortedArray[i]},${sortedArray[j]},${sortedArray[k]}"
                    if (!tripletSet.contains(key)) {
                        triplets.add(listOf(
                            sortedArray[i],
                            sortedArray[j],
                            sortedArray[k]))
                        tripletSet.add(key)
                    }

                }

                if (sortedArray[j]+sortedArray[k]>remainder) {
                    k--
                } else {
                    j++
                }
            }
        }
        return triplets
    }

}