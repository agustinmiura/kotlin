package ar.com.miura.lc.swindows.sequence2

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        var start = 0
        var end = 0
        var max = 0

        var chars = mutableSetOf<Char>()

        while(end<s.length) {

            if (!chars.contains(s.get(end))) {

                chars.add(s.get(end))
                end++
                max = Math.max(max, chars.size)

            } else {

                chars.remove(s.get(end))
                start++

            }

        }

        return max
    }
}