package ar.com.miura.jvm.dp.frogjump;

public class MemoSolution {
    public boolean canCross(int[] stones) {
        int size = stones.length;
        int[][] memo = new int[size][size];
        for(int[] row:memo) {
            java.util.Arrays.fill(row, -1);
        }

        return canCross(stones, 0, 0, memo)==1;
    }

    private int canCross(int[] stones, int position, int jumpSize, int[][] memo) {

        /*
        Use memo array
        */
        if (memo[position][jumpSize]>=0) {
            return memo[position][jumpSize];
        }

        int size = stones.length;
        for(int i=position+1;i<size;i++) {
            int gap = stones[i] - stones[position];

            int lower = jumpSize-1;
            int upper = jumpSize+1;
            if (gap>=lower && gap<=upper) {
                if (canCross(stones, i, gap, memo)==1) {
                    memo[position][gap] = 1;
                    return 1;
                }
            }
        }
        memo[position][jumpSize] = (position==size-1) ? 1 : 0;
        return (memo[position][jumpSize]);
    }
}
