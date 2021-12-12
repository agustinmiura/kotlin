package ar.com.miura.lc.dp

class ClimbStairsRecursive {
    fun climbStairs(n: Int): Int {
        return if (n <= 0) {
            0
        } else if (n == 1) {
            1
        } else if (n == 2) {
            2
        } else {
            val step2 = n - 2
            val step1 = n - 1
            climbStairs(n - 1) + climbStairs(n - 2)
        }
    }
}