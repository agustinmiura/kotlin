package ar.com.miura.jvm.string;

public class ExcellSheetNumber {
    public int titleToNumber(String columnTitle) {
        String cloned = columnTitle.toLowerCase();

        java.util.Map<Character, Integer> map = new java.util.HashMap<Character, Integer>();

        Integer base = 26;

        int size = columnTitle.length();
        int index = size-1;

        int number = 0;
        int pow = 0;
        while(index>=0) {
            char currentChar = cloned.charAt(index);
            int tempNumber = (int)(currentChar - 'a')+1;
            number = number + (tempNumber * (int)(Math.pow(base*1.0, pow)));
            pow++;
            index--;
        }

        return number;

    }
}
