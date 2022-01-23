package ar.com.miura.jvm.graph.bfs;

public class Maze2 {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {

        int rowQty = maze.length;
        int colQty = maze[1].length;

        int size = maze.length;
        int[][] distances = new int[size][size];
        for(int[] row:distances) {
            java.util.Arrays.fill(row, Integer.MAX_VALUE);
        }

        distances[start[0]][start[1]] = 0;

        /*
        up
        left
        down
        right
        */
        int[][] movements = {{1,0}, {0,-1}, {-1, 0}, {0,1}};

        java.util.Queue<int[]> queue = new java.util.LinkedList<int[]>();
        queue.add(start);

        while(!queue.isEmpty()) {

            int[] position = queue.poll();

            for(int[] movement:movements) {

                int i = position[0] + movement[0];
                int j = position[1] + movement[1];

                int min = 0;

                while(i>=0 && j>=0 && i<rowQty && j<colQty && maze[i][j]==0) {
                    i += movement[0];
                    j += movement[1];
                    min++;
                }

                /**
                 * From "position + min" I have reached [i][j] check the distances
                 */
                int newDistance = distances[position[0]][position[1]] + min;
                int oldDistance = distances[i-movement[0]][j-movement[1]];

                if (newDistance<oldDistance) {
                    /**
                     * Fix the new distances that are out of range after the while
                     *
                     */
                    distances[i-movement[0]][j-movement[1]] = newDistance;
                    queue.add(new int[]{i-movement[0], j-movement[1]});
                }

            }
        }

        if (distances[destination[0]][destination[1]]==Integer.MAX_VALUE) {
            return -1;
        } else {
            return distances[destination[0]][destination[1]];
        }

    }
}
