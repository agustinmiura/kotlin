package ar.com.miura.lc.array;

public class MaxDistanceClosestPerson {
    public int maxDistToClosest(int[] seats) {
        int size = seats.length;
        int[] left = new int[size];
        int[] right = new int[size];

        java.util.Arrays.fill(left, size);
        java.util.Arrays.fill(right, size);

        if (seats[0]==1) {
            left[0] = 0;
        }
        for(int i=1;i<size;i++) {
            if (seats[i]==1) {
                left[i] = 0;
            } else {
                left[i] = left[i-1] + 1;
            }
        }

        if (seats[size-1]==1) {
            right[size-1] = 0;
        }
        int index = size-2;
        while(index>=0) {
            if (seats[index]==1) {
                right[index] = 0;
            } else {
                right[index] = right[index+1] + 1;
            }
            index--;
        }

        int max = Integer.MIN_VALUE;
        for(int i=0;i<size;i++) {
            if (seats[i]==0) {
                max = Math.max(max, Math.min(left[i], right[i]));
            }

        }
        return max;
    }
}
