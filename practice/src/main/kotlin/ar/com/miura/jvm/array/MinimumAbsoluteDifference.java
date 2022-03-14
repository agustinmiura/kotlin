package ar.com.miura.jvm.array;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {

        int[] cloned = arr.clone();
        Arrays.sort(cloned);

        int size = arr.length;
        int minDiff = Integer.MAX_VALUE;
        for(int i=1;i<size;i++) {
            minDiff = Math.min(minDiff, Math.abs(cloned[i]-cloned[i-1]));
        }

        List<List<Integer>> pairs = new ArrayList();
        for(int i=1;i<size;i++) {
            if (Math.abs(cloned[i]-cloned[i-1])==minDiff) {
                List<Integer> list = new ArrayList();
                list.add(cloned[i-1]);
                list.add(cloned[i]);
                pairs.add(list);
            }
        }
        return pairs;

    }
}
