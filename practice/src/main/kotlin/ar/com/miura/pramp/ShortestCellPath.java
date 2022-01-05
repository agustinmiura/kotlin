package ar.com.miura.pramp;

public class ShortestCellPath {
    static int shortestCellPath(int[][] grid, int sr, int sc, int tr, int tc) {
        int rowsQty = grid.length;
        int colQty = grid[0].length;

        boolean[][] visited = new boolean[rowsQty][colQty];
        java.util.Queue<int[]> queue = new java.util.LinkedList<>();
        queue.offer(new int[]{sr, sc});
        visited[sr][sc] = true;

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int[] next : queue) {
                if (next[0] == tr && next[1] == tc) {
                    return steps++;
                }
            }
            for (int k = 0; k < size; k++) {
                int[] currentPosition = queue.poll();
                int i = currentPosition[0];
                int j = currentPosition[1];
                steps++;
                if (i == tr && j == tc) {
                    return (steps - 1);
                }
                java.util.List<int[]> adjacents = getAdjacents(i, j, grid, visited);
                for (int[] adjacent : adjacents) {
                    queue.offer(adjacent);
                }
            }
        }
        return -1;
    }

    private static java.util.List<int[]> getAdjacents(int row, int col, int[][] grid, boolean[][] visited) {
        int rowQty = grid.length;
        int colQty = grid[0].length;
        java.util.List<int[]> adjacents = new java.util.ArrayList<>();
        int i = row;
        int j = col;
        if (i - 1 >= 0 && grid[i - 1][j] == 1 && !visited[i - 1][j]) {
            adjacents.add(new int[]{i - 1, j});
            visited[i - 1][j] = true;
        }
        if (j + 1 < colQty && grid[i][j + 1] == 1 && !visited[i][j + 1]) {
            adjacents.add(new int[]{i, j + 1});
            visited[i][j + 1] = true;
        }
        if (i + 1 < rowQty && grid[i + 1][j] == 1 && !visited[i + 1][j]) {
            adjacents.add(new int[]{i + 1, j});
            visited[i + 1][j] = true;
        }
        if (j - 1 >= 0 && grid[i][j - 1] == 1 && !visited[i][j - 1]) {
            adjacents.add(new int[]{i, j - 1});
            visited[i][j - 1] = true;

        }
        return adjacents;
    }
}
