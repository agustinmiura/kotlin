package ar.com.miura.pramp;

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
