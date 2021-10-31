package ar.com.miura.aexpert

class ValidateSubSequence {
    fun isValidSubsequence(array: List<Int>, sequence: List<Int>): Boolean {

        var arrayIndex = 0;
        var sequenceIndex = 0;
        while(arrayIndex < array.size && sequenceIndex < sequence.size) {
            if (array[arrayIndex] == sequence[sequenceIndex]) {
                sequenceIndex++;
            }
            arrayIndex++;
        }
        return sequenceIndex == sequence.size;
    }

}