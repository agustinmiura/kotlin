package ar.com.miura.lc.matching

class Solution {
    fun countMatches(items: List<List<String>>, ruleKey: String, ruleValue: String): Int {

        var matches = 0
        for(eachItem in items) {
            val type = eachItem[0]
            val color = eachItem[1]
            val name = eachItem[2]

            if (ruleKey.equals("type")) {
                if (ruleValue.equals(type)) {
                    matches++
                }
            } else if (ruleKey.equals("color")) {
                if (ruleValue.equals(color)) {
                    matches++
                }
            } else {
                if (ruleValue.equals(name)) {
                    matches++
                }
            }

        }
        return matches
    }
}