package ar.com.miura.jvm.dp;

public class Fibonacci {
    public int fib(int n) {

        if (n==0) {
            return 0;
        } else if (n==1) {
            return 1;
        } else {
            int[] fibo = new int[n+1];
            fibo[0] = 0;
            fibo[1] = 1;
            for(int i = 2;i<=n;i++) {
                fibo[i] = fibo[i-1] + fibo[i-2];
            }
            return fibo[n];

        }

    }
}
