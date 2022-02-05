package ar.com.miura.jvm.array;

/**
 * Given an array of integers nums, half of the integers in nums are odd, and the other half are even.
 * Sort the array so that whenever nums[i] is odd, i is odd, and whenever nums[i] is even, i is even.
 * Return any answer array that satisfies this condition.
 */
public class SortByParity2 {
    private static final int INVALID = -1;

    public int[] sortArrayByParityII(int[] nums) {

        java.util.LinkedList<Integer> evenNumbers = new java.util.LinkedList<Integer>();
        java.util.LinkedList<Integer> oddNumbers = new java.util.LinkedList<Integer>();

        int size = nums.length;
        for(int i=0;i<size;i++) {
            int number = nums[i];
            if ((number%2==0 && i%2!=0)) {
                nums[i] = -1;
                evenNumbers.add(number);
            } else if (number%2!=0 && i%2==0) {
                nums[i] = -1;
                oddNumbers.add(number);
            }
        }

        for(int i=0;i<size;i=i+2) {
            if (nums[i]==-1) {
                int toSet = evenNumbers.getFirst();
                nums[i] = toSet;
                evenNumbers.removeFirst();
            }
        }

        for(int i=1;i<size;i=i+2) {
            if (nums[i]==-1) {
                int toSet = oddNumbers.getFirst();
                nums[i] = toSet;
                oddNumbers.removeFirst();
            }
        }

        return nums;
    }
}
