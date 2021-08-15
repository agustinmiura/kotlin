package ar.com.miura.lc.others

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-medium/108/trees-and-graphs/786/
 */
class ReverseNotation {
    fun evalRPN(tokens: Array<String>): Int {

        var symbols = mutableSetOf<String>("+","-","*","/")
        var stack:Stack<String> = Stack<String>()

        var max = tokens.size
        for((i,v) in tokens.withIndex()) {

            if (symbols.contains(v)) {
                solveOperation(stack, v)
            } else {
                stack.push(v)
            }
        }
        return stack.pop().toInt();
    }

    private fun solveOperation(stack:Stack<String>, operation:String) {

        var operand1 = stack.pop()
        var operand2 = stack.pop()

        var result = 0
        if (operation=="+") {
            result = operand1.toInt() + operand2.toInt()
        } else if (operation=="-") {
            result = operand2.toInt() - operand1.toInt()
        } else if (operation=="*") {
            result = operand1.toInt() * operand2.toInt()
        } else if (operation=="/") {
            result = operand2.toInt() / operand1.toInt()
        } else {
            throw RuntimeException("Error")
        }
        stack.push(result.toString())

    }
}