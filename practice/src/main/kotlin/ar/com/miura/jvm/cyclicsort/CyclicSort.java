package ar.com.miura.jvm.cyclicsort;

public class CyclicSort {
    public int missingNumber(int[] nums) {
        int i = 0;
        int size = nums.length;
        while(i<size) {

            int number = nums[i];
            if (number<size && number!=i) {
                swap(nums, number, i);
            } else {
                i++;
            }
        }
        for(int j=0;j<size;j++) {
            if (nums[j]!=j) {
                return j;
            }
        }
        return nums.length;
    }

    private void swap(int[] nums,int i, int j) {
        int tempI = nums[i];
        int tempJ = nums[j];
        nums[i] = tempJ;
        nums[j] = tempI;
    }
}
