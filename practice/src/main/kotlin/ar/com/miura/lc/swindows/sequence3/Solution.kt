package ar.com.miura.lc.swindows.sequence3

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        if (s.length == 0) {
            return 0
        }

        var start = 0
        var end = 0
        var chars = mutableMapOf<Char,Int>()
        var target = 0
        while(end<s.length) {

            var char = s.get(end)

            if (chars.containsKey(char)) {

                var position = chars.getOrDefault(char,0)+1
                start = Math.max(start, position)
                chars.put(char, end)

            } else {

                chars.put(char, end)

            }

            target = Math.max(target,end-start+1)
            end++

        }
        return target
    }
}