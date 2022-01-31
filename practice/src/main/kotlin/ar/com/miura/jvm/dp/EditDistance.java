package ar.com.miura.jvm.dp;

public class EditDistance {
    public int minDistance(String word1, String word2) {

        int n = word1.length();
        int m = word2.length();

        int[][] dp = new int[n+1][m+1];

        for(int i=0;i<n+1;i++) {
            dp[i][0] = i;
        }

        for(int j=0;j<m+1;j++) {
            dp[0][j]=j;
        }

        for(int i=1;i<n+1;i++) {
            for(int j=1; j<m+1;j++) {
                boolean sameWord = word1.charAt(i-1)==word2.charAt(j-1);

                int left = dp[i][j-1];
                int down = dp[i-1][j];
                int diagonal = dp[i-1][j-1];

                if (sameWord) {

                    int min = Math.min(left, down);
                    min = Math.min(min, diagonal-1);
                    dp[i][j] = 1 + min;

                } else {

                    int min = Math.min(left, down);
                    min = Math.min(min, diagonal);
                    dp[i][j] = 1 + min;

                }
            }
        }
        return dp[n][m];
    }
}
