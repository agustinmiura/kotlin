package ar.com.miura.pramp;

/***
 * Find duplicates
 */
public class FindDuplicates {
    static int[] findDuplicates(int[] arr1, int[] arr2) {

        int[] topArray = arr1;
        int[] bottomArray = arr2;

        if (arr2[0] < arr1[0]) {
            topArray = arr2;
            bottomArray = arr1;
        }
        java.util.SortedSet<Integer> numbers = new java.util.TreeSet<Integer>();

        int i = 0;
        int j = 0;
        while (i < topArray.length && j < bottomArray.length) {
            int topElement = topArray[i];
            int bottomElement = bottomArray[j];
            if (topElement == bottomElement) {
                numbers.add(topElement);
                i++;
                j++;
            } else if (bottomElement < topElement) {
                j++;
            } else {
                i++;
            }
        }

        int[] duplicates = new int[numbers.size()];
        int k = 0;
        for (int eachNumber : numbers) {
            duplicates[k] = eachNumber;
            k++;
        }
        return duplicates;
    }
}
