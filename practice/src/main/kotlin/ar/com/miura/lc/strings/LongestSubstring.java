package ar.com.miura.lc.strings;

public class LongestSubstring {
    public int lengthOfLongestSubstring(String s) {

        int start = 0;
        int end = 0;
        int largest = 0;

        java.util.Set<Character> chars = new java.util.HashSet<Character>();

        int size = s.length();
        for(int i=0;i<size;i++) {
            end = i;
            char currentChar = s.charAt(i);
            if (chars.contains(new Character(currentChar))) {

                while(chars.contains(new Character(currentChar))) {
                    char startChar = s.charAt(start);
                    chars.remove(new Character(startChar));
                    start++;
                }
                chars.add(new Character(currentChar));

            } else {
                chars.add(new Character(currentChar));
                int currentSize = end - start + 1;
                if (currentSize>largest) {
                    largest = currentSize;
                }
            }
        }
        return largest;
    }
}
