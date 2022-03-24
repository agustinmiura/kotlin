package ar.com.miura.cs;

public class GetFrequentDigits {

    int[] solution(int[] a) {

        java.util.Map<Integer, Integer> map = new java.util.HashMap<Integer, Integer>();

        int size = a.length;
        for(int i=0; i<size; i++) {
            int number = a[i];
            java.util.List<Integer> digits = getDigits(number);
            for(Integer digit:digits) {
                int count = map.getOrDefault(digit, 0);
                count++;
                map.put(digit, count);
            }
        }

        java.util.Comparator<Integer[]> comparator = (array0, array1) -> {
            return -1 * (array0[1]-array1[1]);
        };

        java.util.PriorityQueue<Integer[]> pq = new java.util.PriorityQueue(comparator);

        Integer max = Integer.MIN_VALUE;
        for(int i=0;i<=9;i++) {

            Integer count = map.getOrDefault(i, 0);

            Integer[] pair = new Integer[2];
            pair[0] = i;
            pair[1] = count;

            max = Math.max(max, count);


        }

        java.util.List<Integer> numbers = new java.util.ArrayList();
        for(int i=0;i<=9;i++) {
            Integer count = map.getOrDefault(i, 0);
            if (count.equals(max)) {
                numbers.add(i);
            }
        }

        size = numbers.size();
        int[] found = new int[size];
        for(int i=0;i<size;i++) {
            found[i] = numbers.get(i);
        }

        return found;
    }

    private java.util.List<Integer> getDigits(Integer number) {
        String asString = number.toString();
        char[] asChar = asString.toCharArray();
        int size = asChar.length;
        java.util.List<Integer> numbers = new java.util.ArrayList();
        for(int i=0;i<size;i++) {
            numbers.add(Character.getNumericValue(asChar[i]));
        }
        return numbers;
    }
}
