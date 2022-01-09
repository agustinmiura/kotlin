package ar.com.miura.jvm.string;

/**
 * https://leetcode.com/contest/weekly-contest-234/problems/evaluate-the-bracket-pairs-of-a-string/
 */
public class PairBracketStrings {

    public String evaluate(String s, java.util.List<java.util.List<String>> knowledge) {

        //build the map
        java.util.Map<String, String> dictionary = new java.util.HashMap();

        for(java.util.List<String> eachList:knowledge) {
            dictionary.put(eachList.get(0), eachList.get(1));
        }

        int i=1;
        char beforeChar = s.charAt(0);
        int size = s.length();


        StringBuilder evaluated = new StringBuilder();
        if (Character.isAlphabetic(beforeChar)) {
            evaluated.append(beforeChar);
        }

        java.util.Stack<Character> stack = new java.util.Stack<Character>();
        boolean fillingStack = false;

        while(i<size) {

            /*
            Input: s = "(name)is(age)yearsold", knowledge = [["name","bob"],["age","two"]]
            Input: s = "hi(name)", knowledge = [["a","b"]]
            Input: s = "(a)(a)(a)aaa", knowledge = [["a","yes"]]
            Input: s = "(a)(b)", knowledge = [["a","b"],["b","a"]]
            */
            char currentChar = s.charAt(i);

            if (beforeChar=='(') {
                fillingStack = true;
                stack.push(currentChar);

            } else if (Character.isAlphabetic(currentChar) && !fillingStack) {

                evaluated.append(currentChar);

            } else if (Character.isAlphabetic(currentChar) && fillingStack) {

                stack.push(currentChar);

            } else if (currentChar==')') {

                String key = getKey(stack);
                stack.clear();
                fillingStack = false;
                String value = dictionary.getOrDefault(key, "?");
                evaluated.append(value);

            }

            beforeChar = currentChar;
            i++;
        }

        return evaluated.toString();
    }

    private String getKey(java.util.Stack<Character> stack) {
        int size = stack.size();
        char[] charArray = new char[size];
        int i = size-1;
        while(i>=0) {
            charArray[i] = stack.pop();
            i--;
        }
        return new String(charArray);
    }

}
