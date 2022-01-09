package ar.com.miura.jvm.graph;


/**
 * https://leetcode.com/problems/number-of-provinces/
 */
public class NumberOfProvinces {

    public int findCircleNum(int[][] M) {
        java.util.Set<Integer> visited = new java.util.TreeSet<>();
        int count = 0;
        for(int i=0;i<M.length;i++) {
            /**
             * For each person visit all the friends
             * and friends of friends
             */
            if (!visited.contains(i)) {
                bfsFriends(M, i, visited);
                count++;
            }
        }
        return count;
    }

    private void bfsFriends(int[][] m, int i, java.util.Set<Integer> visited) {
        visited.add(i);
        for(int j=0;j<m.length;j++) {
            if (m[i][j]==1&&(!visited.contains(j))) {
                visited.add(j);
                /**
                 * If they are friends check with the other friends
                 */
                bfsFriends(m, j, visited);
            }
        }
    }
}
