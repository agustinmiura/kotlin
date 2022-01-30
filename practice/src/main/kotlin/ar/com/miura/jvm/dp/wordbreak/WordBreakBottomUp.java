package ar.com.miura.jvm.dp.wordbreak;

public class WordBreakBottomUp {
    public boolean wordBreak(String s, java.util.List<String> wordDict) {
        java.util.Set<String> set = new java.util.HashSet<>(wordDict);
        boolean[] dp = new boolean[s.length()+1];
        dp[0] = true;
        for(int i = 1; i<=s.length();i++) {
            for(int j=0; j<i; j++) {
                String subString = s.substring(j,i);
                if (dp[j] && set.contains(subString)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}
