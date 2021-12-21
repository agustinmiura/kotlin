package ar.com.miura.lc.strings

import java.util.Stack

class RemoveKDigits {
    fun removeKdigits(num: String, k: Int): String {

        var leftNumbers = k;
        val size = num.length;
        /*
        cornre case remove all chars
        */
        if (size==leftNumbers) {
            return "0";
        }

        val stack = Stack<Char>();
        var i = 0;
        while(i<size) {
            //whenever meet a digit which is less than the previous digit, discard the previous one
            while(leftNumbers>0 && !stack.isEmpty() && stack.peek()>num[i]) {
                stack.pop();
                leftNumbers--;
            }
            //push the number in the stack
            stack.push(num[i]);
            i++;
        }

        //corner case "1111"
        //we didn't remove any number
        while(leftNumbers>0) {
            stack.pop();
            leftNumbers--;
        }

        /*
        construct the number
        */
        var sBuilder = StringBuilder();
        while(!stack.isEmpty()) {
            sBuilder.append(stack.pop())
        }
        sBuilder.reverse();

        while(sBuilder.length>1 && sBuilder[0]=='0') {
            sBuilder.deleteCharAt(0);
        }

        return sBuilder.toString();
    }
}