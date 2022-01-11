package ar.com.miura.jvm.dp;

public class LargestSubsequenceIncrease {
    public int lengthOfLIS(int[] nums) {

        int size = nums.length;
        int[] dp = new int[size];

        /*
        Every number is sequence itself
        */
        java.util.Arrays.fill(dp, 1);

        for(int i=1;i<size;i++) {
            for(int j=0;j<i;j++) {
                if (nums[i]>nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
        }

        int largest = Integer.MIN_VALUE;
        for(int number:dp) {
            largest = Math.max(largest, number);
        }

        return largest;

    }
}
