package ar.com.miura.jvm.greedy;

public class MaxAverage {
    public double maxAverageRatio(int[][] classes, int extraStudents) {

        java.util.PriorityQueue<Integer[]> queue = new java.util.PriorityQueue<>(new CourseInfo());

        for(int[] eachClass:classes) {
            queue.offer(new Integer[]{eachClass[0], eachClass[1]});
        }

        int extraQty = extraStudents;
        while(extraQty>0) {
            Integer[] c = queue.poll();
            c[0]++;
            c[1]++;
            queue.offer(c);
            extraQty--;
        }

        double result = 0.0;
        while(!queue.isEmpty()) {
            Integer[] c = queue.poll();
            result += (double)c[0]/(double)(c[1]);
        }
        return result/classes.length;

    }
}