package ar.com.miura.jvm.backtracing;

/**
 * https://leetcode.com/problems/unique-paths-iii/
 * 980. Unique Paths III
 * You are given an m x n integer array grid where grid[i][j] could be:
 * 1 representing the starting square. There is exactly one starting square.
 * 2 representing the ending square. There is exactly one ending square.
 * 0 representing empty squares we can walk over.
 * -1 representing obstacles that we cannot walk over.
 * Return the number of 4-directional walks from the starting square to the ending square, that walk over every non-obstacle square exactly once.
 */
public class UniquePath3 {

    private static final int STARTING = 1;
    private static final int ENDING = 2;
    private static final int VALID = 0;
    private static final int INVALID = -1;

    public int uniquePathsIII(int[][] grid) {

        int rowQty = grid.length;
        int colQty = grid[0].length;

        int validCells = 0;

        int startX = 0;
        int startY = 0;

        int endX = 0;
        int endY = 0;

        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {

                if (grid[i][j]>=0) {
                    validCells++;
                }
                if (grid[i][j]==STARTING) {
                    startX = i;
                    startY = j;
                }
            }
        }

        int[] paths = {0};

        dfs(grid, startX, startY, paths, validCells);

        return paths[0];
    }

    /*
    Dfs backtrack
    */
    private void dfs(int[][] grid, int currentI, int currentJ, int[] paths, int remainingSteps) {

        int rowQty = grid.length;
        int colQty = grid[0].length;

        if (grid[currentI][currentJ]==ENDING && remainingSteps==1) {
            paths[0]++;
            return;
        }

        int cellValue = grid[currentI][currentJ];
        grid[currentI][currentJ] = -4;
        remainingSteps--;

        int[][] movements = {
                {0,1},//right
                {0,-1},//left
                {-1,0},//top
                {1,0},//down
        };

        for(int[] movement:movements) {
            int tempI = currentI + movement[0];
            int tempJ = currentJ + movement[1];

            if (tempI>=0 &&
                    tempJ>=0 &&
                    tempI<rowQty &&
                    tempJ<colQty &&
                    (grid[tempI][tempJ]>=0) ) {
                dfs(grid, tempI, tempJ, paths, remainingSteps);
            }
        }
        grid[currentI][currentJ] = cellValue;

    }
}
