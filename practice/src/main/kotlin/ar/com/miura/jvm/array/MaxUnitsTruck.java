package ar.com.miura.jvm.array;

public class MaxUnitsTruck {
    public int maximumUnits(int[][] boxTypes, int truckSize) {

        java.util.PriorityQueue<int[]> pq = new java.util.PriorityQueue<int[]>(getComparator());

        for(int[] box:boxTypes) {
            pq.offer(box);
        }

        int toAdd = truckSize;
        int units = 0;
        while(toAdd>=0 && !pq.isEmpty()) {

            int[] box = pq.poll();

            int boxQty = box[0];
            int unitQty = box[1];

            if (boxQty<=toAdd) {
                units += (unitQty*boxQty);
                toAdd = toAdd - boxQty;

            } else {
                //toAdd = 0;
                units += (toAdd * unitQty);
                toAdd = 0;

            }

        }

        return units;

    }

    private java.util.Comparator<int[]> getComparator() {
        java.util.Comparator<int[]> c = (first, second) -> { return (-1 * (first[1] - second[1])); };
        return c;
    }
}
