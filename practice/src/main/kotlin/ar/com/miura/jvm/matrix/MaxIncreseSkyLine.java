package ar.com.miura.jvm.matrix;

/**
 * There is a city composed of n x n blocks, where each block contains a single building shaped like a vertical square prism. You are given a 0-indexed n x n integer matrix grid where grid[r][c] represents the height of the building located in the block at row r and column c.
 * A city's skyline is the the outer contour formed by all the building when viewing the side of the city from a distance. The skyline from each cardinal direction north, east, south, and west may be different.
 * We are allowed to increase the height of any number of buildings by any amount (the amount can be different per building). The height of a 0-height building can also be increased. However, increasing the height of a building should not affect the city's skyline from any cardinal direction.
 * Return the maximum total sum that the height of the buildings can be increased by without changing the city's skyline from any cardinal direction.
 * 807. Max Increase to Keep City Skyline
 */
public class MaxIncreseSkyLine {
    public int maxIncreaseKeepingSkyline(int[][] grid) {

        int rowQty = grid.length;
        int colQty = grid[0].length;

        int[] rowsMax = new int[rowQty];
        int[] colsMax = new int[colQty];

        java.util.Arrays.fill(rowsMax, Integer.MIN_VALUE);
        java.util.Arrays.fill(colsMax, Integer.MIN_VALUE);

        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {
                rowsMax[i] = Math.max(rowsMax[i], grid[i][j]);
                colsMax[j] = Math.max(colsMax[j], grid[i][j]);
            }
        }

        int count = 0;
        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {
                int toSet = Math.min(rowsMax[i], colsMax[j]);
                count += (toSet - grid[i][j]);
            }
        }
        return count;

    }
}
