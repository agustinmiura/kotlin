package ar.com.miura.lc.sudoku

class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {

        val validRows = validRows(board)
        if (!validRows) {
            return false
        }

        val validCols = validCols(board)
        if (!validCols) {
            return false
        }
        val validSquare = validSquare(board)
        if (!validSquare) {
            return false
        }

        return true

    }

    private fun validRows(board: Array<CharArray>):Boolean {

        var max = board.size
        for((i,charArray) in board.withIndex()) {

            var charSet= mutableSetOf<Char>()

            for((index,value) in charArray.withIndex()) {

                if (value!='.') {
                    if (charSet.contains(value)) {
                        return false

                    } else {
                        charSet.add(value)
                    }
                }
            }
        }
        return true
    }

    private fun validCols(board: Array<CharArray>):Boolean {
        var max = board.size

        var colNumber = 0
        while(colNumber<max) {

            var charSet = mutableSetOf<Char>()

            for(charArray in board) {

                var value:Char = charArray.get(colNumber)
                if (value!='.' && charSet.contains(value)) {
                    return false
                } else if(value!='.') {
                    charSet.add(value)
                }
            }

            colNumber++
        }
        return true

    }

    private fun validSquare(board: Array<CharArray>):Boolean {

        val startPositions = mutableListOf<IntArray>(
            intArrayOf(0,0), intArrayOf(0,3),intArrayOf(0,6),
            intArrayOf(3,0), intArrayOf(3,3),intArrayOf(3,6),
            intArrayOf(6,0), intArrayOf(6,3),intArrayOf(6,6)
        )

        for(position in startPositions) {
            val validSquare = validSquare(board, position)
            if (!validSquare) {
                return false
            }
        }
        return true
    }

    private fun validSquare(board:Array<CharArray>, ints:IntArray):Boolean {
        var index = ints[0]
        var max = index+3
        val charSet = mutableSetOf<Char>()
        while(index<max) {

            var charArray = board.get(index)
            var j=ints[1]
            var maxJ = j+3
            while(j<maxJ) {

                var value = charArray.get(j)
                if (value!='.' && charSet.contains(value)) {
                    return false
                } else if(value!='.') {
                    charSet.add(value)
                }

                j++
            }

            index++
        }

        return true

    }

}