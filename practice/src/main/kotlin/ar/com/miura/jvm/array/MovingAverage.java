package ar.com.miura.jvm.array;

public class MovingAverage {
    private java.util.LinkedList<Integer> numbers = new java.util.LinkedList<Integer>();

    private int maxSize;

    public MovingAverage(int size) {
        this.maxSize = size;
    }

    public double next(int val) {

        numbers.add(val);
        while(numbers.size()>=(maxSize+1)) {
            numbers.removeFirst();
        }

        int sum = 0;
        int size = numbers.size();

        for(int i=0;i<numbers.size();i++) {
            sum += numbers.get(i);
        }

        return (sum*1.0)/(size*1.0);
    }
}
