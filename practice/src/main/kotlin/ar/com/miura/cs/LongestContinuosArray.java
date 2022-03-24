package ar.com.miura.cs;

public class LongestContinuosArray {
    int[] solution(int[] a, int[] b, int[] c) {
        java.util.Set<Integer> bSet = new java.util.HashSet();
        for(Integer bNumber:b) {
            bSet.add(bNumber);
        }
        java.util.Set<Integer> cSet = new java.util.HashSet();
        for(Integer cNumber:c) {
            cSet.add(cNumber);
        }
        int start = -1;
        int index = 0;
        int sizeA = a.length;

        int maxSize = Integer.MIN_VALUE;
        int[] range = null;

        while(index<sizeA) {
            int number = a[index];
            if (valid(number, bSet, cSet)) {

                start = index;
                int j = start;
                while(j<sizeA && valid(a[j], bSet, cSet)) {
                    j++;
                }

                int size = (j-index+1);
                if (size>maxSize) {
                    range = new int[]{index,j};
                }
                index = j+1;

            } else {
                index++;
            }
        }
        if  (range==null) {
            return new int[0];
        } else {
            start = range[0];
            int end = range[1];
            if (end>=sizeA) {
                end = sizeA-1;
            }
            int[] filtered = java.util.Arrays.copyOfRange(a, start, end+1);
            return filtered;
        }
    }

    private boolean valid(Integer number, java.util.Set<Integer> bSet, java.util.Set<Integer> cSet) {
        return bSet.contains(number) && !cSet.contains(number);
    }

}
