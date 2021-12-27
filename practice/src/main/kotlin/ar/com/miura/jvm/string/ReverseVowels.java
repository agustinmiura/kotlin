package ar.com.miura.jvm.string;

public class ReverseVowels {
    public String reverseVowels(String s) {

        int size = s.length();
        int start = 0;
        int end = size-1;

        java.util.Set<Character> vowelSet = new java.util.HashSet<Character>();
        char[] vowels = new char[]{'a','e','i','o','u'};
        for(char eachChar:vowels) {
            vowelSet.add(eachChar);
        }

        char[] chars = s.toCharArray();
        while(start<end) {

            while(
                    start < size &&
                            start < end &&
                            !vowelSet.contains(
                                    Character.toLowerCase(s.charAt(start))
                            )
            ) {
                start++;
            }

            while(
                    end >= 0 &&
                            start < end &&
                            !vowelSet.contains(
                                    Character.toLowerCase(s.charAt(end))
                            )
            ) {
                end--;
            }

            char startChar = s.charAt(start);

            chars[start] = s.charAt(end);
            chars[end] = startChar;

            start++;
            end--;

        }

        return new String(chars);

    }
}
