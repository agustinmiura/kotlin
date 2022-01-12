package ar.com.miura.pramp;

public class NumberOfPaths {
    static int numOfPathsToDest(int n) {

        int[][] dp = new int[n][n];
        int number = 0;

        //initial state
        dp[0][0] = 1;

        for(int i=0;i<n;i++) {
            dp[0][i] = 1;
        }

        for(int i=1;i<n;i++) {
            for(int j=i;j<n;j++) {
                int right = 0;
                dp[i][j] = dp[i][j-1] + dp[i-1][j];
            }
        }
        number = dp[n-1][n-1];
        return number;

    }
}
