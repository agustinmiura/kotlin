package ar.com.miura.cs;

public class PalindromeSearch {
    String get(String s) {
        String prefix = getLargestPalindrome(s);
        if (prefix.length()==1) {
            return s;
        } else {
            return get(s.substring(prefix.length()));
        }
    }
    private String getLargestPalindrome(String string) {
        String largestWord = "";
        int wordSize = string.length();
        for(int i=1;i<wordSize;i++) {
            String word = string.substring(0,i);
            if (isPalindrome(word)) {
                int size = word.length();
                if (size>largestWord.length()) {
                    largestWord = word;
                }
            }
        }
        return largestWord;
    }
    private boolean isPalindrome(String string) {
        if (string.length()==1) {
            return true;
        }
        char[] chars = string.toCharArray();
        int left = 0;
        int right = chars.length-1;
        while(left<=right) {
            if (chars[left]!=chars[right]) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
}
