package ar.com.miura.pramp;

/**
 * Problem explained :

 Decrypted message:	c	r	i	m	e
 Step 1:	99	114	105	109	101
 Step 2:	100	214	319	428	529
 Step 3:	100	110	111	116	113
 Encrypted message:	d	n	o	t	q

 Step 1 : 99 to 0

 Then keep adding
    114 => 214
    105 => 319
    109 => 428
    101 => 529

 Then for each of the numbers reduce 26 until it is greater than 97 .

 e(n)  = dec(n) + secondStep(n-1) - 26m
 Then convert into a valid ascii .

 d(n) = e(n) - secondTep(n-1) + 26m

 And the part of  + 26m is optimized .
 *
 *
 *
 */
public class DecryptMessage {

    private static final char LOWER = 97;

    public static String decrypt(String word) {

        if (word.length()==0) {
            return "";
        }

        /**
         *
         */
        int size = word.length();
        int[] decoded = new int[size];

        /**
         * Step 0
         */
        char firstChar = word.charAt(0);
        int number = (int)firstChar;
        number--;
        decoded[0] = number;

        int step2Acum = (int)word.charAt(0);
        for(int i=1;i<size;i++) {

            int currentEncrypted = (int)word.charAt(i);

            /**
             * (step2Acum % 26) fix to avoid the long cycles.
             *
             */
            int decrypted = currentEncrypted - (step2Acum % 26);
            while(decrypted<LOWER) {
                decrypted += 26;
            }
            decoded[i] = decrypted;
            step2Acum += (int)decrypted;

        }

        char[] chars = new char[size];
        for(int i=0;i<size;i++) {
            chars[i] = (char) decoded[i];
        }

        return new String(chars);
    }
}
