package ar.com.miura.jvm.dp.wordbreak2;

public class Recursive {
    public java.util.List<String> wordBreak(String s, java.util.List<String> wordDict) {
        java.util.Set<String> set = new java.util.HashSet<String>(wordDict);
        java.util.List<String> combinations = new java.util.ArrayList<>();
        recursiveWordBreak(s, set, combinations,0, "");
        return combinations;
    }

    private void recursiveWordBreak(
            String s,
            java.util.Set<String> set,
            java.util.List<String> combinations,
            int start,
            String prefix) {
        int size = s.length();
        if (start>=(size)) {
            combinations.add(prefix.trim());
            return;
        }

        for(int end=start+1; end<=size; end++) {
            String word = s.substring(start, end);
            if (set.contains(word)) {
                recursiveWordBreak(
                        s,
                        set,
                        combinations,
                        end,
                        " " + prefix + " " +  word
                );
            }
        }
    }
}
