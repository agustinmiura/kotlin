package ar.com.miura.jvm.string;

public class CheckOneSegment {

    public boolean checkOnesSegment(String s) {
        int i = 0, len = s.length();
        boolean oneSegment = false;
        while (i < len) {
            while (i < len && s.charAt(i) == '1') {
                oneSegment = true;
                i++;
            }
            i++;
            if (i < len && s.charAt(i) == '1' && oneSegment) {
                return false;
            };
        }
        return true;
    }
}
