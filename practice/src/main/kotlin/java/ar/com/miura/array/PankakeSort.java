package java.ar.com.miura.array;

public class PankakeSort {
    public java.util.List<Integer> pancakeSort(int[] arr) {

        int[] sorted = arr.clone();
        java.util.Arrays.sort(sorted);

        int flippedNumbers = 0;
        int size = arr.length;

        java.util.List<Integer> movements = new java.util.ArrayList<Integer>();

        int index = size-1;

        int secondFlip = size;

        while(flippedNumbers<size) {

            int element = sorted[index];

            int indexFound = java.util.stream.IntStream.range(0, size)
                    .filter(i -> arr[i] == element)
                    .findFirst()
                    .orElse(-1);

            if (indexFound!=index) {
                flip(arr, indexFound+1);
                movements.add(indexFound+1);
                flip(arr, secondFlip);
                movements.add(secondFlip);
            }

            secondFlip--;
            index--;
            flippedNumbers++;
        }

        return movements;

    }

    private void flip(int[] arr, int k) {

        int left = 0;
        int right = k-1;
        while(left<right) {

            int tempLeft = arr[left];

            arr[left] = arr[right];
            arr[right] = tempLeft;

            left++;
            right--;

        }

    }
}
