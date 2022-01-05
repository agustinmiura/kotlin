package ar.com.miura.jvm.array;

public class HighFive {
    public int[][] highFive(int[][] items) {

        java.util.Map<Integer, java.util.PriorityQueue<Integer>> map = new java.util.TreeMap<Integer, java.util.PriorityQueue<Integer>>();
        for(int[] item:items) {
            int id = item[0];
            int points = item[1];

            java.util.PriorityQueue<Integer> pq = map.getOrDefault(id, getPq());
            pq.offer(points);
            map.put(id, pq);
        }

        int size = map.size();
        int[][] answer = new int[size][2];

        java.util.Set<Integer> keys = map.keySet();

        int index = -1;
        for(Integer eachKey:keys) {
            index++;

            int average = 0;
            java.util.PriorityQueue<Integer> pq = map.getOrDefault(eachKey, getPq());
            int count = 0;
            int acum = 0;
            while(count<5 && !pq.isEmpty()) {
                acum += pq.poll();
                count++;
            }
            average = acum/5;
            answer[index][0] = eachKey;
            answer[index][1] = average;

        }

        return answer;

    }

    private java.util.PriorityQueue<Integer> getPq() {
        java.util.Comparator<Integer> c = (i1, i2) -> { return (-1 * (i1-i2)); };
        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(c);
        return pq;
    }
}
