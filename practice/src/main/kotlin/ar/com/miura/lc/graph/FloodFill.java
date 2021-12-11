package ar.com.miura.lc.graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        if (image[sr][sc]==newColor) {
            return image;
        }

        dfs(image,sr,sc,newColor);
        return image;
    }

    private void dfs(int[][] image, int row, int col, int newColor) {
        java.util.Stack<int[]> stack = new java.util.Stack<int[]>();

        stack.push(new int[]{row, col});
        int originalColor = image[row][col];
        image[row][col] = newColor;


        while(!stack.isEmpty()) {

            int[] position = stack.pop();

            int currentRow = position[0];
            int currentCol = position[1];

            java.util.List<int[]> adjacents = getAdjacents(image, currentRow, currentCol, originalColor);

            for(int[] eachAdjacent:adjacents) {
                stack.push(eachAdjacent);
                image[eachAdjacent[0]][eachAdjacent[1]] = newColor;
            }

        }

    }

    private java.util.List<int[]> getAdjacents(int[][] image, int currentRow, int currentCol, int originalColor) {

        int rowQty = image.length;
        int colQty = image[0].length;

        java.util.List<int[]> adjacents = new java.util.ArrayList<int[]>();

        int i = currentRow;
        int j = currentCol;

        /**
         Move up
         */
        if (i>=1 && image[i-1][j]==originalColor) {
            adjacents.add(new int[]{i-1,j});
        }

        /**
         Move down
         */
        if ( i<=rowQty-2 && image[i+1][j]==originalColor ) {
            adjacents.add(new int[]{i+1,j});
        }

        /*
        Move left
        end <= start
        */
        if ( j>=1 && image[i][j-1]==originalColor ) {
            adjacents.add(new int[]{i,j-1});
        }

        /*
        Move right
        start => end
                 colQty-2
        */
        if ( j<=colQty-2 && image[i][j+1]==originalColor ) {
            adjacents.add(new int[]{i,j+1});
        }

        return adjacents;

    }
}
