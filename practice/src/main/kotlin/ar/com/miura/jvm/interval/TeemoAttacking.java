package ar.com.miura.jvm.interval;

public class TeemoAttacking {
    public int findPoisonedDuration(int[] timeSeries, int duration) {

        java.util.LinkedList<int[]> merged = new java.util.LinkedList<>();

        for(int time:timeSeries) {

            int timeEnd = time + duration - 1;

            boolean notIntersect = false;
            if (!merged.isEmpty()) {
                int start = Math.max(merged.getLast()[0], time);
                int end = Math.min(merged.getLast()[1], timeEnd);
                int size = end - start;
                notIntersect = size<0;
            }

            if (merged.isEmpty() || notIntersect) {
                merged.add(new int[]{time, timeEnd});

            } else {
                merged.getLast()[1] = Math.max(merged.getLast()[1], timeEnd);

            }
        }

        int total = 0;
        for(int[] time:merged) {
            total += (time[1]-time[0]+1);
        }

        return total;

    }
}
