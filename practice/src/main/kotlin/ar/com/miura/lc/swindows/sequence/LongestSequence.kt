package ar.com.miura.lc.swindows.sequence

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        if (s.isBlank()) {
            return 0
        }

        var i = 0
        var j = 0
        var max = 0
        var chars = mutableSetOf<Char>()

        while (i < s.length) {
            var char = s.get(i)
            while (chars.contains(char)) {
                chars.remove(char)
                ++j
            }
            chars.add(char)
            max = Math.max(max, i - j + 1)
            ++i
        }
        return max
    }
}