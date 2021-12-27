package ar.com.miura.jvm.dp;

public class RobHouses {
    public int rob(int[] nums) {

        int size = nums.length;

        if (size==1) {
            return nums[0];

        } else if (size==2) {
            return Math.max(nums[0], nums[1]);

        }

        int[] dp = new int[size];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for(int i =2;i<size;i++) {

            int valueWithJump = nums[i] + nums[i-2];
            int beforeValue = dp[i-1];

            dp[i] = Math.max(valueWithJump, beforeValue);

        }

        return dp[size-1];

    }
}
