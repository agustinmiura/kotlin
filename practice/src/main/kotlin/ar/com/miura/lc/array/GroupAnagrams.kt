package ar.com.miura.lc.array

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/103/array-and-strings/778/
 */
class GroupAnagrams {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for ((k, word) in strs.withIndex()) {
            var charArray = word.toCharArray()
            charArray.sort()
            var key = String(charArray)

            var words = map.getOrDefault(key, mutableListOf<String>())
            words.add(word)
            map.put(key, words)
        }

        var anagrams = mutableListOf<List<String>>()
        for ((k, v) in map) {
            anagrams.add(v)
        }

        return anagrams.sortedWith(compareBy { it.size })
    }
}