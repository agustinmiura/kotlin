package ar.com.miura.jvm.matrix;

public class SortDiagonal {
    public int[][] diagonalSort(int[][] mat) {

        int rows = mat.length;
        int cols = mat[0].length;

        for(int col=0;col<cols;col++) {
            sortDiagonal(mat, 0, col);
        }

        for(int row=1;row<rows;row++) {
            sortDiagonal(mat, row, 0);
        }

        return mat;
    }

    private void sortDiagonal(int[][] mat, int row, int col) {

        int rowQty = mat.length;
        int colQty = mat[0].length;

        int size = Math.min(rowQty-row, colQty-col);

        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>();

        for(int i=0;i<size;i++) {
            pq.add(mat[row+i][col+i]);
        }

        for(int i=0;i<size;i++) {
            mat[row+i][col+i] = pq.poll();
        }

    }
}
