package ar.com.miura.lc.graph;

public class MaxAreaIsland {

    public int maxAreaOfIsland(int[][] grid) {

        int rowQty = grid.length;
        int colQty = grid[0].length;

        int maxArea = 0;

        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {

                if (grid[i][j]==1) {
                    int currentArea = dfs(grid, i, j);

                    /*
                    TODO : Remove
                    */
                    int stop = -1;

                    if (currentArea>maxArea) {
                        maxArea = currentArea;
                    }
                }
            }
        }

        return maxArea;
    }

    private int dfs(int[][] grid, int currentRow, int currentCol) {

        java.util.Stack<int[]> stack = new java.util.Stack<int[]>();

        stack.push(new int[]{currentRow, currentCol});
        grid[currentRow][currentCol] = 0;
        int area = 0;

        while(!stack.isEmpty()) {

            int[] position = stack.pop();
            area++;

            java.util.List<int[]> adjacents = getAdjacents(grid, position[0], position[1]);

            int stop = 1;

            for(int[] adjacent:adjacents) {

                int tempRow = adjacent[0];
                int tempCol = adjacent[1];

                grid[tempRow][tempCol] = 0;
                stack.push(adjacent);

            }

        }

        return area;

    }

    private java.util.List<int[]> getAdjacents(int[][] grid, int currentRow, int currentCol) {

        java.util.List<int[]> adjacents = new java.util.ArrayList<int[]>();

        int rowQty = grid.length;
        int colQty = grid[0].length;

        int i = currentRow;
        int j = currentCol;

        /*
        up
        */
        if (i>=1 && grid[i-1][j]==1) {
            adjacents.add(new int[]{i-1, j});
        }


        /*
        down

        start
        end

        */
        if ( i<=rowQty-2 && grid[i+1][j]==1 ) {
            adjacents.add(new int[]{i+1, j});
        }

        /*
        left
        end start
        */
        if ( j>=1 && grid[i][j-1]==1 ) {
            adjacents.add(new int[]{i,j-1});
        }

        /*
        right
        start end
        */
        if ( j+2<=colQty && grid[i][j+1]==1 ) {
            adjacents.add(new int[]{i,j+1});
        }


        return adjacents;

    }
}
