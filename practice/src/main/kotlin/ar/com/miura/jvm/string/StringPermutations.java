package ar.com.miura.jvm.string;


/**
 * https://leetcode.com/problems/count-number-of-homogenous-substrings/submissions/
 *
 *
 * a    = 4 times
 * aa   = 3 times
 * aaa  = 2 times
 * aaaa  = 1 time
 *
 * So for a which is 4 times we have 4 + 3 + 2 +1 ;
 *
 */
public class StringPermutations {
    public int countHomogenous(String s) {
        int numberTimes = 0;
        int homogenousCount = 0;

        for(int i=0;i<s.length();i++) {
            if (i>0 && s.charAt(i)==s.charAt(i-1)) {
                numberTimes++;
            } else {
                numberTimes = 1;
            }
            homogenousCount = homogenousCount + numberTimes;

        }
        return homogenousCount;
    }

}
