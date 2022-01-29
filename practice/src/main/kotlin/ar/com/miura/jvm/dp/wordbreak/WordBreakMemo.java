package ar.com.miura.jvm.dp.wordbreak;

public class WordBreakMemo {
    public boolean wordBreak(String s, java.util.List<String> wordDict) {
        return recursive(s, new java.util.HashSet<>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean recursive(String s, java.util.Set<String> set, int start, Boolean[] memo) {

        if (start==s.length()) {
            return true;
        }

        if (memo[start]!=null) {
            return memo[start];
        }

        for(int j=start+1;j<=s.length();j++) {
            String prefix = s.substring(start, j);
            if (set.contains(prefix) &&
                    recursive(s, set, j, memo)) {
                memo[start] = true;
                return memo[start];
            }
        }
        memo[start] = false;
        return memo[start];
    }
}
