package ar.com.miura.jvm.string;

public class ValidAnagram {
    public boolean isAnagram(String s, String t) {

        if ((s==null || t==null) || (s.length()!=t.length())) {
            return false;
        }

        char[] sChars = s.toCharArray();
        char[] tChars = t.toCharArray();

        java.util.Arrays.sort(sChars);
        java.util.Arrays.sort(tChars);

        for(int i=0;i<sChars.length;i++) {
            if (sChars[i]!=tChars[i]) {
                return false;
            }
        }

        return true;

    }
}
