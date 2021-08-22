package ar.com.miura.lc.array

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var lastNonZeroFoundAt = 0;
        var size = nums.size;
        for (i in 0..(size - 1)) {
            if (nums[i] != 0) {
                nums[lastNonZeroFoundAt] = nums[i];
                lastNonZeroFoundAt++
            }
        }
        for(i in lastNonZeroFoundAt..(size-1)) {
            nums[i]=0;
        }
    }
}