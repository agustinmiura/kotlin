package ar.com.miura.lc.swindows

/**
 * 159. Longest Substring with At Most Two Distinct Characters
 * Given a string s, return the length of the longest substring that contains at most two distinct characters.
    Input: s = "eceba"
    Output: 3
    Explanation: The substring is "ece" which its length is 3.

    Input: s = "ccaabbb"
    Output: 5
    Explanation: The substring is "aabbb" which its length is 5.
 */
class LongestSubstringAtMost {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        var size = s.length;

        if (size<3) {
            return size;
        }

        var left = 0;
        var right = 0;

        var map = mutableMapOf<Char,Int>();

        var maxSize = 2;

        while(right<size) {
            map.put(s[right], right);
            right++;

            if (map.size==3) {
                var deleteIndex = right;
                for((k,v) in map) {
                    deleteIndex = Math.min(deleteIndex,v);
                }
                map.remove(s[deleteIndex]);
                left = deleteIndex+1;
            }

            maxSize = Math.max(maxSize, right-left);
        }

        return maxSize;
    }
}