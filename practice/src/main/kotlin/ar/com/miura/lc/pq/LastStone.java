package ar.com.miura.lc.pq;

public class LastStone {
    public int lastStoneWeight(int[] stones) {

        int size = stones.length;
        if (size==1) {
            return 1;
        }

        /*
        Fill pq
        */
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue(getComparator());
        for(int i=0;i<size;i++) {
            pq.offer(stones[i]);
        }

        while(pq.size()>=2) {

            Integer first = pq.poll();
            Integer second = pq.poll();

            Integer diff = first-second;
            pq.offer(Math.abs(diff));

        }

        if (!pq.isEmpty()) {
            return pq.poll();
        } else {
            return 0;
        }


    }

    private java.util.Comparator<Integer> getComparator() {
        java.util.Comparator<Integer> comparator = (i0, i1) -> {
            return -1*(i0-i1);
        };
        return comparator;
    }
}
