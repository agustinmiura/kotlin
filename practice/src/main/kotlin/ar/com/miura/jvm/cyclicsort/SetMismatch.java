package ar.com.miura.jvm.cyclicsort;

public class SetMismatch {
    public int[] findErrorNums(int[] nums) {
        int size = nums.length;
        int index = 0;

        while(index<size) {
            int number = nums[index];

            if ( (number<=size) && (nums[index]!=(index+1)) && (nums[number-1]!= number ) ) {
                swap(nums, index, number-1);
            } else {
                index++;
            }
        }

        for(int i=0;i<size;i++) {
            if (nums[i]!=(i+1)) {
                return new int[]{nums[i],i+1};
            }
        }
        return new int[]{};

    }

    private void swap(int[] nums, int i, int j) {
        int tempI = nums[i];
        int tempJ = nums[j];
        nums[i] = tempJ;
        nums[j] = tempI;
    }
}
