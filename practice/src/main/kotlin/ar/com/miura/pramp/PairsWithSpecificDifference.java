package ar.com.miura.pramp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PairsWithSpecificDifference {

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {

        Map<Integer, Integer> numberMap = new HashMap<Integer,Integer>();

        for(int i = 0;i <arr.length; i++) {
            numberMap.put(arr[i], i);
        }

        List<int[]> pairs = new ArrayList<int[]>();

        for(int i=0;i<arr.length;i++) {
            int x = arr[i];
            int y =  x + k;
            if (numberMap.containsKey(y)) {
                pairs.add(new int[]{y,x});
            }
        }

        int size = pairs.size();
        int[][] solution = new int[size][];
        for(int i = 0;i<size;i++) {
            solution[i] = pairs.get(i);
        }
        return solution;
    }

    public static void main(String[] args) {
        System.out.println("Solution");
    }
}
