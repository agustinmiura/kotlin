package ar.com.miura.jvm.cyclicsort;

public class FindAllNumbersMissing {
    public java.util.List<Integer> findDisappearedNumbers(int[] nums) {
        int size = nums.length;
        int index = 0;
        while(index<size) {
            int number = nums[index];
            if(number<(size+1) && nums[index]!=(index+1) && nums[number-1]!=number) {
                swap(nums, index, number-1);
            } else {
                index++;
            }
        }
        java.util.List<Integer> missing = new java.util.ArrayList<Integer>();
        for(int i=0;i<size;i++) {
            int number = nums[i];
            if (number!=(i+1)) {
                missing.add(i+1);
            }
        }
        return missing;
    }
    private void swap(int[] nums,int i, int j) {
        int tempI = nums[i];
        int tempJ = nums[j];
        nums[i] = tempJ;
        nums[j] = tempI;
    }
}
