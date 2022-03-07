package ar.com.miura.jvm.binarysearch;

public class GetRange {
    
    public int[] searchRange(int[] nums, int target) {
        int left = getLeft(nums,target);
        int right = getRight(nums, target);
        int[] range = {left,right};
        return range;
    }

    public int getRight(int[] nums,int target) {
        int left = 0;
        int size = nums.length;
        int right = size - 1;

        int value = -1;

        while(left<=right) {
            int middle = left + (right - left)/2;
            if (target<nums[middle]) {
                right = middle - 1;
            } else {
                if (target==nums[middle]) {
                    value = middle;
                }
                left = middle + 1;
            }
        }
        return value;
    }

    public int getLeft(int[] nums,int target) {
        int left = 0;
        int size = nums.length;
        int right = size - 1;

        int val = -1;
        while(left <= right) {
            int middle = left + (right - left) / 2;
            if (target < nums[middle]) {
                right = middle - 1;
            } else {
                if (nums[middle]==target) {
                    val = middle;
                }
                left = middle + 1;
            }
        }
        return val;
    }
}
