package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/559/
 */
class PlusOne {

    fun plusOne(digits: IntArray): IntArray {

        var index = digits.size-1
        while(index>=0) {

            if (digits[index]==9) {
                digits[index]=0
            } else {
                digits[index]+=1
                return digits
            }
            index--
        }

        val size = digits.size
        val newDigits = IntArray(size+1)
        newDigits[0]=1
        for((i,v) in digits.withIndex()) {
            newDigits[i+1]=v
        }

        return newDigits
    }

}