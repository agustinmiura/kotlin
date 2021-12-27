package ar.com.miura.jvm.array;

public class Dominoes {
    public int numEquivDominoPairs(int[][] dominoes) {

        java.util.Map<String, Integer> map = new java.util.HashMap<String, Integer>();

        int count = 0;
        for(int[] pair:dominoes) {
            java.util.Arrays.sort(pair);
            String key = pair[0] + "," + pair[1];
            Integer qty = map.getOrDefault(key, 0);
            count+= qty;
            qty++;
            map.put(key, qty);
        }
        return count;
    }
}
