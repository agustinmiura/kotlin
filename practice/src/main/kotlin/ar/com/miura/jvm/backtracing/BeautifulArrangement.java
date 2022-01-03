package ar.com.miura.jvm.backtracing;

/**
 * https://leetcode.com/problems/beautiful-arrangement/
 * Suppose you have n integers labeled 1 through n. A permutation of those n integers perm (1-indexed) is considered a beautiful arrangement if for every i (1 <= i <= n), either of the following is true:
 *
 * perm[i] is divisible by i.
 * i is divisible by perm[i].
 * Given an integer n, return the number of the beautiful arrangements that you can construct.
 *
 */
public class BeautifulArrangement {
    public int countArrangement(int n) {
        java.util.Set<String> combinations = new java.util.HashSet<String>();
        backtrack(n, combinations);
        return combinations.size();
    }

    private void backtrack(int n, java.util.Set<String> combinations) {
        int[] perm = new int[n+1];
        for(int i=1;i<=n;i++) {
            perm[1] = i;
            if (isValidPerm(perm, 1)) {
                backtrack(perm, 2, combinations);
            }
            perm[1] = 0;
        }
    }

    private void backtrack(int[] permutations, int index, java.util.Set<String> combinations) {

        if (index>=permutations.length) {
            combinations.add(java.util.Arrays.toString(permutations));
            return;
        }

        java.util.Set<Integer> usedNumbers = new java.util.HashSet<Integer>();
        for(int i=1;i<index;i++) {
            usedNumbers.add(permutations[i]);
        }

        for(int i=1;i<permutations.length;i++) {
            if ( !usedNumbers.contains(i) ) {

                permutations[index] = i;

                if (isValidPerm(permutations, index)) {
                    backtrack(permutations, index+1, combinations);
                }
                permutations[index] = 0;
            }
        }

    }

    private boolean isValidPerm(int[] permutations, int index) {
        for(int i=1;i<=index;i++) {
            if ( !(permutations[i]%i==0 || i%permutations[i]==0) ) {
                return false;
            }
        }
        return true;
    }
}
