package ar.com.miura.jvm.dp;

public class TribonacciTopDown {

    private java.util.HashMap<Integer, Integer> memo = new java.util.HashMap<Integer, Integer>();

    public int tribonacci(int n) {

        if (n==0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else if (n==2) {
            return 1;
        }

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        memo.put(n, tribonacci(n-1) + tribonacci(n-2) + tribonacci(n-3));

        return memo.get(n);
    }

}
