package ar.com.miura.jvm.slidewindow;

public class MaxPower {
    public int maxPower(String s) {
        int max = 1;
        int count = 1;

        char[] chars = s.toCharArray();
        int size = chars.length;

        for(int i=1; i<size; i++) {

            if (chars[i]==chars[i-1]) {
                count++;
                if (count>max) {
                    max = count;
                }
            } else {
                count = 1;
            }

        }
        return max;

    }
}
