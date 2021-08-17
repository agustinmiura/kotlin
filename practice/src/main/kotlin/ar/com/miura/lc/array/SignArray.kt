package ar.com.miura.lc.array

class SignArray {
    fun arraySign(nums: IntArray): Int {
        var product: Double = 1.0
        for ((index, value) in nums.withIndex()) {
            product *= value * 1.0
        }
        if (product > 0) {
            return 1
        } else if (product < 0) {
            return -1
        } else {
            return 0
        }
    }
}