package ar.com.miura.jvm.graph.bfs;

public class ShortesPathBinaryMatrix {
    private static final int VALID = 0;

    public int shortestPathBinaryMatrix(int[][] grid) {

        int rowQty = grid.length;
        int colQty = grid.length;

        if (grid[0][0]!=VALID) {
            return -1;
        }

        boolean[][] visited = new boolean[rowQty][colQty];
        int size = bfs(grid, 0, 0, visited, rowQty-1, rowQty-1);
        return size;

    }

    private int bfs(
            int[][] grid,
            int startRow,
            int startCol,
            boolean[][] visited,
            int endRow,
            int endCol) {

        int rowQty = visited.length;
        int colQty = visited[0].length;

        Queue<int[]> queue = new LinkedList<int[]>();
        queue.offer(new int[]{0,0});

        visited[0][0] = true;

        int count = 0;

        int[][] movements = {
                {0,1},//right
                {1,1},//right diag down
                {1,0},//down
                {1,-1},//left diag
                {0,-1},//left
                {-1,-1},//upper left diag
                {-1,0},//up
                {-1,1}//right diag upper
        };

        while(!queue.isEmpty()) {

            count++;
            int size = queue.size();
            for(int k=0;k<size;k++) {

                int[] current = queue.poll();
                int i = current[0];
                int j = current[1];

                if (i==endRow&&j==endCol) {
                    return count;
                }

                for(int[] movement:movements) {
                    int newI = i + movement[0];
                    int newJ = j + movement[1];

                    if (newI>=0 && newI<rowQty && newJ>=0 && newJ<colQty && grid[newI][newJ]==VALID && !visited[newI][newJ]) {
                        queue.offer(new int[]{newI, newJ});
                        visited[newI][newJ] = true;
                    }
                }
            }
        }

        return -1;

    }
}
