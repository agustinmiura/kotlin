package ar.com.miura.jvm.pq;


/**
 * https://leetcode.com/contest/biweekly-contest-48/problems/second-largest-digit-in-a-string/
 */
public class SecondLargestNumber {
    public int secondHighest(String s) {

        int secondHighest = -1;

        java.util.PriorityQueue<Integer> pq = new java.util.PriorityQueue<Integer>(500, (Integer i0, Integer i1)->{
            return -1*(i0-i1);
        });

        char character;
        for(int i=0;i<s.length();i++) {
            character = s.charAt(i);
            if (Character.isDigit(character)) {

                Integer value = Integer.parseInt(String.valueOf(character));
                if (!pq.contains(value)) {
                    pq.add(value);
                }
            }
        }

        if (pq.size()>=2) {
            Integer largest = pq.poll();
            secondHighest = pq.poll();
        }

        return secondHighest;
    }
}
