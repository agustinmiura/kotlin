package java.ar.com.miura.array;

public class ShortestUnsortedContinuousArray {
    public int findUnsortedSubarray(int[] nums) {

        int size = nums.length;

        boolean isSorted = true;
        for(int i=1;i<size;i++) {
            if (nums[i-1]>nums[i]) {
                isSorted = false;
            }
        }
        if (isSorted) {
            return 0;
        }

        int[] sorted = nums.clone();
        java.util.Arrays.sort(sorted);


        int start = sorted.length;
        int end = 0;
        for(int i=0;i<size;i++) {
            if (sorted[i]!=nums[i]) {
                start = Math.min(start,i);
                end = Math.max(end, i);
            }
        }

        return (end-start+1);

    }
}
