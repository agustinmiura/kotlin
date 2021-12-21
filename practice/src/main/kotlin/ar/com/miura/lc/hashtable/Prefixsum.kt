package ar.com.miura.lc.hashtable

class Prefixsum {
    fun maxSubArrayLen(nums: IntArray, k: Int): Int {

        var prefixSum = 0;
        var longestSubarray = 0;

        var map = mutableMapOf<Int,Int>();

        var size = nums.size;

        for(i in 0..(size-1)) {
            prefixSum += nums[i];

            /*
            If prefix sum == k so far we have the value
            */
            if (prefixSum == k) {
                longestSubarray = i+1;
            }

            /*
            If any subarray sums to k then
            update (prefixSum - k) means
            in this point I reached the number
            array = [-2,-1, 2 ,1]
            prefix =[-2,-3,-1,0]
                      *     *
                            here prefixSum = -1
                      *
                    prefixSum-k
            K = 1
            prefix sum - k = -1 - 1 = -2

            if there exists some subarray from i to j summing to  k in nums, then we know that
            prefixSum[j] - prefixSum[i] = k
            prefixSum[j] - prefixSum[i] - k = 0
            prefixSum[j] - k = prefixSum[i]

            */
            if (map.contains(prefixSum-k)) {
                longestSubarray = Math.max(longestSubarray, i - map.get(prefixSum-k)!!);
            }

            if (!map.contains(prefixSum)) {
                map.put(prefixSum, i);
            }

        }

        return longestSubarray;
    }
}