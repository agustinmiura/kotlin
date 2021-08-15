package ar.com.miura.lc.dp

class LongestSequenceMemoization {

    fun lengthOfLIS(nums: IntArray): Int {

        /**
         * Start the memoization matrix
         */
        var memo:Array<IntArray> = Array<IntArray>(nums.size+1, { IntArray(nums.size, { - 1 })})
        return recursive(nums, -1, 0, memo)
    }

    private fun recursive(nums: IntArray, beforeIndex:Int, currentIndex:Int, matrix:Array<IntArray>):Int {

        if (currentIndex==nums.size) {
            return 0
        }
        if (matrix[beforeIndex+1][currentIndex] >= 0) {
            return matrix[beforeIndex+1][currentIndex]
        }
        var taken = 0
        if (beforeIndex<0 || (nums[currentIndex]>nums[beforeIndex])) {
            taken = 1 + recursive(nums, currentIndex, currentIndex+1, matrix)
        }
        var notTaken = recursive(nums, beforeIndex, currentIndex+1, matrix)
        matrix[beforeIndex+1][currentIndex] = Math.max(taken, notTaken)
        return matrix[beforeIndex+1][currentIndex]
    }
}