package ar.com.miura.lc.array

class MaxAscendingSum {
    fun maxAscendingSum(nums: IntArray): Int {

        var max = nums[0]
        var currentMax = nums[0]

        var remaining = nums.size -1

        var index = 1
        while(remaining>=1) {

            if (nums[index-1]<nums[index]) {
                currentMax += nums[index]
                index++
                remaining--

                if (currentMax>max) {
                    max = currentMax
                }

            } else {
                currentMax = nums[index]

                index++
                remaining--


                if (currentMax>max) {
                    max = currentMax
                }



            }
        }
        return max

    }
}