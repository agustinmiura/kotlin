package ar.com.miura.jvm.array;

public class KidsWithGreatestCandyNumber {
    public java.util.List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = Integer.MIN_VALUE;

        int size = candies.length;
        for(int i=0;i<size;i++) {
            max = Math.max(max, candies[i]);
        }

        Boolean[] checks = new Boolean[size];
        for(int i=0;i<size;i++) {
            if (candies[i]+extraCandies>=max) {
                checks[i]=true;
            } else {
                checks[i]=false;
            }
        }

        java.util.List<Boolean> boolList = java.util.Arrays.asList(checks);
        return boolList;

    }
}
