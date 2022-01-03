package ar.com.miura.jvm.array;

public class TwoSumLessK {
    public int twoSumLessThanK(int[] nums, int k) {

        int[] cloned = nums.clone();
        Arrays.sort(cloned);
        int left = 0;
        int right = cloned.length-1;

        int sum = Integer.MIN_VALUE;

        while(left<right) {
            int currentSum = cloned[left] + cloned[right];
            if (currentSum<k && currentSum>sum) {
                sum = currentSum;
            } else if (currentSum>=k) {
                right--;
            } else {
                left++;
            }
        }

        if (sum!=Integer.MIN_VALUE) {
            return sum;
        } else {
            return -1;
        }

    }
}
