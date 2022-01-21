package ar.com.miura.jvm.slidewindow;

public class FindConsecutiveOnes {
    public int findMaxConsecutiveOnes(int[] nums) {
        int minValue = -1;
        int max = 0;
        int counter = 0;
        int size = nums.length;
        for(int i=0; i<size; i++) {
            int value = nums[i];
            if (value==1) {
                counter++;
                if (counter>max) {
                    max = counter;
                }
            } else {
                counter = 0;
            }
        }
        return max;
    }
}
