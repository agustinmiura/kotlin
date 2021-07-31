package ar.com.miura.lc.backtracking.queens


class Solution {

    private var solutions:MutableList<MutableList<Int>> = mutableListOf<MutableList<Int>>(mutableListOf<Int>())

    /***************************************************************************
     * Return true if queen placement q[n] does not conflict with
     * other queens q[0] through q[n-1]
     */
    fun isConsistent(q: IntArray, n: Int): Boolean {
        for (i in 0 until n) {
            if (q[i] == q[n]) return false // same column
            if (q[i] - q[n] == n - i) return false // same major diagonal
            if (q[n] - q[i] == n - i) return false // same minor diagonal
        }
        return true
    }

    /***************************************************************************
     * Prints n-by-n placement of queens from permutation q in ASCII.
     */
    fun printQueens(q: IntArray) {
        val n = q.size
        for (i in 0 until n) {
            for (j in 0 until n) {
                if (q[i] == j) { println("Q ") } else { println("* ") }
            }
        }
    }

    /***************************************************************************
     * Try all permutations using backtracking
     */
    fun enumerate(n: Int) {
        val a = IntArray(n)
        enumerate(a, 0)
    }

    fun enumerate(q: IntArray, k: Int) {
        val n = q.size
        if (k == n) printQueens(q) else {
            for (i in 0 until n) {
                q[k] = i
                if (isConsistent(q, k)) enumerate(q, k + 1)
            }
        }
    }

}