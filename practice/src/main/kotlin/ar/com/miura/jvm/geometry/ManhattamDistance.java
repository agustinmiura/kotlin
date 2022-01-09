package ar.com.miura.jvm.geometry;

/**
 * https://leetcode.com/contest/biweekly-contest-47/problems/find-nearest-point-that-has-the-same-x-or-y-coordinate/
 */
public class ManhattamDistance {
    public int nearestValidPoint(int x, int y, int[][] points) {

        int smallDistance = Integer.MAX_VALUE;
        int smallX = Integer.MAX_VALUE;
        int smallY = Integer.MAX_VALUE;
        int smallest = Integer.MAX_VALUE;

        boolean found = false;
        int index = -1;
        for(int[] eachPoint:points) {

            index++;

            int xPoint = eachPoint[0];
            int yPoint = eachPoint[1];

            if (x==xPoint || y==yPoint) {



                //The Manhattan distance between two points (x1, y1) and (x2, y2) is abs(x1 - x2) + abs(y1 - y2).
                int currentDistance = Math.abs(x-xPoint) + Math.abs(y-yPoint);

                if ( currentDistance < smallDistance || ( smallDistance == currentDistance && index < smallest ) ) {
                    smallDistance = currentDistance;
                    smallest = index;
                    smallX = xPoint;
                    smallY = yPoint;

                    if (!found) {
                        found = true;
                    }
                }
            }

        }

        if (!found) {
            smallest = -1;
        }

        return smallest;
    }
}

