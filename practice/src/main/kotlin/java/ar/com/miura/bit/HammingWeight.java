package java.ar.com.miura.bit;

public class HammingWeight {
    public int hammingWeight(int n) {
        int oneQty = 0;
        for(int i=0;i<32;i++) {
            int bit = (n>>>i) & 1;
            if (bit==1) {
                oneQty++;
            }
        }
        return oneQty;
    }
}
