package ar.com.miura.jvm.string;


/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3665/
 */
public class RemovePalindromicSequence {

    public int removePalindromeSub(String s) {
        if (s.length()==0) {
            return 0;
        } else if (isPalindrome(s)) {
            return 1;
        } else {
            return 2;
        }
    }

    private boolean isPalindrome(String s) {
        int i=0;
        int j=s.length()-1;
        while(i<j) {
            if (s.charAt(i)!=s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

}
