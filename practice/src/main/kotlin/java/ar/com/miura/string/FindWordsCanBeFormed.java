package java.ar.com.miura.string;

/**
 * 1160. Find Words That Can Be Formed by Characters
 * You are given an array of strings words and a string chars.
 * A string is good if it can be formed by characters from chars (each character can only be used once).
 * Return the sum of lengths of all good strings in words.
 */
public class FindWordsCanBeFormed {
    public int countCharacters(String[] words, String chars) {

        int[] charsMap = extractCharMap(chars);
        java.util.Set<String> strings = new java.util.HashSet<String>();

        int sum = 0;
        for(String string:words) {

            int[] cloned = charsMap.clone();
            int count = 0;
            for(char c:string.toCharArray()) {
                int index = c - 'a';
                if (cloned[index]>0) {
                    cloned[index]--;
                    count++;
                }
            }
            if (count==string.length()) {
                sum += count;
            }

        }

        return sum;
    }

    private int[] extractCharMap(String chars) {
        int[] charsMap = new int[27];
        for(int i=0;i<chars.length();i++) {
            int index = chars.charAt(i) - 'a';
            charsMap[index]++;
        }
        return charsMap;
    }
}
