package ar.com.miura.lc.strings;

public class PermutationInString {
    public boolean checkInclusion(String s1, String s2) {

        int s1Size = s1.length();
        int s2Size = s2.length();

        if (s1Size>s2Size) {
            return false;
        }

        int[] map1 = new int[26];
        int[] map2 = new int[26];

        for(int i=0;i<s1Size;i++) {
            map1[s1.charAt(i) - 'a']++;
            map2[s2.charAt(i) - 'a']++;
        }

        for(int i=0;i<s2Size-s1Size;i++) {
            if (matches(map1,map2)) {
                return true;
            }
            map2[s2.charAt(i+s1Size)-'a']++;
            map2[s2.charAt(i) - 'a']--;
        }
        return matches(map1,map2);
    }

    private boolean matches(int[] map1, int[] map2) {
        for(int i=0;i<26;i++) {
            if (map1[i]!=map2[i]) {
                return false;
            }
        }
        return true;
    }
}
