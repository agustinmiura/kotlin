package java.ar.com.miura.array;

public class DistributeCandies {
    public int distributeCandies(int[] candyType) {

        java.util.Set<Integer> candies = new java.util.HashSet<Integer>();

        for(int type:candyType) {
            candies.add(type);
        }

        return Math.min(candies.size(), candyType.length/2);

    }
}
