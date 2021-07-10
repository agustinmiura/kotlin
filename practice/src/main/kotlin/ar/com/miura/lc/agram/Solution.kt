package ar.com.miura.lc.agram

class Solution {
    fun isAnagram(s: String, t: String): Boolean {

        var sSize = s.length
        var tSize = t.length

        if (sSize!=tSize) {
            return false
        }

        var sMap = toMap(s)
        var tMap = toMap(t)

        for((keyS,valueS) in sMap) {

            var valueT = tMap.getOrDefault(keyS,0)
            if (valueT!=valueS) {
                return false
            }

        }

        return true

    }

    private fun toMap(s:String):MutableMap<Char,Int> {

        var map = mutableMapOf<Char,Int>()
        for((k,v) in s.withIndex()) {
            var qty = map.getOrDefault(v,0)
            qty++
            map.put(v,qty)
        }
        return map
    }


}