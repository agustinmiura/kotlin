package ar.com.miura.jvm.bit;

public class ReverseNumber {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {

        int result = 0;

        for(int i=0;i<32;i++) {
            int currentBit = (n>>>i) & 1;
            int spaces = 31 - i;
            result = (result | (currentBit << spaces));
        }
        return result;

    }
}
