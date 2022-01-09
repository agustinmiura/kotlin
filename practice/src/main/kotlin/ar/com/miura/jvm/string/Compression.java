package ar.com.miura.jvm.string;

public class Compression {
    public int compress(char[] chars) {
        int size = chars.length;

        char beforeChar = chars[0];
        int count = 1;

        StringBuilder sBuilder = new StringBuilder();

        for(int i=1;i<chars.length;i++) {

            char currentChar = chars[i];

            if (i==chars.length-1) {
                if (count==1) {
                    sBuilder.append(currentChar);
                } else {
                    sBuilder.append(count);
                    sBuilder.append(currentChar);
                }
                break;
            }


            if (currentChar==beforeChar) {
                count++;
            }

            if (currentChar!=beforeChar) {

                if (count==1) {
                    sBuilder.append(currentChar);
                } else {
                    sBuilder.append(count);
                    sBuilder.append(currentChar);
                }
                beforeChar = currentChar;
                count = 1;

            }

        }
        return -1;
    }
}
