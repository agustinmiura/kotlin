package ar.com.miura.lc.design

class Vector2D(vec: Array<IntArray>) {

    val vector = vec;

    var i = 0;
    var j = 0;

    /**
     * Assume all the calls next are valid
     */
    fun next(): Int {
        if (hasNext()) {
            var element =  vector[i][j];
            j++;
            return element;
        }
        throw Exception("Error here");
    }

    /**
     *
     */
    fun hasNext(): Boolean {
        var rowQty = vector.size;
        while( i<rowQty && j>= (vector[i].size) ) {
            i++;
            j=0;
        }
        return (i<rowQty);
    }

}