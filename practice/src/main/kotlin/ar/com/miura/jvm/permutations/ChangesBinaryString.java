package ar.com.miura.jvm.permutations;


/**
 * https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 */
public class ChangesBinaryString {
    public int minOperations(String s) {
        int size = s.length();
        char currentChar;
        int minOperations = 0;
        char beforeChar = s.charAt(0);
        for (int i = 1; i < s.length(); i++) {
            currentChar = s.charAt(i);
            char nextChar = getNextChar(beforeChar);
            if (nextChar != currentChar) {
                minOperations++;
            }
            beforeChar = nextChar;
        }

        /**
         * The answer is the min between a String that starts with zeroes or ones .
         */
        return Math.min(s.length() - minOperations, minOperations);
    }

    /**
     * @param character
     * @return
     */
    private char getNextChar(char character) {
        char nextChar = (character == '0') ? '1' : '0';
        return nextChar;
    }
}