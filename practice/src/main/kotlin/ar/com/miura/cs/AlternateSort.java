package ar.com.miura.cs;

public class AlternateSort {
    boolean solution(int[] a) {
        int size = a.length;
        int[] bArray = new int[size];
        int left = 0;
        int right = size - 1;

        int index = -1;
        while(left<=right) {
            if ((index+1)<size) {
                index++;
                bArray[index] = a[left];
            }
            if ((index+1)<size) {
                index++;
                bArray[index] = a[right];
            }
            left++;
            right--;
        }
        for(int i=1;i<size;i++) {
            if (bArray[i-1]>=bArray[i]) {
                return false;
            }
        }
        return true;
    }
}
