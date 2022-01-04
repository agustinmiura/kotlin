package ar.com.miura.jvm.string;

public class Palindrome {
    /**
     If you do the brute force way you would generate a lot more strings than this method looks at.
     which is set of all subsets ( rather substrings) -
     E(sigma) (n-i) as i runs from 1 to n-1 = n-squared + n(n+1)/2 - O(n-squared) complexity.
     This problem can be done using DP with n-squared complexity as shown above by [@GraceMeng](https://leetcode.com/GraceMeng)
     with a few comments below by me based on that
     **/
    public String longestPalindrome(String s) {
        if (s == null || s.length() <= 1)
            return s;
        int len = s.length();
        // dp[i][j] stands for status of a substring starting at i and ending at j incl j
        boolean[][] dp = new boolean[len][len];

        // initialize all the 1 character palins
        for(int i = 0; i < len; i++)
            dp[i][i] = true;

        // to compute dp[i][j] we need dp[i+1][j-1]
        // so the i - outer loop needs to go from higher to lower
        // and the j - inner loop needs to go from lower to higher
        int maxLen = 0, maxSta = 0, maxEnd = 0;
        for(int i = len; i >= 0; i--){
            // dist of 0 - already covered by initialization
            for(int dist = 1; dist < len - i; dist++){
                int j = i + dist;
                // we are ready to compute dp [i] [j]
                if (dist == 1 && s.charAt(i) == s.charAt(j)){
                    dp[i][j] = true;
                } else if (s.charAt(i) == s.charAt(j)){
                    dp[i][j] = dp[i+1][j-1];
                }
                // if true
                if (dp[i][j] && maxLen < (j-i+1)){
                    maxLen = j - i + 1;
                    maxSta = i;
                    maxEnd = j;
                }
            }
        }
        return s.substring(maxSta,maxEnd+1);
    }
}
