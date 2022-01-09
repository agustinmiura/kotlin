package ar.com.miura.jvm.greedy;

class CourseInfo implements java.util.Comparator<Integer[]> {
    public int compare(Integer[] x, Integer[] y) {
        double xDiff = (double)(x[0]+1)/(double)(x[1]+1);
        xDiff -= (double)x[0]/x[1];

        double yDiff = (double)(y[0]+1)/(double)(y[1]+1);
        yDiff -= (double)y[0]/(double)y[1];

        return (xDiff > yDiff) ? -1 : 1;
    }
}
