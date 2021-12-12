package java.ar.com.miura.bit;

public class UniqueNumber {
    public int singleNumber(int[] nums) {

        int a = 0;
        for(int i:nums) {
            a ^= i;
        }
        return a;

    }
}
