package java.ar.com.miura.array;

public class RankTransform {
    public int[] arrayRankTransform(int[] arr) {

        if (arr.length==0) {
            return arr;
        }


        int size = arr.length;
        int[] sorted = java.util.Arrays.copyOf(arr, size);
        java.util.Arrays.sort(sorted);

        /*
        Get the rank for each number
        */
        java.util.Map<Integer, Integer> rankMap = new java.util.HashMap<Integer, Integer>();
        int rank = 1;
        rankMap.put(sorted[0], 1);
        for(int i=1;i<size;i++) {
            if (sorted[i-1]<sorted[i]) {
                rank++;
                rankMap.put(sorted[i], rank);
            }
        }

        for(int i=0;i<size;i++) {
            int number = arr[i];
            rank = rankMap.getOrDefault(number, -1);
            sorted[i] = rank;
        }
        return sorted;

    }
}
