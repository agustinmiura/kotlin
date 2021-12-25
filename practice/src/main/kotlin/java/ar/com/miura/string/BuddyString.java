package java.ar.com.miura.string;

public class BuddyString {
    public boolean buddyStrings(String s, String goal) {

        /*
        different length we have a problem
        */
        if (s.length()!=goal.length()) {
            return false;
        }

        /*
        If they are equal only if they have repeated characters
        "aa" to "aa"
        */
        if (s.equals(goal)) {

            java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();
            int qty = -1;
            for(int i=0;i<s.length();i++) {
                Character currentChar = s.charAt(i);
                qty = map.getOrDefault(currentChar, 0);
                qty++;
                map.put(currentChar, qty);
            }
            for(Integer count:map.values()) {
                if (count>=2) {
                    return true;
                }
            }
            return false;

        }

        java.util.List<Integer> diffIndexes = new java.util.ArrayList<Integer>();
        for(int i=0;i<s.length();i++) {
            if (s.charAt(i)!=goal.charAt(i)) {
                diffIndexes.add(i);
            }
        }

        /*
        Only have 2 differences and the letters can be swapped
        */
        return ((diffIndexes.size()==2)
                && ( s.charAt(diffIndexes.get(0)) == goal.charAt(diffIndexes.get(1))  )
                && ( s.charAt(diffIndexes.get(1)) == goal.charAt(diffIndexes.get(0))  ));
    }
}
