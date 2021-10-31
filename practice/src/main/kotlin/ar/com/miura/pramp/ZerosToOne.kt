package ar.com.miura.pramp

class ZerosToOne {
    /**
     *
     * @param arr
     * @return
     */
    static int[] moveZerosToEnd(int[] arr) {
        java.util.Queue<Integer> numbers = new java.util.LinkedList<Integer>();
        int zeroQty = 0;
        for(int i=0;i<arr.length;i++) {
            if (arr[i]==0) {
                zeroQty++;
            } else {
                numbers.offer(arr[i]);
            }
        }

        int index = 0;
        while(!numbers.isEmpty()) {
            arr[index] = numbers.poll();
            index++;
        }

        for(int i=index;i<arr.length;i++) {
            arr[i] = 0;
        }
        return arr;
    }
}