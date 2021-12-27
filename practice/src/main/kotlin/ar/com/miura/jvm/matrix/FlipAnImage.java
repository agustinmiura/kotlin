package ar.com.miura.jvm.matrix;

public class FlipAnImage {
    public int[][] flipAndInvertImage(int[][] image) {

        int rowQty = image.length;
        for(int i=0;i<rowQty;i++) {
            flipRow(image,i);
        }

        for(int i=0;i<rowQty;i++) {
            invertRow(image, i);
        }

        return image;
    }

    private void flipRow(int[][] image, int rowIndex) {
        int[] row = image[rowIndex];

        int i =0;
        int j = row.length-1;
        while(i<j) {
            int tempI = image[rowIndex][i];
            image[rowIndex][i] = image[rowIndex][j];
            image[rowIndex][j] = tempI;
            i++;
            j--;
        }
    }

    private void invertRow(int[][] image, int rowIndex) {
        int[] row = image[rowIndex];
        for(int j=0;j<row.length;j++) {
            image[rowIndex][j] = reverse(image[rowIndex][j]);
        }
    }

    private int reverse(int number) {
        if (number==1) {
            return 0;
        } else {
            return 1;
        }
    }
}
