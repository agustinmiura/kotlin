package ar.com.miura.jvm.backtracing;


/**
 * https://leetcode.com/problems/backspace-string-compare/
 */
public class BacktraceStringCompare {

    public static void main(String[] args) {
        BacktraceStringCompare compare = new BacktraceStringCompare();
        boolean answer = compare.backspaceCompare("a##c", "#a#c");
        String endpoint = "endpoint";
    }

    public boolean backspaceCompare(String S, String T) {
        boolean answer = false;
        int sSize = S.length();
        int tSize = T.length();
        int largestIndex = sSize>tSize ? sSize : tSize;

        StringBuilder sString = new StringBuilder();
        StringBuilder tString = new StringBuilder();

        for(int i=0;i<largestIndex; i++) {

            if (i<S.length()) {
                char currentChar = S.charAt(i);
                if (currentChar=='#' && sString.length()>=1) {
                    sString.deleteCharAt(sString.length()-1);
                } else if (currentChar!='#') {
                    sString.append(currentChar);
                }
            }

            if (i<T.length()) {
                char currentChar = T.charAt(i);
                if (currentChar=='#' && tString.length()>=1) {
                    tString.deleteCharAt(tString.length()-1);
                } else if (currentChar!='#') {
                    tString.append(currentChar);
                }
            }

        }

        return sString.toString().equals(tString.toString());
    }
}
