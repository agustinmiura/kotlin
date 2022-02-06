package ar.com.miura.jvm.graph.bfs;

public class PathWithMaxMinValue {
    public int maximumMinimumPath(int[][] grid) {

        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        int[][] directions ={
                {0,1},//right
                {-1,0},//down
                {0,-1},//left
                {1,0}//up
        };

        int rowQty = grid.length;
        int colQty = grid[1].length;
        boolean[][] visited = new boolean[rowQty][colQty];

        int min = grid[0][0];
        visited[0][0] = true;

        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<int[]>(
                (first, second) -> {
                    return ((second[2]-first[2]));
                }
        );
        pq.offer(new int[]{0, 0, grid[0][0]});

        while(!pq.isEmpty()) {

            int[] node = pq.poll();

            int i = node[0];
            int j = node[1];

            min = Math.min(node[2], min);
            if (i==(rowQty-1) && j==(colQty-1)) {
                return min;
            }

            /*
            get adjacents
            */
            for(int[] movement:directions) {
                int tempI = i+movement[0];
                int tempJ = j+movement[1];
                if (tempI>=0 && tempJ>=0 && tempI<rowQty && tempJ<colQty && !visited[tempI][tempJ]) {
                    pq.offer(new int[]{tempI, tempJ, grid[tempI][tempJ]});
                    visited[tempI][tempJ] = true;
                }
            }
        }
        return -1;

    }
}
