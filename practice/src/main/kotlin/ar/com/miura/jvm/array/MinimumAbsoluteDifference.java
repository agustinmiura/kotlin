package ar.com.miura.jvm.array;

public class MinimumAbsoluteDifference {
    public java.util.List<java.util.List<Integer>> minimumAbsDifference(int[] arr) {

        int[] cloned = arr.clone();
        java.util.Arrays.sort(cloned);

        int size = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<size;i++) {
            minDiff = Math.min(minDiff, Math.abs(cloned[i]-cloned[i-1]));
        }

        java.util.List<java.util.List<Integer>> pairs = new java.util.ArrayList();
        for(int i=1;i<size;i++) {
            if (Math.abs(cloned[i]-cloned[i-1])==minDiff) {
                java.util.List<Integer> list = new java.util.ArrayList();
                list.add(cloned[i-1]);
                list.add(cloned[i]);
                pairs.add(list);
            }
        }
        return pairs;

    }
}
