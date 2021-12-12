package ar.com.miura.lc.backtracking;

public class Combinations {
    public java.util.List<java.util.List<Integer>> combine(int n, int k) {
        java.util.List<java.util.List<Integer>> combinations = new java.util.LinkedList();
        if (k==0) {
            combinations.add(new java.util.LinkedList());
            return combinations;
        }
        backtrack(1, new java.util.LinkedList<Integer>(), n, k, combinations);
        return combinations;
    }

    private void backtrack(
            int start,
            java.util.List<Integer> current ,
            int n,
            int k,
            java.util.List<java.util.List<Integer>> combinations) {

        if (current.size()==k) {
            combinations.add(new java.util.LinkedList(current));
        }

        for(int i=start;i<=n;i++) {
            current.add(i);
            backtrack(i+1, current, n, k, combinations);
            java.util.LinkedList<Integer> list = (java.util.LinkedList)current;
            list.removeLast();
        }

    }
}
