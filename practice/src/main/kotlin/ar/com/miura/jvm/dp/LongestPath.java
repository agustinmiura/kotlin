package ar.com.miura.jvm.dp;

public class LongestPath {

    private int[][] DIRECTIONS = { {1,0},{0,1},{-1,0},{0,-1} };

    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        } else {
            return solveLongest(matrix);
        }
    }

    private int solveLongest(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int longestPath = 0;
        int[][] cache = new int[n][m];

        for(int i=0 ;i<n ;i++) {
            for(int j=0; j<m; j++) {
                int longest = recursiveLongest(matrix, i, j, cache);
                longestPath = Math.max(longest, longestPath);
            }
        }
        return longestPath;
    }

    private int recursiveLongest(int[][] matrix, int i, int j, int[][] cache) {

        int n = matrix.length;
        int m = matrix[0].length;

        /**
         * Solved it
         **/
        int max = 0;
        if (cache[i][j]>0) {
            return cache[i][j];

        } else {
            max = 0;
            for(int[] directions : DIRECTIONS) {
                int x = directions[0] + i;
                int y = directions[1] + j;
                if ( x > -1 && y > -1 && x < n && y <m && matrix[x][y]>matrix[i][j] ) {
                    int longest =  recursiveLongest(matrix, x, y, cache);
                    max = Math.max(max, longest);
                }
            }
            cache[i][j] = max + 1;
            return cache[i][j];

        }

    }
}
