package ar.com.miura.jvm.backtracing;

public class WordSearch {

    public boolean exist(char[][] board, String word) {

        int rowQty = board.length;
        int colQty = board[0].length;

        boolean[][] visited = new boolean[rowQty][colQty];

        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {
                if (word.charAt(0)==board[i][j] && search(board, i, j, 0, visited, word)) {
                    return true;
                }
            }
        }

        return false;
    }

    /**

     **/
    private boolean search(char[][] board, int row, int col, int index, boolean[][] visited, String word) {

        int rowQty = board.length;
        int colQty = board[0].length;

        /*
        End of backtracking
        */
        if (index==word.length()) {
            return true;
        }


        /*
        Check out of board
        */
        if (row<0 || row>=rowQty || col < 0 || col >= colQty) {
            return false;

            /**
             Not a valid next word
             **/
        } else if (board[row][col]!=word.charAt(index)) {
            return false;

            /**
             Avoid visited col and rows
             **/
        } else if (visited[row][col]) {
            return false;

        }

        /*
        Visit the position
        check
            * up
            * right
            * down
            * left
        */
        visited[row][col] = true;
        if ( (search(board, row-1, col, index+1, visited, word)) ||
                (search(board, row, col+1, index+1, visited, word)) ||
                (search(board, row+1, col, index+1, visited, word)) ||
                (search(board, row, col-1, index+1, visited, word)) ) {

            return true;

        }

        visited[row][col] = false;

        return false;

    }
}
