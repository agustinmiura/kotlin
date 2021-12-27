package ar.com.miura.jvm.bit;

public class PowerTwo {
    public boolean isPowerOfTwo(int n) {
        if (n==0) {
            return false;
        } else  if (n<0) {
            return false;
        }
        int oneQty = 0;
        for(int i=0;i<32;i++) {
            int bit = 1 & ( n >>> i);
            if (bit==1) {
                oneQty++;
            }
            if (oneQty>=2) {
                return false;
            }
        }
        return true;
    }
}
