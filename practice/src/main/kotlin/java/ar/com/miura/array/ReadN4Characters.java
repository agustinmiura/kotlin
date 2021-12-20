package java.ar.com.miura.array;

public class ReadN4Characters {
    public int read(char[] buf, int n) {
        int readChars = 0;
        char[] charsRead = new char[4];
        int index = 0;
        while(readChars!=n) {
            int read = read4(charsRead);
            int i = 0;
            while(i<read && readChars<n) {
                buf[index] = charsRead[i];
                i++;
                index++;
                readChars++;
            }
            if (read!=4) {
                break;
            }
        }
        return readChars;
    }

    int read4(char[] buf4) {
        return -1;
    }
}


