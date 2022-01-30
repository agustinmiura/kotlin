package ar.com.miura.jvm.dp.wordbreak2;

public class WordBreakMemo2 {
    public java.util.List<String> wordBreak(String s, java.util.List<String> wordDict) {
        java.util.Set<String> set = new java.util.HashSet<String>(wordDict);
        java.util.List<String> combinations = new java.util.ArrayList<>();
        java.util.Map<String, java.util.List<java.util.List<String>>> memo = new java.util.HashMap<>();
        wordBreakDown(s, memo, set);
        java.util.List<String> strings = new java.util.ArrayList<String>();
        for(java.util.List<String> words:memo.get(s)) {
            StringBuffer sBuffer = new StringBuffer();
            for(String word:words) {
                sBuffer.insert(0, word);
                sBuffer.insert(0, " ");
            }
            strings.add(sBuffer.toString().trim());
        }
        return strings;
    }

    private java.util.List<java.util.List<String>> wordBreakDown(
            String string,
            java.util.Map<String, java.util.List<java.util.List<String>>> memo,
            java.util.Set<String> set) {

        if (string.equals("")) {
            java.util.List<java.util.List<String>> solutions = new java.util.ArrayList<>();
            solutions.add(new java.util.ArrayList<>());
            return solutions;
        }

        if (memo.containsKey(string)) {
            return memo.get(string);
        } else {
            java.util.List<java.util.List<String>> solutions = new java.util.ArrayList<>();
            memo.put(string, solutions);
        }

        int size = string.length();
        for(int end=1;end<=size;end++) {

            String prefix = string.substring(0, end);

            if (set.contains(prefix)) {
                String word = string.substring(end);
                java.util.List<java.util.List<String>> subsentences = wordBreakDown(word, memo, set);

                for(java.util.List<String> subsentence:subsentences) {
                    java.util.List<String> newSentence = new java.util.ArrayList<String>(subsentence);
                    newSentence.add(prefix);
                    memo.get(string).add(newSentence);
                }
            }
        }

        return memo.get(string);

    }
}
