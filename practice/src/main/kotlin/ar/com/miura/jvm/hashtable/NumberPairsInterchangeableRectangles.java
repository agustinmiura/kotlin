package ar.com.miura.jvm.hashtable;

public class NumberPairsInterchangeableRectangles {
    public long interchangeableRectangles(int[][] rectangles) {
        long count = 0;
        java.util.Map<Double, Long> map = new java.util.HashMap<>();
        for(int[] pair:rectangles) {
            double ratio = (pair[0]*1.0) / (pair[1]*1.0);
            long qty = map.getOrDefault(ratio, 0L);
            count = count + qty;
            map.put(ratio, map.getOrDefault(ratio, 0L)+1);
        }
        return count;
    }
}



