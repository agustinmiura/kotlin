package ar.com.miura.jvm.bit;

public class IntArrayToBinary {
    public static int cellsToBitMap2(int[] cells) {
        int latest = cells.length-1;
        int position = 0;
        int number = 0;
        while(latest>=0) {
            if (cells[latest]==1) {
                number = number | (cells[latest]<<position);
            } else {
                number = number & ~(1<<position);
            }
            position++;
            latest--;
        }
        return number;
    }
}
