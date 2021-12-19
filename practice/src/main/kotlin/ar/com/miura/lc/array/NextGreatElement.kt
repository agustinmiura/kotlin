package ar.com.miura.lc.array

class NextGreatElement {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {

        val mapPosition = mutableMapOf<Int,Int>();
        var position = -1;
        for(num2 in nums2) {
            position++;
            mapPosition.put(num2, position);
        }

        val greaterElements = IntArray(nums1.size) {-1};

        var secondArrayGreater = IntArray(nums2.size) {-1};
        var secondArraySize = nums2.size;
        for(i in 0..(secondArraySize-1)) {
            var start = i+1;
            var element = nums2[i];
            var greatElement = -1;
            for(j in (start..(secondArraySize-1))) {
                if (nums2[j]>element) {
                    greatElement = nums2[j];
                    break;
                }

            }
            secondArrayGreater[i] = greatElement;
        }

        var index = -1;
        for(num1 in nums1) {
            index++;

            var foundIndex = mapPosition.getOrDefault(num1, -1);
            greaterElements[index] = secondArrayGreater[foundIndex];

        }


        return greaterElements;
    }
}