package ar.com.miura.jvm.systemdesign;

public class HitCounter {
    private java.util.SortedMap<Integer, Integer> hitMap = new java.util.TreeMap();
    public HitCounter() {
    }
    public void hit(int timestamp) {
        Integer counter = hitMap.getOrDefault(timestamp, 0);
        counter++;
        hitMap.put(timestamp, counter);
    }
    public int getHits(int timestamp) {
        java.util.Iterator<Integer> iterator = hitMap.keySet().iterator();
        int count = 0;
        Integer upper = timestamp;
        Integer lower = Math.max(0, upper-300);
        while(iterator.hasNext()) {
            Integer key = iterator.next();
            if (key.compareTo(lower)>0 && key.compareTo(upper)<=0) {
                count += hitMap.get(key);
            }
        }
        return count;
    }
}
