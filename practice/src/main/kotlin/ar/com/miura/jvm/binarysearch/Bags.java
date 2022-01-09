package ar.com.miura.jvm.binarysearch;

public class Bags {

    public int minimumSize(int[] intArray, int maxSteps) {
        int left = 1;
        int right = 1_000_000_000;
        /**
         * Binary search the possible elements that can be
         * the min element in the array
         */
        while(left<right) {
            int middle = (left + right) / 2;
            int count = 0;
            for(int eachElement:intArray) {
                int operationsSplit = (eachElement-1)/middle;
                count = count + operationsSplit;
            }
            /**
             * If count is 0 means that the element is too big and
             * I don't need extra steps so I need to keep searching
             */
            if (count>maxSteps) {
                left = middle +1;
            } else {
                right = middle;
            }
        }
        return left;
    }
}
