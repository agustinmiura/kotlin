package ar.com.miura.jvm.permutations.basic;

public class Permutations {
    public java.util.List<java.util.List<Integer>> permute(int[] nums) {
        java.util.List<java.util.List<Integer>> permutations = new java.util.ArrayList<java.util.List<Integer>>();
        permutations(nums, 0, permutations);
        return permutations;
    }

    private void permutations(int[] nums, int i, java.util.List<java.util.List<Integer>> permutations) {

        int size = nums.length;
        if (i==size-1) {
            permutations.add(convert(nums));
        } else {
            for(int j=i;j<size;j++) {
                swap(i,j, nums);
                permutations(nums, i+1, permutations);
                swap(j,i, nums);
            }
        }
    }

    private void swap(int i,int j, int[] nums) {
        int tempI = nums[i];
        int tempJ = nums[j];
        nums[i] = tempJ;
        nums[j] = tempI;
    }

    private java.util.List<Integer> convert(int[] numbers) {
        return java.util.Arrays.asList(
                java.util.Arrays.stream(numbers).boxed().toArray(Integer[]::new)
        );
    }
}
