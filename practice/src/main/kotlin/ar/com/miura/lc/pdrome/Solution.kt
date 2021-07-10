package ar.com.miura.lc.pdrome

class Solution {
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