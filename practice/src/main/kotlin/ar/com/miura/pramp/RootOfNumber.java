package ar.com.miura.pramp;

public class RootOfNumber {

    public static final double PRECISION = 0.001;

    static double root(double x, int n) {

        /**
         * When x is less than 1 the new boundary becomes 1
         */
        double start = 0.0;
        double end = Math.max(x,1);
        double difference = (end - start) + start;

        while (difference > PRECISION) {

            double middle = ((end - start) / 2.0) + start;

            double middlePow = Math.pow(middle, n * 1.0);
            difference = x - middlePow;

            if (middlePow == x) {
                return middle;

            } else if (Math.abs(difference) <= PRECISION) {
                break;

            } else if (difference < 0) {
                end = middle;
                difference = Math.abs(difference);

            } else {
                difference = Math.abs(difference);
                start = middle;

            }
        }
        return (x<1) ? start : end;
    }

}
