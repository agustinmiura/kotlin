package java.ar.com.miura.matrix;

public class LeftMostColumnWithAtLeastOne {

    private static final int MAX_COL = 1001;

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        java.util.List<Integer> dimensions = binaryMatrix.dimensions();
        Integer rowQty = dimensions.get(0);

        int col = 1001;
        for(int i=0;i<rowQty;i++) {
            int currentCol = getCol(binaryMatrix, i);
            if (currentCol<col) {
                col = currentCol;
            }
        }
        if (col==MAX_COL) {
            return -1;
        } else {
            return col;
        }

    }

    private int getCol(BinaryMatrix binaryMatrix, int rowIndex) {

        java.util.List<Integer> dimensions = binaryMatrix.dimensions();
        Integer colQty = dimensions.get(1);
        int left = 0;
        int right = colQty-1;
        int middle = -1;
        while(left<right) {

            middle = left + (right-left)/2;
            int value = binaryMatrix.get(rowIndex, middle);
            if (value==0) {
                left = middle+1;

            } else {
                right = middle;

            }

        }
        if (binaryMatrix.get(rowIndex, right)==0) {
            return MAX_COL;
        } else {
            return right;
        }
    }
}
