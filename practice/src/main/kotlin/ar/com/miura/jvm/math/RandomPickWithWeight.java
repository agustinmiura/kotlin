package ar.com.miura.jvm.math;

import java.util.Random;

public class RandomPickWithWeight {
    private int total = 0;
    private int[] prefixSum;

    public void Solution(int[] w) {

        this.prefixSum = new int[w.length];

        for(int i=0;i<w.length;i++) {
            total += w[i];
            this.prefixSum[i] = total;
        }

    }

    public int pickIndex() {
        Random random = new Random();
        int target = random.nextInt(total);

        for(int i=0;i<prefixSum.length;i++) {
            if (target<this.prefixSum[i]) {
                return i;
            }
        }
        return -1;
    }
}
