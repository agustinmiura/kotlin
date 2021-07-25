package ar.com.miura.lc.backtracking.queens


class Solution {

    fun enumerate(n:Int) {
        var a:IntArray = IntArray(n)
        enumerate(a, 0)
    }

    private fun enumerate(queens:IntArray, k:Int) {

        if (k==queens.size) {
            printQueens(queens)
        } else {
            for(i in 0..(k-1)) {
                queens[k] = i
                if (isConsistent(queens,k)) {
                    enumerate(queens, k+1)
                }
            }
        }
    }

    private fun isConsistent(queens:IntArray, k:Int):Boolean {
        for(i in 0..(k-1)) {
            if (queens[i]==queens[k]) {
                return false

            } else if (queens[i]-queens[k]==(k-i)) {
                return false

            } else if (queens[k]-queens[i]==(k-i)) {
                return false

            }
        }
        return true
    }

    private fun printQueens(queens:IntArray) {
        var max = queens.size-1
        for(i in 0..max) {
            for(j in 0..max) {
                if (queens[i]==j) {
                    println("Queens")
                } else {
                    println("*")
                }
            }
        }
    }

}