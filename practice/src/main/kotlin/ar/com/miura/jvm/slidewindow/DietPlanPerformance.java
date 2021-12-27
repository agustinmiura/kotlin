package ar.com.miura.jvm.slidewindow;

public class DietPlanPerformance {
    public int dietPlanPerformance(int[] calories, int k, int lower, int upper) {

        int points = 0;
        int size = calories.length;

        for(int i=0;i<size-k+1;i++) {

            int sum = 0;
            for(int j=0; j<k && i+j<size ;j++) {
                sum += calories[i+j];
            }
            if (sum<lower) {
                points = points - 1;
            } else if (sum>upper) {
                points++;
            }

        }

        return points;
    }
}
