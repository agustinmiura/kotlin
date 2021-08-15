package ar.com.miura.lc.array

class HayStack {
    fun strStr(haystack: String, needle: String): Int {
        var index = -1

        if (needle.length>haystack.length) {
            return -1
        }

        if (needle.isNullOrEmpty()) {
            return 0
        }

        for((i,hayStackChar) in haystack.withIndex()) {

            var found = true
            for((j,eachChar) in needle.withIndex()) {

                if ( (i+j)>=haystack.length ) {
                    found = false
                    break
                }

                if ( (haystack.get(i+j)) != eachChar ) {
                    found = false
                    break
                }

            }
            if (found) {
                return i
            }

        }

        return -1
    }
}