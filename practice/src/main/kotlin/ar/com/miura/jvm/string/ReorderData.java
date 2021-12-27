package ar.com.miura.jvm.string;

public class ReorderData {
    public String[] reorderLogFiles(String[] logs) {
        java.util.Comparator<String> customComparator = (String s0, String s1) -> {

            String[] firstSplitted = s0.split(" ", 2);
            String[] secondSplitted = s1.split(" ", 2);

            int s0Size = firstSplitted.length;
            int s1Size = secondSplitted.length;

            String key0 = firstSplitted[0];
            String key1 = secondSplitted[0];

            Boolean isFirstNumber = Character.isDigit(firstSplitted[1].charAt(0));
            Boolean isSecondNumber = Character.isDigit(secondSplitted[1].charAt(0));

            if (isFirstNumber && isSecondNumber) {
                return 0;

            } else if (isFirstNumber && !isSecondNumber) {
                return 1;

            } else if (!isFirstNumber && isSecondNumber) {
                return -1;

            } else {

                int compareStatus = firstSplitted[1].compareTo(secondSplitted[1]);
                if (compareStatus!=0) {
                    return compareStatus;
                } else {
                    return key0.compareTo(key1);
                }

            }
        };
        java.util.Arrays.sort(logs, customComparator);
        return logs;
    }
}
