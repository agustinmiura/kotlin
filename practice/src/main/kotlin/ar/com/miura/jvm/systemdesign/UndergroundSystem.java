package ar.com.miura.jvm.systemdesign;


/**
 * https://leetcode.com/explore/challenge/card/march-leetcoding-challenge-2021/590/week-3-march-15th-march-21st/3678/
 */
class UndergroundSystem {

    private java.util.Map<Integer, Entry> checkInMap = new java.util.HashMap();

    private java.util.Map<String, Integer[]> travelMap = new java.util.HashMap();

    public UndergroundSystem() {}

    public void checkIn(int id, String stationName, int t) {
        checkInMap.put(id, new Entry(stationName, t));
    }

    public void checkOut(int id, String stationName, int t) {

        //remove the entry of id here
        Entry entry = checkInMap.get(id);
        checkInMap.remove(id);

        //update the average here
        String key = entry.getDestination() + "-" + stationName;

        Integer[] sumQty = travelMap.getOrDefault(key, new Integer[]{0,0});
        sumQty[0]+=(t-entry.getTime());
        sumQty[1]++;
        travelMap.put(key, sumQty);

    }

    public double getAverageTime(String startStation, String endStation) {

        //get the average time here
        String key = startStation + "-" + endStation;
        Integer[] sumQty = travelMap.get(key);
        return ( (double)sumQty[0]/(double)sumQty[1]  );
    }

}

class Entry {

    private String destination;
    private int time;

    public Entry(String destination, int time) {
        this.destination = destination;
        this.time = time;
    }

    public String getDestination() {
        return destination;
    }

    public int getTime() {
        return time;
    }

}
