package ar.com.miura.lc.array

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {

        var nonZeroIndex = 1
        var size = nums.size
        var temp = -1
        for ((i, v) in nums.withIndex()) {

            /*
            non zero element go on
            */
            if (v != 0) {

                nonZeroIndex++
                continue

            } else {

                var nextReplaceIndex = i + 1
                while (nextReplaceIndex < size) {

                    if (nums[nextReplaceIndex] != 0) {
                        temp = nums[nextReplaceIndex]
                        nums[i] = temp
                        nums[nextReplaceIndex] = 0
                        break
                    }

                    nextReplaceIndex++
                }
            }
        }
    }
}