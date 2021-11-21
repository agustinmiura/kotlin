package ar.com.miura.pramp

class SpiralTraverse {

    fun spiralTraverse(array: List<List<Int>>): List<Int> {

        var rowQty = array.size;
        var colQty = array[0].size;

        var startingCol = 0;
        var endingCol = colQty-1;

        var startingRow = 0;
        var endingRow = rowQty-1;

        var elementQty = rowQty*colQty;
        var elements = mutableListOf<Int>();

        var i=0;
        var j=0;
        while(elementQty>=1) {

            /*
            right
            */
            for(j in startingCol..endingCol) {
                elements.add(array[startingRow][j]);
                elementQty--;
            }
            startingRow++;
            if (startingRow>endingRow) {
                break;
            }

            /*
            Bottom
            */
            for(i in (startingRow)..endingRow) {
                elements.add(array[i][endingCol]);
                elementQty--;
            }
            endingCol--;
            if (startingCol > endingCol) {
                break;
            }


            /*
            Left
            */
            j = endingCol;
            while(j>=startingCol) {
                elements.add(array[endingRow][j]);
                elementQty--;
                j--
            }
            endingRow--;

            /*
            top
            */
            i = endingRow;
            while(i>=startingRow) {
                elements.add(array[i][startingCol]);
                elementQty--;
                i--;
            }

            startingCol++;

        }

        return elements;

    }
}