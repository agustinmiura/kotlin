package ar.com.miura.jvm.permutations;

public class Permutations {

    public java.util.List<java.util.List<Integer>> permute(int[] nums) {

        java.util.List<java.util.List<Integer>> permutations = new java.util.ArrayList<java.util.List<Integer>>();

        java.util.List<Integer> permutation = new java.util.ArrayList<Integer>();

        for(int num:nums) {
            permutation.add(num);
        }

        int size = nums.length;
        backtrack(size, permutation, permutations, 0);

        return permutations;

    }

    private void backtrack(
            int n,
            java.util.List<Integer> permutation,
            java.util.List<java.util.List<Integer>> permutations,
            int index) {

        if (index==n) {
            permutations.add(new java.util.ArrayList<Integer>(permutation));
        }

        for(int i=index;i<n;i++) {
            java.util.Collections.swap(permutation, i,index);
            backtrack(n, permutation, permutations, index+1);
            java.util.Collections.swap(permutation, i,index);
        }

    }

}
