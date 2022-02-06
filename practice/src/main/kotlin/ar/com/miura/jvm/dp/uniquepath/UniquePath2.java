package ar.com.miura.jvm.dp.uniquepath;

public class UniquePath2 {
    private static final int INVALID = 0;
    private static final int BUSY = 1;
    private static final int FREE = 0;

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {

        if (obstacleGrid[0][0]==BUSY) {
            return 0;
        }

        int rowQty = obstacleGrid.length;
        int colQty = obstacleGrid[0].length;

        int[][] dp = new int[rowQty][colQty];
        dp[0][0] = 1;

        for(int j=1;j<colQty;j++) {
            if (obstacleGrid[0][j]==FREE && dp[0][j-1]==1) {
                dp[0][j] = 1;
            } else {
                dp[0][j] = INVALID;
            }
        }

        for(int i=1;i<rowQty;i++) {
            if (obstacleGrid[i][0]==FREE && dp[i-1][0]==1) {
                dp[i][0] = 1;
            } else {
                dp[i][0] = INVALID;
            }
        }


        for(int i=1;i<rowQty;i++) {
            for(int j=1;j<colQty;j++) {
                if (obstacleGrid[i][j]==FREE) {
                    if (obstacleGrid[i-1][j]==FREE) {
                        dp[i][j] += dp[i-1][j];
                    }
                    if (obstacleGrid[i][j-1]==FREE) {
                        dp[i][j] += dp[i][j-1];
                    }
                }
            }
        }

        return dp[rowQty-1][colQty-1];
    }
}
