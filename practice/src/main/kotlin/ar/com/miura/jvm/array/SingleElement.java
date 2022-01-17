package ar.com.miura.jvm.array;

public class SingleElement {
    public int singleNonDuplicate(int[] nums) {
        java.util.Arrays.sort(nums);
        int size = nums.length;
        int qty = 1;
        int element = nums[0];
        for(int i=1;i<size;i++) {
            if (nums[i]==nums[i-1]) {
                qty++;
            } else {
                if (qty==1) {
                    return element;
                } else {
                    element = nums[i];
                    qty = 1;
                }
            }
        }
        return element;
    }
}
