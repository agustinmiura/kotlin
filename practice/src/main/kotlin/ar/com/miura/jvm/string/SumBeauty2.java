package ar.com.miura.jvm.string;


public class SumBeauty2 {
    public int beautySum(String s) {
        int sum = 0;
        int size = s.length();

        for(int i=0;i<size-1;i++) {

            //Map<Character, Integer> map = new HashMap<>();
            int[] charCount = new int[26];

            for(int j=i;j<size;j++) {

                char currentChar = s.charAt(j);
                int count = charCount[currentChar-'a'];
                count++;
                charCount[currentChar-'a'] = count;

                int min = getMin(charCount);
                int max = getMax(charCount);
                sum = sum + (max-min);
            }
        }

        return sum;
    }

    private int getMax(int[] charCount) {
        int max = 0;
        for(int i=0;i<charCount.length;i++) {
            if (charCount[i]!=0) {
                max = Math.max(max, charCount[i]);
            }
        }
        return max;
    }

    public int getMin(int[] charCount) {
        int min = Integer.MAX_VALUE;
        for(int i=0;i<charCount.length;i++) {
            if (charCount[i]!=0) {
                min = Math.min(min, charCount[i]);
            }
        }
        return min;
    }

}
