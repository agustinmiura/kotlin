package ar.com.miura.jvm.stack;

public class ValidParenthesis {
    public boolean isValid(String s) {
        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        java.util.Map<Character, Character> map = new java.util.HashMap<Character, Character>();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        for(int i=0;i<s.length();i++) {
            char current = s.charAt(i);
            boolean containsClosed = current==')' || current==']' || current=='}';
            if (!containsClosed) {
                stack.push(current);
            } else if (containsClosed && stack.isEmpty()) {
                return false;
            } else {
                Character inStack = stack.pop();
                Character expected = map.getOrDefault(current, 'X');
                if (!inStack.equals(expected)) {
                    return false;
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
