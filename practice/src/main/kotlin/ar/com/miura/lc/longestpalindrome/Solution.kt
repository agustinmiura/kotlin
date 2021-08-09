package ar.com.miura.lc.longestpalindrome

class Solution {
    fun longestPalindrome(s: String): Int {
        var size = s.length

        var dp:Array<IntArray> = Array<IntArray>(size+1, { IntArray(size+1, {0})})

        var start = size-1
        for(l in start downTo 0) {
            dp[l][l] = 1
            for(r in (l+1)..(size-1)) {
                if (s.get(l)==s.get(r)) {
                    dp[l][r] = dp[l+1][r-1]+2
                } else {
                    dp[l][r] = Math.max(dp[l+1][r], dp[l][r-1])
                }
            }
        }
        return dp[0][size-1]
    }

    /**
     * Strings to test:
        "babad"
        "cbbd"
        "a"
        "ac"
        "abcda"
     */
    fun getString(s:String):String {
        if (s.length==1) {
            return s
        } else if (s.length==2) {
            if (s.get(0)==s.get(1)) {
                return s
            } else {
                return s.get(0).toString()
            }
        }

        var size = s.length

        var dp:Array<Array<Boolean>> = Array<Array<Boolean>>(size+1, { Array(size+1, {false})})

        var max = Int.MIN_VALUE
        var left = 0
        var right = 0

        var found = ""
        var start = size - 1
        for(l in start downTo 0) {
            dp[l][l] = true
            for(r in (l+1)..(size-1)) {
                dp[l][r] = s.get(l)==s.get(r)
                dp[l][r] = dp[l][r] && ( (r-l)<3 || dp[l+1][r-1] )

                if (dp[l][r] &&  (found.length==0 || (r-l+1)>found.length) ) {
                    found = s.substring(l,r+1)
                }
            }
        }
        if (found.length==0) {
            return s.get(0).toString()
        }
        return found
    }
}