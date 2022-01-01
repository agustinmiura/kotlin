package ar.com.miura.jvm.geometry;

public class KClosestPoints {

    public int[][] kClosest(int[][] points, int k) {

        java.util.Comparator<int[]> comparator = (array1, array2) -> {

            double firstDistance = Math.sqrt( Math.pow(array1[0]*1.0, 2.0) + Math.pow(array1[1]*1.0, 2.0) );
            double secondDistance = Math.sqrt( Math.pow(array2[0]*1.0, 2.0) + Math.pow(array2[1]*1.0, 2.0) );

            if (firstDistance<secondDistance) {
                return -1;
            } else if (firstDistance==secondDistance) {
                return 0;
            } else {
                return 1;
            }

        };
        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<int[]>(comparator);

        for(int[] point:points) {
            pq.offer(point);
        }

        int[][] closest = new int[k][];
        for(int i=0;i<k;i++) {
            closest[i] = pq.poll();
        }

        return closest;

    }
}
