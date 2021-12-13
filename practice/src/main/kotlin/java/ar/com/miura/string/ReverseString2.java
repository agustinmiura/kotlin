package java.ar.com.miura.string;

public class ReverseString2 {
    public String reverseStr(String s, int k) {
        char[] chars = s.toCharArray();
        int size = s.length();
        for(int i=0;i<size;i += 2*k) {

            int start = i;
            int end = Math.min(start+k-1, size-1);

            while(start<end) {
                char startChar = chars[start];
                char endChar = chars[end];

                chars[start] = chars[end];
                chars[end] = startChar;

                start++;
                end--;

            }
        }
        return new String(chars);
    }
}
