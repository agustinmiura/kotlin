package ar.com.miura.lc.stack;

public class MakeGood {
    public String makeGood(String s) {

        if (s.length()==0 || s==null) {
            return "";
        } else if (s.length()==1) {
            return s;
        }

        java.util.Stack<Character> stack = new java.util.Stack<Character>();

        int size = s.length();

        Character aChar = s.charAt(0);
        stack.push(aChar);

        for(int i=1;i<size;i++) {
            aChar = s.charAt(i);

            if (!stack.isEmpty()) {

                Character topFound = stack.peek();
                boolean sameChar = Character.toLowerCase(topFound)==(Character.toLowerCase(aChar));
                boolean isStackLower = Character.isLowerCase(topFound);
                boolean isCharLower = Character.isLowerCase(aChar);
                boolean badOne = false;
                if ( (sameChar && isStackLower && !isCharLower) || (sameChar && !isStackLower && isCharLower) ) {
                    stack.pop();
                } else {
                    stack.push(aChar);
                }

            } else {
                stack.push(aChar);
            }

        }

        java.util.Stack<Character> reversed = new java.util.Stack<Character>();

        while(!stack.isEmpty()) {
            reversed.push(stack.pop());
        }

        StringBuilder sBuilder = new StringBuilder();
        while(!reversed.isEmpty()) {
            sBuilder.append(reversed.pop());
        }

        return sBuilder.toString();

    }
}
