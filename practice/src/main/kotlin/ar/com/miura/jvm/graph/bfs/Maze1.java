package ar.com.miura.jvm.graph.bfs;

public class Maze1 {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

        int rowQty = maze.length;
        int colQty = maze[0].length;

        java.util.Queue<int[]> queue = new java.util.LinkedList();

        queue.offer(start);

        boolean[][] visited = new boolean[rowQty][colQty];
        visited[start[0]][start[1]] = true;

        /*
        up,right,down,left
        */
        int[][] movements = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!queue.isEmpty()) {

            int[] position = queue.poll();

            if (position[0]==destination[0] && position[1]==destination[1]) {
                return true;
            }

            for(int[] movement:movements) {

                int i = position[0] + movement[0];
                int j = position[1] + movement[1];

                while(i>=0 && j>=0 && i<rowQty && j<colQty && maze[i][j]==0) {
                    i += movement[0];
                    j += movement[1];
                }

                if (!visited[i-movement[0]][j-movement[1]]) {
                    queue.offer(new int[]{i-movement[0], j-movement[1]});
                    visited[i-movement[0]][j-movement[1]] = true;
                }
            }
        }

        return false;


    }
}
