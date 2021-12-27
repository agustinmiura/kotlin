package ar.com.miura.jvm.string;

public class RotateString {
    public boolean rotateString(String A, String B) {
        if (A.length()!=B.length()) {
            return false;
        } else if (A.length()==0 || B.length()==0) {
            return false;
        }

        int maxRotations = A.length();
        for(int i=0;i<maxRotations;i++) {
            String rotated = rotate(A, i);
            if (rotated.equals(B)) {
                return true;
            }
        }

        return false;

    }

    private String rotate(String string, int positions) {
        int size = string.length();
        char[] rotated = new char[size];
        for(int i=0;i<size;i++) {
            int newPosition = (i+positions)%size;
            rotated[newPosition] = string.charAt(i);
        }
        return new String(rotated);
    }
}
