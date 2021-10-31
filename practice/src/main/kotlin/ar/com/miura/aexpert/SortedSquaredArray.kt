package ar.com.miura.aexpert

class SortedSquaredArray {
    fun sortedSquaredArray(array: List<Int>): List<Int> {
        var squareArray = mutableListOf<Int>();
        for(i in array) {
            squareArray.add( Math.abs(i*i) );
        }
        squareArray.sort();
        return squareArray;
    }
}