package ar.com.miura.pramp;

public class SentenceReverse {

    static char[] reverseWords(char[] arr) {
        reverseInPlace(arr, 0, arr.length-1);
        int startIndex = 0;
        int endIndex = 0;
        while(startIndex<arr.length) {
            while (startIndex<arr.length && arr[startIndex]==' ') {
                System.out.println("while ...");
                startIndex++;
            }
            endIndex = startIndex+1;
            while (endIndex<arr.length && arr[endIndex]!=' ') {
                endIndex++;
            }
            reverseInPlace(arr, startIndex, endIndex-1);
            startIndex = endIndex+1;
        }
        return arr;
    }

    private static void reverseInPlace(char[] arr,int start, int end) {
        while(start<=end) {
            char tempStart = arr[start];
            char tempEnd = arr[end];
            arr[start] = tempEnd;
            arr[end] = tempStart;
            start++;
            end--;
        }
    }

}
