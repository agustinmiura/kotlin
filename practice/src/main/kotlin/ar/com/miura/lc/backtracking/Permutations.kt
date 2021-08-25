package ar.com.miura.lc.backtracking

class Permutations {

    fun getPermutations(array: List<Int>): List<List<Int>> {
        var permutations = mutableListOf<List<Int>>();
        permutationsHelper(0, array.toMutableList(), permutations);
        return permutations;
    }

    private fun permutationsHelper(i:Int, array:MutableList<Int>, permutations: MutableList<List<Int>>) {
        if (i==array.size-1) {
            permutations.add(array.toMutableList())

        } else {
            var size = array.size;
            for(j in i..(size-1)) {
                swap(array, i, j);
                permutationsHelper(i+1, array, permutations);
                swap(array,j,i);
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