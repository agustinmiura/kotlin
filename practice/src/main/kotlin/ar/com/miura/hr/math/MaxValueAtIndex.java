package ar.com.miura.hr.math;

public class MaxValueAtIndex {
    static int maxValueAtIndexK(int N, int K, int M) {
        int left = 0;
        int right = 0;
        left = K * (K + 1) / 2;
        right = (N - K - 1) * (N - K) / 2;
        return (M + left + right) / N;
    }
}
