package ar.com.miura.jvm.string;


public class LargestSubstring {

    public static int getBottomUp(String s1, String s2, int n, int m) {
        if (n==0 || m==0) {
            return 0;
        }

        int largestSubstring = 0;
        int[][] dpMatrix = new int[n+1][m+1];

        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                if (s1.charAt(i-1)==s2.charAt(j-1)) {
                    dpMatrix[i][j] = 1 + dpMatrix[i - 1][j - 1];
                    largestSubstring = Math.max(largestSubstring, dpMatrix[i][j]);

                } else {
                    dpMatrix[i][j]=0;
                }
            }
        }

        return largestSubstring;
    }

    /**
     * Brute force solution
     * @param s1
     * @param s2
     * @param n
     * @param m
     * @param countOfLarge
     * @return
     */
    public static int getLargestSubstring(String s1, String s2, int n, int m, int countOfLarge) {
        if (n==0 || m==0) {
            return countOfLarge;
        } else {

            //first case matching
            if (s1.charAt(n-1)==s2.charAt(m-1)) {
                countOfLarge = getLargestSubstring(s1, s2, n-1, m-1, countOfLarge +1);
            }

            int count1 = getLargestSubstring(s1, s2, n-1, m, 0);
            int count2 = getLargestSubstring(s1, s2, n, m-1, 0);

            return Math.max(countOfLarge, Math.max(count1, count2));
        }
    }


}
