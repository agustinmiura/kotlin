package ar.com.miura.jvm.string;

/**
 * https://leetcode.com/contest/weekly-contest-234/problems/number-of-different-integers-in-a-string/
 */
public class DifferentIntegers {

    public int numDifferentIntegers(String word) {

        StringBuilder sBuilder = new StringBuilder();
        int size = word.length();

        //create new String
        for(int i=0;i<size;i++) {
            char currentChar = word.charAt(i);
            if (Character.isDigit(currentChar)) {
                sBuilder.append(currentChar);

            } else {
                sBuilder.append(' ');

            }

        }
        String formatted = sBuilder.toString();
        char[] charArray = formatted.toCharArray();
        size = charArray.length;

        sBuilder = new StringBuilder();
        java.util.Set<String> intSet = new java.util.HashSet<>();

        boolean lastCharIsDigit = Character.isDigit(charArray[0]);
        int i = 0;
        i++;

        if (lastCharIsDigit) {
            sBuilder.append(charArray[0]);
        }

        if (size==1 && lastCharIsDigit) {
            return 1;
        }

        while(i<size) {
            //a123bc34d8ef34
            //leet1234code234
            //a1b01c001

            char charCurrentChar = charArray[i];
            boolean isCurrentDigit = Character.isDigit(charCurrentChar);

            //a1
            if (!lastCharIsDigit && isCurrentDigit) {
                sBuilder = new StringBuilder();
                sBuilder.append(charCurrentChar);

                //11
            } else if (lastCharIsDigit && isCurrentDigit) {
                sBuilder.append(charCurrentChar);

                //1a
            } else if (lastCharIsDigit && !isCurrentDigit) {
                intSet.add((sBuilder.toString()));

                //aa
            }

            if ( i==size-1 && isCurrentDigit ) {
                intSet.add((sBuilder.toString()));
            }

            lastCharIsDigit = Character.isDigit(charArray[i]);
            i++;

        }

        //
        java.util.Set<String> newSet = new java.util.HashSet();

        for(String eachKey:intSet) {
            String newNumber = eachKey.replaceFirst ("^0*", "");
            newSet.add(newNumber);

        }


        return (newSet.size());
    }
}
