package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/674/
 */
class IntersectionOfTwoArrays {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {

        var nums1Sorted = nums1.sortedArray();
        var nums2Sorted = nums2.sortedArray();

        var i = 0;
        var j = 0;

        var intersection = mutableListOf<Int>();
        while( (i<nums1Sorted.size) && (j<nums2Sorted.size) ) {

            if (nums1Sorted[i]==nums2Sorted[j]) {
                intersection.add(nums1Sorted[i]);
                i++;
                j++;

            } else if (nums1Sorted[i]<nums2Sorted[j]) {
                i++;

            } else {
                j++;
            }
        }
        return intersection.toIntArray();
    }
}