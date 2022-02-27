package ar.com.miura.pramp;

public class BusiestTimeMall {
    
    private static final int EXIT = 0;
    private static final int ENTER = 1;

    static int findBusiestPeriod(int[][] data) {
        java.util.Map<Integer, Integer> map = new java.util.HashMap<>();

        int maxQty = Integer.MIN_VALUE;
        int maxTimestamp = -1;

        int actualQty = 0;

        for(int[] time:data) {
            int timestamp = time[0];
            int qty = time[1];
            int operation = time[2];

            if (operation==EXIT) {
                actualQty -= qty;
            } else {
                actualQty += qty;
            }
            map.put(timestamp, actualQty);
        }

        for(int[] time:data) {
            int timestamp = time[0];
            int qty = map.get(timestamp);
            if (qty>maxQty) {
                maxQty = qty;
                maxTimestamp = timestamp;
            }
        }
        return maxTimestamp;
    }
}
