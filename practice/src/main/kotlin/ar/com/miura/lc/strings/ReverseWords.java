package ar.com.miura.lc.strings;

public class ReverseWords {
    public String reverseWords(String s) {

        int size = s.length();

        char[] chars = new char[size];

        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        int charPointer = 0;
        for(int i=0;i<size;i++) {

            char currentChar = s.charAt(i);
            if (currentChar == ' ') {

                while(!stack.isEmpty()) {

                    chars[charPointer] = stack.pop();
                    charPointer++;

                }
                chars[charPointer] = ' ';
                charPointer++;

            } else {
                stack.push(s.charAt(i));
            }
        }

        while(!stack.isEmpty()) {
            chars[charPointer] = stack.pop();
            charPointer++;
        }

        return new String(chars);
    }
}
