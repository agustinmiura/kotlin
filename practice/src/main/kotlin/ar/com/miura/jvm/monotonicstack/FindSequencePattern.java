package ar.com.miura.jvm.monotonicstack;

public class FindSequencePattern {
    public boolean find132pattern(int[] nums) {

        if (nums.length<3) {
            return false;
        }

        Stack<Integer> stack = new Stack<Integer>();

        int[] min = new int[nums.length];

        /**
         * Get the i index now
         **/
        min[0] = nums[0];
        for(int i=1;i<nums.length;i++) {
            min[i] = Math.min(min[i-1], nums[i]);
        }

        for(int j=nums.length-1;j>=0;j--) {

            /*
            We have found a valid interval for the k let's try to find the k
            */
            if (nums[j]>min[j]) {
                /*
                In the stack I don't have any valid k candidate
                */
                while( !stack.isEmpty() && stack.peek()<= min[j] ) {
                    stack.pop();
                }

                /*
                In the stack I have a valid candidate
                */
                if ( !stack.isEmpty() && stack.peek() < nums[j] ) {
                    return true;
                }

                stack.push(nums[j]);

            }

        }

        return false;

    }
}
