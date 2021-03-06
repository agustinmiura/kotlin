package ar.com.miura.jvm.dp;

public class CoinChange {

    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        dp[0]=0;

        for(int i=0;i<=amount;i++) {
            for(int j=0;j<coins.length;j++) {

                if (coins[j]<=i) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }

        return dp[amount] > amount ? -1 : dp[amount];

    }
}
