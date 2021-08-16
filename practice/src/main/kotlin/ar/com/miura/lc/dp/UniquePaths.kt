package ar.com.miura.lc.dp

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        var dp: Array<IntArray> = Array<IntArray>(m, { IntArray(n, { 1 }) })
        var maxI = m - 1
        for (i in 1..maxI) {
            var maxJ = dp[i].size - 1
            for (j in 1..maxJ) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1]
            }
        }
        return dp[m - 1][n - 1]
    }
}