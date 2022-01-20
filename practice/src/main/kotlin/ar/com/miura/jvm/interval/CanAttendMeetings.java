package ar.com.miura.jvm.interval;

public class CanAttendMeetings {
    public boolean canAttendMeetings(int[][] intervals) {

        java.util.Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        java.util.LinkedList<int[]> merged = new java.util.LinkedList<>();

        for(int[] interval:intervals) {

            boolean noIntersection = merged.size()>=1 && (merged.getLast()[1]<interval[0]);

            boolean borderTouch = false;
            if (!merged.isEmpty()) {
                int start = Math.max(merged.getLast()[0], interval[0]);
                int last = Math.min(merged.getLast()[1], interval[1]);
                borderTouch = last - start == 0;
            }
            if (merged.isEmpty() || noIntersection || borderTouch) {
                merged.add(interval);
            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
                return false;
            }
        }
        return true;
    }
}
