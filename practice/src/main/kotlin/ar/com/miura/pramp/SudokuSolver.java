package ar.com.miura.pramp;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        int rowQty = board.length;
        int colQty = board[0].length;

        int[][] numberBoard = new int[rowQty][colQty];

        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {
                char aChar = board[i][j];
                if (aChar=='.') {
                    numberBoard[i][j] = 0;
                } else {
                    numberBoard[i][j] = Character.getNumericValue(aChar);
                }
            }
        }
        boolean backTrack = backtrack(numberBoard);
        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {
                if (board[i][j]=='.') {
                    Integer number = numberBoard[i][j];
                    String string = number.toString();
                    board[i][j] = string.charAt(0);
                }
            }
        }
    }

    private boolean backtrack(int[][] numberBoard) {

        int rowQty = numberBoard.length;
        int colQty = numberBoard[0].length;

        for(int i=0;i<rowQty;i++) {
            for(int j=0;j<colQty;j++) {
                if (numberBoard[i][j]==0) {
                    for(int k=1;k<=9;k++) {
                        if (validNumber(numberBoard, i, j, k)) {
                            numberBoard[i][j] = k;
                            if (backtrack(numberBoard)) {
                                return true;
                            } else {
                                numberBoard[i][j] = 0;
                            }
                        }
                    }
                    //return false;
                }
            }
        }

        return true;

    }

    private boolean validNumber(int[][] numberBoard, int row, int col, int number) {
        if (numberInCol(numberBoard, col, number)) {
            return false;
        } else if (numberInRow(numberBoard, row, number)) {
            return false;
        } else if (numberInBox(numberBoard, row, col, number)) {
            return false;
        } else {
            return true;
        }
    }

    private boolean numberInCol(int[][] numberBoard, int col, int number) {
        int rowQty = numberBoard.length;
        int colQty = numberBoard[0].length;
        for(int i=0;i<rowQty;i++) {
            if (numberBoard[i][col]==number) {
                return true;
            }
        }
        return false;
    }

    private boolean numberInBox(int[][] numberBoard, int row, int col, int number) {

        int localRow = row - row%3;
        int localCol = col - col%3;

        for(int i=localRow; i<localRow + 3; i++) {
            for(int j=localCol; j<localCol + 3; j++) {
                if (numberBoard[i][j]==number) {
                    return true;
                }
            }
        }
        return false;
    }



    private boolean numberInRow(int[][] numberBoard, int row, int number) {
        int colQty = numberBoard[0].length;
        for(int j=0;j<colQty;j++) {
            if (numberBoard[row][j]==number) {
                return true;
            }
        }
        return false;
    }
}
