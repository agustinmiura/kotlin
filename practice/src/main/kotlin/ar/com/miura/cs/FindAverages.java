package ar.com.miura.cs;

public class FindAverages {

    int[][] solution(int[][] a) {

        java.util.Map<Double, java.util.List<Integer>> map = new java.util.HashMap();

        int index = -1;
        for(int[] eachArray:a) {
            index++;
            double average = getAverage(eachArray);
            java.util.List<Integer> indexes = map.getOrDefault(average, new java.util.ArrayList());
            indexes.add(index);
            map.put(average, indexes);
        }

        int groupSize = map.size();

        java.util.List<java.util.List<Integer>> lists = new java.util.ArrayList();
        java.util.Set<Double> keySet = map.keySet();
        for(Double average:keySet) {
            java.util.List<Integer> numbers = map.get(average);
            lists.add(numbers);
        }

        java.util.Comparator<java.util.List<Integer>> c = (l1, l2) -> { return (l1.get(0)-l2.get(0)); };
        java.util.Collections.sort(lists, c);

        int[][] solution = new int[groupSize][];
        index = -1;
        for(java.util.List<Integer> numberList:lists) {
            index++;
            int[] intArray = to(numberList);
            solution[index] = intArray;
        }
        return solution;
    }

    private int[] to(java.util.List<Integer> numbers) {
        int[] converted = new int[numbers.size()];
        int index = -1;
        for(Integer eachNumber:numbers) {
            index++;
            converted[index] = eachNumber;
        }
        return converted;
    }

    private double getAverage(int[] intArray) {
        double average = 0.0;
        double sum = 0.0;
        for(Integer i:intArray) {
            sum+= i*1.0;
        }
        return sum/intArray.length;
    }

}
