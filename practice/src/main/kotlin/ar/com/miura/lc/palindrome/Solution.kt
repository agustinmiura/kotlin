package ar.com.miura.lc.palindrome

fun main() {

    var intValue:Int? = null
    println(" ${intValue} ")

    val size = 6
    var matrix = Array(size){Array(size){false}}
    matrix[0][0] = true
    println("Hello")

}

class Solution {

    fun longestPalindrome(s: String): String {

        var maxString = ""
        var stringSize = s.length

        var matrix = Array(stringSize, { i -> Array(stringSize, { j -> false })})

        for(i in 0..(stringSize-1)) {
            matrix[i][i] = true
        }

        for(i in stringSize-1 downTo 0) {
            for(j in (i+1)..stringSize-1) {

                if (j-i==2 && s.get(i)==s.get(j)) {
                    matrix[i][j] = true
                } else {

                }

            }
        }
        return ""
    }

}