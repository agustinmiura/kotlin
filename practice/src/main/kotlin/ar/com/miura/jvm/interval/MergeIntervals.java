package ar.com.miura.jvm.interval;

public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.LinkedList<int[]> merged = new java.util.LinkedList<int[]>();
        for(int[] interval: intervals) {
            if (merged.isEmpty() || merged.getLast()[1]<interval[0]) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }
}
