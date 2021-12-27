package ar.com.miura.lc.array

/**
 * 238. Product of Array Except Self
    Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
    The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
    You must write an algorithm that runs in O(n) time and without using the division operation.
 */
class ProductOfArraySelf {
    fun productExceptSelf(nums: IntArray): IntArray {

        var size = nums.size;

        var leftNumbers = IntArray(size){i -> 1};
        var rightNumbers = IntArray(size){ i -> 1};

        //fill the left array
        for(i in 1..(size-1)) {
            leftNumbers[i] = nums[i-1] * leftNumbers[i-1];
        }
        //fill the right array
        var i = size-2;
        while(i>=0) {
            rightNumbers[i] = rightNumbers[i+1] * nums[i+1];
            i--;
        }

        var product = IntArray(size){ i -> 1};
        for(i in 0..(size-1)) {
            product[i] = leftNumbers[i] * rightNumbers[i];
        }

        return product;

    }
}