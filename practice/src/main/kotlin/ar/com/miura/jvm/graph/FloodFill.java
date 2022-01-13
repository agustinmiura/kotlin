package ar.com.miura.jvm.graph;

public class FloodFill {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int sourceColor = image[sr][sc];
        int rowQty = image.length;
        int colQty = image[0].length;
        boolean[][] visited = new boolean[rowQty][colQty];
        bfsFill(image, sr, sc, sourceColor, newColor, visited);
        return image;
    }

    private void bfsFill(int[][] image, int sr, int sc, int sourceColor, int newColor, boolean[][] visited) {
        java.util.Queue<int[]> queue = new java.util.LinkedList<int[]>();
        queue.offer(new int[]{sr,sc});
        visited[sr][sc] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();
            for(int k=0;k<size;k++) {
                int[] position = queue.poll();
                int i = position[0];
                int j = position[1];
                image[i][j] = newColor;
                java.util.List<int[]> adjacents = getAdjacents(image, i, j, sourceColor, visited);

                for(int[] anAdjacent:adjacents) {
                    queue.offer(anAdjacent);
                }

            }
        }
    }

    /*

     */
    private java.util.List<int[]> getAdjacents(int[][] image, int sr, int sc, int sourceColor, boolean[][] visited) {

        int rowQty = image.length;
        int colQty = image[0].length;

        java.util.List<int[]> adjacents = new java.util.ArrayList<int[]>();

        int i = sr;
        int j = sc;

        /*
        up
        */
        if (i-1>=0 && !visited[i-1][j] && image[i-1][j]==sourceColor) {

            adjacents.add(new int[]{i-1, j});
            visited[i-1][j] = true;

        }

        /*
        right
        */
        if (j+1<colQty && !visited[i][j+1] && image[i][j+1]==sourceColor) {
            adjacents.add(new int[]{i,j+1});
            visited[i][j+1] = true;
        }


        /*
        down
        */
        if (i+1<rowQty && !visited[i+1][j] && image[i+1][j]==sourceColor) {
            adjacents.add(new int[]{i+1,j});
            visited[i+1][j] = true;
        }

        /*
        left
        */
        if (j-1>=0 && !visited[i][j-1] && image[i][j-1]==sourceColor) {
            adjacents.add(new int[]{i,j-1});
            visited[i][j-1] = true;
        }


        return adjacents;

    }
}
