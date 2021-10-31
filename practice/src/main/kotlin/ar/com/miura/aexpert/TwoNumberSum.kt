package ar.com.miura.aexpert

class TwoNumberSum {
    fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {

        var solutions = mutableListOf<Int>();

        val numbersMap = mutableMapOf<Int,Int>();

        var remainder = 0;
        for(i in array) {
            remainder = targetSum-i;
            if (numbersMap.contains(i)) {
                solutions.add(i)
                solutions.add(remainder)
            } else {
                numbersMap.put(remainder,i);
            }
        }
        return solutions;

    }

}