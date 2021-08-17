package ar.com.miura.lc.backtracking

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/109/backtracking/794/
 */
class Parenthesis {
    fun generateParenthesis(n: Int): List<String> {
        var strings = mutableListOf<String>()
        backtrack(strings, "", 0, 0, n)
        return strings

    }

    private fun backtrack(
        strings: MutableList<String>,
        currentString: String,
        openQty: Int,
        closeQty: Int,
        max: Int
    ) {

        if (currentString.length == max * 2) {
            strings.add(currentString)
            return

        }

        if (openQty < max) {
            backtrack(strings, currentString + "(", openQty + 1, closeQty, max)
        }

        if (closeQty < openQty) {
            backtrack(strings, currentString + ")", openQty, closeQty + 1, max)
        }

    }
}