package ar.com.miura.jvm.dp.frogjump;

public class DpSolution {
    public boolean canCross(int[] stones) {

        java.util.HashMap<Integer, java.util.Set<Integer>> map = new java.util.HashMap<>();
        for(int position:stones) {
            map.put(position, new java.util.HashSet<Integer>());
        }
        map.get(0).add(0);

        /*
        dp[i][j] means I have reached the position "i" , with "j" jumps .
        This means that dp[0] = 0
        For a position we can reach it with step-1 , step and step+1

        We check if can reach each position
        with the avaialable jumps
        */
        int size = stones.length;
        for(int i=0; i<size; i++) {
            int position = stones[i];
            java.util.Set<Integer> jumps = map.getOrDefault(position, new java.util.HashSet<>());
            for(Integer jump:jumps) {
                for(int step=jump-1;step<=jump+1;step++) {
                    if (step>0 && map.containsKey(stones[i]+step)) {
                        map.get(stones[i]+step).add(step);
                    }
                }
            }
        }
        int last = stones[stones.length-1];
        java.util.Set<Integer> jumps = map.getOrDefault(last, new java.util.HashSet<Integer>());
        return jumps.size()>=1;

    }
}
