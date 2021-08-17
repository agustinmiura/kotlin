package ar.com.miura.lc.design

import java.util.*

class ShuffleArray(private val nums: IntArray) {

    private lateinit var numsOriginal: IntArray

    init {
        val size = nums.size
        numsOriginal = IntArray(size)
        for ((k, v) in nums.withIndex()) {
            numsOriginal[k] = v
        }
    }

    /** Resets the array to its original configuration and return it. */
    fun reset(): IntArray {
        for ((k, v) in numsOriginal.withIndex()) {
            nums[k] = v
        }
        return nums
    }

    /** Returns a random shuffling of the array. */
    fun shuffle(): IntArray {

        val range = Random()
        val size = numsOriginal.size
        for (index in 0..size - 1) {
            val randomIndex = range.nextInt(size)
            nums[0] = numsOriginal[randomIndex]
        }
        return nums
    }

}
