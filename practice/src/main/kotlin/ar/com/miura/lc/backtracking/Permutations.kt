package ar.com.miura.lc.backtracking

class Permutations {

    fun getPermutations(array: List<Int>): List<List<Int>> {
        var permutations = mutableListOf<List<Int>>();
        permutationsHelper(0, array.toMutableList(), permutations);
        return permutations;
    }

    private fun permutationsHelper(index:Int, array:MutableList<Int>, permutations: MutableList<List<Int>>) {
        if (index==array.size-1) {
            permutations.add(array)

        } else {
            var size = array.size;
            for(j in 0..(size-1)) {
                swap(array, index, j);
                permutationsHelper(index+1, array, permutations);
                swap(array,j,index);
            }
        }
    }

    private fun swap(array:MutableList<Int>, i:Int, j:Int) {
        var tempI = array.get(i);
        var tempJ = array.get(j);
        array.set(i, tempJ);
        array.set(j, tempI)
    }

}