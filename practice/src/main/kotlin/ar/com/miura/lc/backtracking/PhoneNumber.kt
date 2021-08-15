package ar.com.miura.lc.backtracking

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/109/backtracking/793/
 */
class PhoneNumber {
    var phone = mutableMapOf<String,String>(
        "2" to "abc",
        "3" to "def",
        "4" to "hgi",
        "5" to "jlk",
        "6" to "mno",
        "7" to "pqrs",
        "8" to "tuv",
        "9" to "wxyz"
    )

    var output = mutableListOf<String>()

    private fun backtrack(combination:String, nextDigits:String) {

        if (nextDigits.length==0) {
            output.add(combination)

        } else {
            var digit = nextDigits.substring(0,1)
            var letters = phone.get(digit)

            for(i in 0..(letters!!.length-1)) {
                var letter = phone.getOrDefault(digit, "").substring(i, i+1)
                backtrack(combination + letter, nextDigits.substring(1))
            }
        }

    }

    fun letterCombinations(digits: String): List<String> {
        if (digits.length>=1) {
            backtrack("", digits)
        }
        return output
    }
}