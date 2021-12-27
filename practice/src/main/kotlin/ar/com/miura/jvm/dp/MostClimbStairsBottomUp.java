package ar.com.miura.jvm.dp;

public class MostClimbStairsBottomUp {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length+1];
        dp[0]=0;
        dp[1]=0;
        for(int i=2;i<dp.length;i++) {
            int downOne = cost[i-1] + dp[i-1];
            int downTwo = cost[i-2] + dp[i-2];
            dp[i] = Math.min(downOne, downTwo);
        }
        return dp[dp.length-1];
    }
}
