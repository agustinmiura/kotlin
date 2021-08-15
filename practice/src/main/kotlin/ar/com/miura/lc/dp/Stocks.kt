package ar.com.miura.lc.dp

class Stocks {
    fun maxProfit(prices: IntArray): Int {

        var size = prices.size
        var dp:IntArray = IntArray(size)
        dp[size-1] = prices[size-1]

        var start = size-2
        for(i in start downTo 0) {
            dp[i] = Math.max(dp[i+1], prices[i])
        }

        var max = Int.MIN_VALUE
        var lastNumber = prices.size-1
        for(i in 0..lastNumber) {
            var currentProfit = dp[i]-prices[i]
            if (currentProfit>max) {
                max = currentProfit
            }
        }

        return if (max>0) { max } else { 0 }
    }
}