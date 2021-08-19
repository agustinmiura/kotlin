package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
 */
class BestTimeToBuyAndSellSecond {
    fun maxProfit(prices: IntArray): Int {
        var maxProfit = 0;
        for(i in 1..(prices.size-1)) {
            if (prices[i]>prices[i-1]) {
                maxProfit += (prices[i]-prices[i-1]);
            }
        }
        return maxProfit;
    }
}