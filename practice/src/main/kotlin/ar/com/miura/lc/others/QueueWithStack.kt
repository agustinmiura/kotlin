package ar.com.miura.lc.others

import java.util.Stack

/**
 * Queue using stack
 */
class QueueWithStack {

    private val mainStack: Stack<Int> = Stack<Int>();
    private val auxStack:Stack<Int> = Stack<Int>();

    fun push(x: Int) {
        mainStack.push(x);
    }

    fun pop(): Int {

        while(!mainStack.isEmpty()) {
            val top = mainStack.pop();
            auxStack.push(top);
        }

        val top = auxStack.pop();

        while(!auxStack.isEmpty()) {
            val auxTop = auxStack.pop();
            mainStack.push(auxTop);
        }

        return top;

    }

    fun peek(): Int {

        while(!mainStack.isEmpty()) {
            val top = mainStack.pop();
            auxStack.push(top);
        }


        val top = auxStack.peek();

        while(!auxStack.isEmpty()) {
            val auxTop = auxStack.pop();
            mainStack.push(auxTop);
        }


        return top;
    }

    fun empty(): Boolean {
        return mainStack.isEmpty();
    }
}