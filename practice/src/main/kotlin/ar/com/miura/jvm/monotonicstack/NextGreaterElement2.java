package ar.com.miura.jvm.monotonicstack;

public class NextGreaterElement2 {
    public int[] nextGreaterElements(int[] nums) {

        int size = nums.length;
        int[] nextGreatest = new int[size];
        java.util.Arrays.fill(nextGreatest, -1);

        java.util.Stack<Integer> stack = new java.util.Stack<Integer>();
        fillArray(nums, nextGreatest, stack);
        fillArray(nums, nextGreatest, stack);

        return nextGreatest;
    }

    private void fillArray(int[] nums,int[] greatest, java.util.Stack<Integer> stack) {
        int size = greatest.length;
        for(int i=size-1; i>=0; i--) {
            int element = nums[i];
            while(!stack.isEmpty() && ( nums[stack.peek()] <= element )) {
                stack.pop();
            }
            greatest[i] = (stack.isEmpty()) ? (-1) : (nums[stack.peek()]);
            stack.push(i);
        }
    }
}
