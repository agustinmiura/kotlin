package ar.com.miura.jvm.number;


/**
 * https://leetcode.com/explore/featured/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3679/
 */
public class PowerOfTwo {
    public boolean reorderedPowerOf2(int N) {

        java.util.Set<String> set = new java.util.HashSet<>();

        for(int i=0;i<=32;i++) {
            String eachNormalized = normalize(Math.pow(2, i));
            set.add(eachNormalized);
        }
        return set.contains(normalize((double)N));

    }

    private String normalize(Double number) {
        String stringNumber = number.toString();
        char[] charArray = stringNumber.toCharArray();
        java.util.Arrays.sort(charArray);
        String normalized = new String(charArray);
        return normalized;
    }
}
