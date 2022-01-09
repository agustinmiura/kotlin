package ar.com.miura.jvm.string;

public class LargestEncoding {
    public int minimumLengthEncoding(String[] words) {

        java.util.Arrays.sort(words, (word1, word2) -> {
            return -1*(word1.length()-word2.length());
        });

        java.util.Set<String> wordSet = new java.util.TreeSet<String>();
        int minSize = 0;

        for(String eachWord:words) {
            if (wordSet.contains(eachWord)) {
                continue;
            } else {
                wordSet.add(eachWord);
                minSize = minSize + eachWord.length() + 1;
                for(int i=1;i<eachWord.length();i++) {
                    wordSet.add(eachWord.substring(i));
                }
            }
        }

        return minSize;
    }
}
