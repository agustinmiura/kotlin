package java.ar.com.miura.geometry;

public class MinTimeVisitingPoints {
    public int minTimeToVisitAllPoints(int[][] points) {

        int distance = 0;
        int size = points.length;
        for(int i=1;i<size;i++) {
            int[] prev = points[i-1];
            int[] current = points[i];

            distance += Math.max(
                    Math.abs(current[0]-prev[0]),
                    Math.abs(current[1]-prev[1])
            );
        }
        return distance;

    }
}
