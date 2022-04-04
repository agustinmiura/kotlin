package ar.com.miura.jvm.math;

public class RandomPickWithWeightBinarySearch {
    private int total = 0;
    private int[] prefixSum;

    public RandomPickWithWeightBinarySearch(int[] w) {
        this.prefixSum = new int[w.length];
        for(int i=0;i<w.length;i++) {
            total += w[i];
            this.prefixSum[i] = total;
        }
    }

    public int pickIndex() {
        java.util.Random random = new java.util.Random();
        int target = random.nextInt(total);

        int start = 0;
        int end = prefixSum.length;
        int middle = -1;
        while(start<end) {
            middle = start + (end - start)/2;
            if (target>prefixSum[middle]) {
                start = middle + 1;
            } else {
                end = middle;
            }

        }
        return start;
    }
}
