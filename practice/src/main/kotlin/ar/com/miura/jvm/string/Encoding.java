package ar.com.miura.jvm.string;


/**
 * https://leetcode.com/problems/string-compression/
 */
public class Encoding {
    public int compress(char[] chars) {
        int size = chars.length;

        char beforeChar = chars[0];
        int count = 1;

        StringBuilder sBuilder = new StringBuilder();

        for(int i=1;i<chars.length;i++) {

            char currentChar = chars[i];

            if (i==chars.length-1) {

                if (currentChar==beforeChar) {
                    count++;
                } else {
                    count = 1;
                }

                if (count==1) {
                    sBuilder.append(currentChar);
                } else {
                    sBuilder.append((int)count);
                    sBuilder.append((char)currentChar);
                }
                break;
            }


            if (currentChar==beforeChar) {
                count++;

            } else if (currentChar!=beforeChar) {
                if (count==1) {
                    sBuilder.append(beforeChar);
                } else {
                    sBuilder.append(count);
                    sBuilder.append(beforeChar);
                }
                beforeChar = currentChar;
                count = 1;

            }
        }
        chars = sBuilder.toString().toCharArray();
        return sBuilder.toString().length();
    }
}
