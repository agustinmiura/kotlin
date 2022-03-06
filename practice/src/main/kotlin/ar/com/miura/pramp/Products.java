package ar.com.miura.pramp;

public class Products {
    static int[] arrayOfArrayProducts(int[] arr) {
        int size = arr.length;
        if (size==0 || size==1) {
            return new int[0];
        }
        int[] left = new int[size];
        int[] right = new int[size];
        left[0] = 1;
        right[size-1] = 1;
        for(int i=1;i<size;i++) {
            left[i] = left[i-1] * arr[i-1];
        }
        int index = size-2;
        while(index>=0) {
            right[index] = (right[index+1]*arr[index+1]);
            index--;
        }
        int[] numbers = new int[size];

        for(int i=0;i<size;i++) {
            numbers[i] = left[i] * right[i];
        }
        return numbers;
    }
}
