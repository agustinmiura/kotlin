package ar.com.miura.lc.array

class IntersectionOfThreeArrays {
    fun arraysIntersection(arr1: IntArray, arr2: IntArray, arr3: IntArray): List<Int> {

        val commonIntegers = mutableListOf<Int>();
        val secondSet = mutableSetOf<Int>();
        var thirdSet = mutableSetOf<Int>();

        for(int in arr2) {
            secondSet.add(int);
        }
        for(int in arr3) {
            thirdSet.add(int);
        }

        for(int in arr1) {
            if (secondSet.contains(int) && thirdSet.contains(int)) {
                commonIntegers.add(int);
            }
        }

        return commonIntegers.toList();

    }
}