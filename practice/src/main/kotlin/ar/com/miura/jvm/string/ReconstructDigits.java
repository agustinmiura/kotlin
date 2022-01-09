package ar.com.miura.jvm.string;


public class ReconstructDigits {

    private static final char START_CHAR = 'a';

    public String originalDigits(String s) {

        int[] freqMap = new int[26];

        for (char c : s.toCharArray()) {
            int index = c - 'a';
            freqMap[index]++;
        }

        //digits to store
        int[] digits = new int[10];

        //first check the easiest
        digits[0] = freqMap['z' - 'a'];
        digits[2] = freqMap['w' - 'a'];
        digits[4] = freqMap['u' - 'a'];
        digits[6] = freqMap['x' - START_CHAR];
        digits[8] = freqMap['g' - START_CHAR];

        digits[5] = freqMap['f' - START_CHAR] - digits[4];
        digits[1] = freqMap['o' - 'a'] - digits[0] - digits[2] - digits[4];
        digits[7] = freqMap['s' - START_CHAR] - digits[6];
        digits[3] = freqMap['t' - START_CHAR] - digits[2] - digits[8];
        digits[9] = freqMap['i' - START_CHAR] - digits[5] - digits[8] - digits[6];

        StringBuilder sBuilder = new StringBuilder();
        for (int i = 0; i < 10; i++) {
            int frequency = digits[i];
            for (int j = 0; j < frequency; j++) {
                sBuilder.append(i);
            }
        }

        return sBuilder.toString();

    }
}
