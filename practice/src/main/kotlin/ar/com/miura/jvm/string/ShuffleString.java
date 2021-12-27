package ar.com.miura.jvm.string;

public class ShuffleString {
    public String restoreString(String s, int[] indices) {

        char[] cloned = new char[indices.length];
        for(int i=0;i<indices.length;i++) {
            int index = indices[i];
            char tempChar = s.charAt(i);
            cloned[index] = tempChar;
        }

        return new String(cloned);
    }
}
