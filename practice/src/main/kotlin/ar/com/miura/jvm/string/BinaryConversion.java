package ar.com.miura.jvm.string;

/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/589/week-2-march-8th-march-14th/3669/
 */
public class BinaryConversion {

    public boolean hasAllCodes(String S, int K) {
        int len = S.length();
        int count = 1 << K;

        if (K > len) {
            return false;
        }
        java.util.Set<String> treeSet = new java.util.HashSet<>();
        for(int i=0 ;i<=len-K ;i++) {
            int end = i + K;
            String subString = S.substring(i, end);
            treeSet.add(subString);
            if (treeSet.size()==count) {
                return true;
            }
        }
        return treeSet.size()==count;
    }

}
