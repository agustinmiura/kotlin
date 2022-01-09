package ar.com.miura.jvm.string;

/**
 * https://leetcode.com/contest/weekly-contest-232/problems/check-if-one-string-swap-can-make-strings-equal/
 */
public class SwapString {
    public boolean areAlmostEqual(String s1, String s2) {
        int matchingQty = 0;
        int size = s1.length();
        int unmatched = 0;

        if (s1.equals(s2)) {
            return true;
        }

        int prev = -1;
        int current = -1;
        for(int i=0;i<s1.length();i++) {
            if (s1.charAt(i)==s2.charAt(i)) {
                matchingQty++;

            } else {
                unmatched++;
                prev  = current;
                current = i;

            }

            if (unmatched>2) {
                return false;
            }

        }
        return (unmatched==2 && s1.charAt(prev)==s2.charAt(current) && s1.charAt(current)==s2.charAt(prev));
    }
}
