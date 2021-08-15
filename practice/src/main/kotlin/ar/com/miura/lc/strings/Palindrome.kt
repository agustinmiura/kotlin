package ar.com.miura.lc.palindrome

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/127/strings/883/
 */
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

class Palindrome {
    fun isPalindrome(s: String): Boolean {


        var filteredString = filterString(s)

        var i = 0
        var j = filteredString.length-1

        while(i<j) {
            if (filteredString.get(i)!=filteredString.get(j)) {
                return false
            }
            i++
            j--
        }

        return true

    }

    fun filterString(s:String):String {

        var sBuilder = StringBuilder()
        for((k,v) in s.withIndex()) {
            if ((v >= 'a' && v<= 'z') ||
                (v >='A' && v<='Z') ||
                (v >='0' && v<='9')) {
                sBuilder.append(v.toLowerCase())
            }
        }
        return sBuilder.toString()
    }

}