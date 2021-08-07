package ar.com.miura.lc.merge

class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

        var nums1Clone:IntArray = IntArray(m)
        var maxIndex = m-1
        for(i in 0..maxIndex) {
            nums1Clone[i] = nums1[i]
        }

        var i=0
        var j=0
        var num1Size = m
        var num2Size = n
        var k=0

        while( (i<num1Size) && (j<num2Size) ) {

            if (nums1Clone[i]<nums2[j]) {
                nums1[k] = nums1Clone[i]
                i++
            } else {
                nums1[k]=nums2[j]
                j++
            }

            k++
        }

        while( (i<num1Size) ) {
            nums1[k] = nums1Clone[i]
            i++
            k++
        }

        while ( (j<num2Size)) {
            nums1[k] = nums2[j]
            j++
            k++
        }
    }
}